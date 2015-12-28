package fab.formatic.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.dao.FabServiceUsedDao;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 *
 */
@Service(FabBackendHelper.OUTBOUND_BILLING_SERVICE)
public class FabOutboundBillingServiceImpl implements FabOutboundBillingService {
	
	@Autowired
	private FabServiceDao serviceDao;
	
	@Autowired
	private FabOrderDao orderDao;
	
	@Autowired
	private FabServiceUsedDao serviceUsedDao; 

	@Transactional
	public FabServiceUsed billTransaction(String transID, String accountID,
			Integer serviceUsedID, Integer transAmount, double discAmount,
			boolean charged) {
		List<FabOrder> orders=orderDao.findByAccountID(accountID);
		FabOrder od=orderDao.findByTransID(transID);
		FabOrder diolah=null;
		for(FabOrder o:orders){
			if(o.getId()==od.getId()){
				diolah=o;
			}
		}
		FabServiceUsed fsu=serviceUsedDao.find(serviceUsedID);
		if(!(fsu.getFabOrder().getId()==diolah.getId())){
			return null;
		}
		if(charged==false){
			fsu.setBillStatus(4);
		}else{
			fsu.setBillStatus(fsu.getBillStatus());
		}
		
		fsu.setDiscountAmount(discAmount);
		fsu.setTransAmount(transAmount);
		
		return serviceUsedDao.merge(fsu);
	}

	public List<FabServiceUsed> getBillingData(String accountID, String period,
			int serviceID) {
		FabService service=serviceDao.find(Integer.valueOf(serviceID));
		List<FabOrder> orders=orderDao.findByAccountID(accountID);
		FabOrder res=null;
		for(FabOrder o:orders){
			if(o.getFabService().getId()==service.getId()){
				res=o;
			}
		}
		return serviceUsedDao.findByFabOrder(res);
		
	}

}
