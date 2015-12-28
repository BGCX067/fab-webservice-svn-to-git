package fab.formatic.web.service.impl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.service.FabCustomerOrderService;
import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.OrderInputOutput;
import fab.formatic.web.dto.OutAttr;
import fab.formatic.web.dto.Package;
import fab.formatic.web.dto.ServiceAttr;
import fab.formatic.web.dto.Trans;
import fab.formatic.web.service.FabFullfillmentService;
import fab.formatic.web.util.FabWSConstant;

@Service(FabWSConstant.INBOUND_FULLFILLMENT_SERVICE)
public class FabInboundFullfillmentService implements FabFullfillmentService {

	@Autowired
	private FabCustomerOrderService customerOrderService;

	public OrderInputOutput orderInput(String accountID, Module module,
			Package paket, List<ServiceAttr> serviceAttrs, String serviceID,
			String sessionID, String transType, String transID) {

		FabOrder order = customerOrderService.inputOrder(accountID, module,
				paket, serviceAttrs, serviceID, sessionID, transType, transID);
		OrderInputOutput output = new OrderInputOutput();
		if (order != null) {
			OutAttr attr = new OutAttr();
			attr.setName("order from: " + order.getFabCustomer().getAccountID());
			attr.setValue("order details: "
					+ order.getFabService().getServiceName());
			output.setOutMsg("success");
			output.setOutStatus(true);
			output.setOutAttr(attr);
		} else {
			output.setOutMsg("failed");
			output.setOutStatus(false);
			output.setOutAttr(null);
		}
		return output;
	}

	public List<Trans> orderTracking(String accountID, String serviceID,
			String sessionID, String transID) {
		List<FabOrder> orders = customerOrderService.getOrder(accountID,
				serviceID, sessionID, transID);
		List<Trans> trans = new ArrayList<Trans>();
		if (orders != null && orders.size() > 0) {
			for (FabOrder order : orders) {
				Trans t = new Trans();
				t.setTransDate(DateFormat.getInstance().format(
						order.getOrderDate()));
				t.setTransType(order.getTransType());
				t.setTransStatus(order.getFabStatusOrder().getStatusOrderName());
				t.setTransDesc("ordered by: "
						+ order.getFabCustomer().getAccountID());
				trans.add(t);
			}
		} else {
			Trans t = new Trans();
			t.setTransDesc("no orders found");
			trans.add(t);
		}
		return trans;
	}

}
