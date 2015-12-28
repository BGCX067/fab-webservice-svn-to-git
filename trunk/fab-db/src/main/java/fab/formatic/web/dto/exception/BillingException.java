package fab.formatic.web.dto.exception;

import javax.xml.soap.SOAPException;
import javax.xml.ws.WebFault;

@WebFault
public class BillingException extends SOAPException {

	private static final long serialVersionUID = -8624034426576673813L;

	public BillingException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillingException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public BillingException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	

}
