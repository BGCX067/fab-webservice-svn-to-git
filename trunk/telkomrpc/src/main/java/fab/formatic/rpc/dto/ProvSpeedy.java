package fab.formatic.rpc.dto;

import java.io.Serializable;
import java.util.Arrays;

public class ProvSpeedy implements Serializable{


	private static final long serialVersionUID = 952271177379823784L;
	
	private String transType;
	
	private String transID;
	
	private String paketID;
	
	private String promoID;
	
	private String accountID;
	
	private AttrPaket[] attrPaket;
	
	private AttrUser[] attrUser;
	
	private AttrContact[] attrContact;
	
	private BillingAnchor[] billingAnchor;
	
	private Response response;
	
	public ProvSpeedy(){}

	public ProvSpeedy(String transType, String transID, String paketID,
			String promoID, String accountID, AttrPaket[] attrPaket,
			AttrUser[] attrUser, AttrContact[] attrContact,
			BillingAnchor[] billingAnchor, Response response) {
		this.transType = transType;
		this.transID = transID;
		this.paketID = paketID;
		this.promoID = promoID;
		this.accountID = accountID;
		this.attrPaket = attrPaket;
		this.attrUser = attrUser;
		this.attrContact = attrContact;
		this.billingAnchor = billingAnchor;
		this.response = response;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getTransID() {
		return transID;
	}

	public void setTransID(String transID) {
		this.transID = transID;
	}

	public String getPaketID() {
		return paketID;
	}

	public void setPaketID(String paketID) {
		this.paketID = paketID;
	}

	public String getPromoID() {
		return promoID;
	}

	public void setPromoID(String promoID) {
		this.promoID = promoID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public AttrPaket[] getAttrPaket() {
		return attrPaket;
	}

	public void setAttrPaket(AttrPaket[] attrPaket) {
		this.attrPaket = attrPaket;
	}

	public AttrUser[] getAttrUser() {
		return attrUser;
	}

	public void setAttrUser(AttrUser[] attrUser) {
		this.attrUser = attrUser;
	}

	public AttrContact[] getAttrContact() {
		return attrContact;
	}

	public void setAttrContact(AttrContact[] attrContact) {
		this.attrContact = attrContact;
	}

	public BillingAnchor[] getBillingAnchor() {
		return billingAnchor;
	}

	public void setBillingAnchor(BillingAnchor[] billingAnchor) {
		this.billingAnchor = billingAnchor;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountID == null) ? 0 : accountID.hashCode());
		result = prime * result + Arrays.hashCode(attrContact);
		result = prime * result + Arrays.hashCode(attrPaket);
		result = prime * result + Arrays.hashCode(attrUser);
		result = prime * result + Arrays.hashCode(billingAnchor);
		result = prime * result + ((paketID == null) ? 0 : paketID.hashCode());
		result = prime * result + ((promoID == null) ? 0 : promoID.hashCode());
		result = prime * result
				+ ((response == null) ? 0 : response.hashCode());
		result = prime * result + ((transID == null) ? 0 : transID.hashCode());
		result = prime * result
				+ ((transType == null) ? 0 : transType.hashCode());
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
		ProvSpeedy other = (ProvSpeedy) obj;
		if (accountID == null) {
			if (other.accountID != null)
				return false;
		} else if (!accountID.equals(other.accountID))
			return false;
		if (!Arrays.equals(attrContact, other.attrContact))
			return false;
		if (!Arrays.equals(attrPaket, other.attrPaket))
			return false;
		if (!Arrays.equals(attrUser, other.attrUser))
			return false;
		if (!Arrays.equals(billingAnchor, other.billingAnchor))
			return false;
		if (paketID == null) {
			if (other.paketID != null)
				return false;
		} else if (!paketID.equals(other.paketID))
			return false;
		if (promoID == null) {
			if (other.promoID != null)
				return false;
		} else if (!promoID.equals(other.promoID))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (transID == null) {
			if (other.transID != null)
				return false;
		} else if (!transID.equals(other.transID))
			return false;
		if (transType == null) {
			if (other.transType != null)
				return false;
		} else if (!transType.equals(other.transType))
			return false;
		return true;
	}
	
	
	
	
	

}
