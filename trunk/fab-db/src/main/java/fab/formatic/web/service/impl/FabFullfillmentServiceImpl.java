package fab.formatic.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.service.FabOrderService;
import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.OrderInputOutput;
import fab.formatic.web.dto.OutAttr;
import fab.formatic.web.dto.Package;
import fab.formatic.web.dto.ServiceAttr;
import fab.formatic.web.dto.Trans;
import fab.formatic.web.dto.exception.OrderringException;
import fab.formatic.web.service.FabFullfillmentService;
import fab.formatic.web.util.FabWSHelper;

@Service(FabWSHelper.FULLFILLMENT_SERVICE)
public class FabFullfillmentServiceImpl implements FabFullfillmentService {
	
	
	@Autowired
	private FabOrderService orderService;
	
	public OrderInputOutput orderInput(String accountID, Module module,
			Package _package, List<ServiceAttr> serviceAttr, String serviceID,
			String sessionID, String transType) throws OrderringException {
		
		String transID="transId"+serviceID;
		OrderInputOutput output=new OrderInputOutput();
		FabOrder order=orderService.orderInput(accountID, module, _package, serviceAttr, serviceID, sessionID, transType, transID);
		if(order==null){
			output.setOutMsg("failed to input order");
			output.setOutStatus(false);
			output.setOutAttr(null);
			throw new OrderringException(output.getOutMsg());
		}
		OutAttr oa=new OutAttr();
		oa.setName("order");
		oa.setValue(order.getTransID());
		output.setOutStatus(true);
		output.setOutMsg("order input success");
		output.setOutAttr(oa);
		return output;
	}

	public Trans orderTracking(String accountID, String serviceID,
			String sessionID, String transID) throws OrderringException {
		Trans trans=new Trans();
		FabOrder order=orderService.trackOrder(accountID, serviceID, transID);
		if(order==null){
			trans.setTransStatus("failed to retrieve order");
			throw new OrderringException(trans.getTransStatus());
		}
		trans.setTransDate(order.getTransDate().toString());
		trans.setTransType(order.getTransType().toString());
		trans.setTransStatus(order.getTransStatus());
		trans.setTransDesc(order.getTransDesc());
		return trans;
	}

}
