
package fab.formatic.web.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderInputOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderInputOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outAttr" type="{http://fab/}outAttr" minOccurs="0"/>
 *         &lt;element name="outMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outStatus" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderInputOutput", propOrder = {
    "outAttr",
    "outMsg",
    "outStatus"
})
public class OrderInputOutput {

    protected OutAttr outAttr;
    protected String outMsg;
    protected boolean outStatus;

    /**
     * Gets the value of the outAttr property.
     * 
     * @return
     *     possible object is
     *     {@link OutAttr }
     *     
     */
    public OutAttr getOutAttr() {
        return outAttr;
    }

    /**
     * Sets the value of the outAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutAttr }
     *     
     */
    public void setOutAttr(OutAttr value) {
        this.outAttr = value;
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

    /**
     * Gets the value of the outStatus property.
     * 
     */
    public boolean isOutStatus() {
        return outStatus;
    }

    /**
     * Sets the value of the outStatus property.
     * 
     */
    public void setOutStatus(boolean value) {
        this.outStatus = value;
    }

}
