package fab.formatic.web.dto.exception;

import javax.xml.soap.SOAPException;
import javax.xml.ws.WebFault;

@WebFault
public class OrderringException extends SOAPException{

	private static final long serialVersionUID = 1238017339815271776L;

	public OrderringException(String reason, Throwable cause) {
		super(reason, cause);
		// TODO Auto-generated constructor stub
	}

	public OrderringException(String reason) {
		super(reason);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	
}
