package fab.formatic.backend.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.dao.FabModuleDao;
import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.dao.FabPackageDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.dao.FabServiceUsedDao;
import fab.formatic.backend.dao.FabTariffDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.domain.enumerate.FabTransactionType;
import fab.formatic.backend.service.FabOrderService;
import fab.formatic.backend.util.FabBackendHelper;
import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.Package;
import fab.formatic.web.dto.ServiceAttr;

@Service(FabBackendHelper.ORDER_SERVICE)
public class FabOrderServiceImpl implements FabOrderService {
	
	@Autowired
	private FabCustomerDao customerDao;
	
	@Autowired
	private FabServiceDao serviceDao;

	@Autowired
	private FabPackageDao packageDao;
	
	@Autowired
	private FabModuleDao moduleDao;
	
	@Autowired
	private FabTariffDao tariffDao;
	
	@Autowired
	private FabOrderDao orderDao;
	
	@Autowired
	private FabServiceUsedDao serviceUsedDao;
	
	public FabOrder orderInput(String accountID, Module module, Package paket,
			List<ServiceAttr> serviceAttr, String serviceID, String sessionID,
			String transType, String transID) {
		
		FabCustomer fc=customerDao.findByAccountID(accountID);
		FabService fs = serviceDao.findByServiceID(serviceID);
		if(fc==null && fc==null){ return null;}
		FabOrder order=new FabOrder();
		FabServiceUsed serviceUsed=new FabServiceUsed();
		double payment=0.0;
		order.setFabService(fs);
		order.setFabCustomer(fc);
		
		FabPackage fp = packageDao.findByPackageName(paket.getName());
		if(!fp.getFabService().equals(fs)){
			fp.setFabService(fs);
			packageDao.merge(fp);
		}
		
		FabModule fm = null;
		if (!StringUtils.isEmpty(module.getName())) {
			fm = moduleDao.findByModuleName(module.getName());
			if(fm!=null){
				if(!fp.getFabModules().contains(fm)){
					fm.getFabPackages().add(fp);
					moduleDao.merge(fm);
				}
			}
		}
		order.setTransDate(new Date());
		order.setTransType(order.getTransType().fromString(transType));
		order.setTransID(transID);
		order.setTransStatus("success");
		order.setTransDesc("success di order");
		orderDao.persist(order);
		
		if(order.getTransType().equals(FabTransactionType.TERMINATION)){
			fc.setServiceCount(fc.getServiceCount()-1);
			fc.setServiceAmount(fc.getServiceAmount()-1);
		}else{
			fc.setServiceCount(fc.getServiceCount()+1);
			fc.setServiceAmount(fc.getServiceAmount()+1);
		}
		customerDao.merge(fc);
		
		switch(order.getTransType()){
		case ACTIVATION:
			payment+=calculateActivationPayment(fs);
			serviceUsed.setBillStatus(1);
			break;
		case RESUMPTION:
			payment+=calculateResumptionPayment(fs);serviceUsed.setBillStatus(1);
			break;
		case TERMINATION:
			payment+=calculateTerminationPayment(fs);
			serviceUsed.setBillStatus(0);
			break;
		}
		serviceUsed.setPaymentAmount((int)payment);
		serviceUsed.setFabOrder(order);
		serviceUsedDao.persist(serviceUsed);
		
		return orderDao.findByTransID(transID);
	}

	public FabOrder trackOrder(String accountID, String serviceID,
			String transID) {
		FabOrder transOrder = orderDao.findByTransID(transID);
		return transOrder;
	}
	
	
	protected double calculateActivationPayment(FabService service){
		double activationPayment=0.0;
		double serviceTariff=tariffDao.findByLastDate(service).getInitiationFee();
		for(FabPackage fp:packageDao.findByService(service)){
			activationPayment+=tariffDao.findByLastDate(fp).getInitiationFee();
			for(FabModule fm:packageDao.findByPackageName(fp.getPackageName()).getFabModules()){
				activationPayment+=tariffDao.findByLastDate(fm).getInitiationFee();
			}
		}
		activationPayment=activationPayment+serviceTariff;
		return activationPayment;
	}
	
	protected double calculateResumptionPayment(FabService service){
		double activationPayment=0.0;
		double serviceTariff=tariffDao.findByLastDate(service).getReccuringFee();
		for(FabPackage fp:packageDao.findByService(service)){
			activationPayment+=tariffDao.findByLastDate(fp).getReccuringFee();
			for(FabModule fm:packageDao.findByPackageName(fp.getPackageName()).getFabModules()){
				activationPayment+=tariffDao.findByLastDate(fm).getReccuringFee();
			}
		}
		activationPayment=activationPayment+serviceTariff;
		return activationPayment;
	}
	
	protected double calculateTerminationPayment(FabService service){
		double activationPayment=0.0;
		double serviceTariff=tariffDao.findByLastDate(service).getTerminationFee();
		for(FabPackage fp:packageDao.findByService(service)){
			activationPayment+=tariffDao.findByLastDate(fp).getTerminationFee();
			for(FabModule fm:packageDao.findByPackageName(fp.getPackageName()).getFabModules()){
				activationPayment+=tariffDao.findByLastDate(fm).getTerminationFee();
			}
		}
		activationPayment=activationPayment+serviceTariff;
		return activationPayment;
	}

}
