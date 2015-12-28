
package fab.formatic.web.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getBillingDataOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getBillingDataOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="billingdata" type="{http://fab/}billingData" minOccurs="0"/>
 *         &lt;element name="outMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBillingDataOutput", propOrder = {
    "billingdata",
    "outMsg"
})
public class GetBillingDataOutput {

    protected BillingData billingdata;
    protected String outMsg;

    /**
     * Gets the value of the billingdata property.
     * 
     * @return
     *     possible object is
     *     {@link BillingData }
     *     
     */
    public BillingData getBillingdata() {
        return billingdata;
    }

    /**
     * Sets the value of the billingdata property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingData }
     *     
     */
    public void setBillingdata(BillingData value) {
        this.billingdata = value;
    }

    /**
     * Gets the value of the outMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutMsg() {
        return outMsg;
    }

    /**
     * Sets the value of the outMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutMsg(String value) {
        this.outMsg = value;
    }

}
