package fab.formatic.web.dto.exception;

import javax.xml.soap.SOAPException;
import javax.xml.ws.WebFault;

@WebFault
public class ServiceOutputException extends SOAPException {


	private static final long serialVersionUID = 557572445788925714L;

	public ServiceOutputException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceOutputException(String reason, Throwable cause) {
		super(reason, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceOutputException(String reason) {
		super(reason);
		// TODO Auto-generated constructor stub
	}
	
	

}
