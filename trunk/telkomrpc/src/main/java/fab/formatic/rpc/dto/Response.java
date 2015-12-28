package fab.formatic.rpc.dto;

import java.io.Serializable;

public class Response implements Serializable{


	private static final long serialVersionUID = 8234883774757654670L;
	
	private String statusCode;
	
	private String strMessage;
	
	public Response(){}
	
	public Response(String statusCode, String strMessage){
		this.statusCode=statusCode;
		this.strMessage=strMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStrMessage() {
		return strMessage;
	}

	public void setStrMessage(String strMessage) {
		this.strMessage = strMessage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result
				+ ((strMessage == null) ? 0 : strMessage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (strMessage == null) {
			if (other.strMessage != null)
				return false;
		} else if (!strMessage.equals(other.strMessage))
			return false;
		return true;
	}
	
	

}
