package fab.formatic.web.service;

import java.util.ArrayList;
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
import fab.formatic.web.util.FabWSHelper;

/**
 * @author gilang
 *
 */
@Service(FabWSHelper.FULLFILLMENT_SERVICE)
public class FabFullfillmentServiceImpl implements FabFullfillmentService {

	@Autowired
	private FabOrderService orderService;

	public OrderInputOutput orderInput(String accountID, Module module,
			Package paket, List<ServiceAttr> serviceAttr, String serviceID,
			String sessionID, String transType, String transID) {
		if (sessionID == null) {
			throw new RuntimeException();
		}
		OrderInputOutput output = new OrderInputOutput();
		FabOrder order = orderService.orderInput(accountID, module, paket,
				serviceAttr, serviceID, sessionID, transType, transID);
		if (order != null) {
			OutAttr attr = new OutAttr();
			attr.setName("order from: ");
			attr.setValue(order.getFabCustomer().getAccountID() + " "
					+ order.getFabService().getServiceName());

			output.setOutStatus(true);
			output.setOutMsg("sukscute");
			output.setOutAttr(attr);
		} else {
			output.setOutStatus(false);
			output.setOutMsg("gagal");
		}

		return output;
	}

	public List<Trans> orderTracking(String accountID, String serviceID,
			String sessionID, String transID) {
		List<Trans> trans = new ArrayList<Trans>();
		FabOrder order = orderService.trackOrder(accountID, serviceID, transID);
		if (order == null) {
			return null;
		}
		Trans t = new Trans();
		t.setTransDate(order.getTransDate().toString());
		t.setTransStatus(order.getTransStatus());
		t.setTransDesc(order.getTransDesc());
		t.setTransType(order.getTransType().toString());

		trans.add(t);
		return trans;
	}

}
