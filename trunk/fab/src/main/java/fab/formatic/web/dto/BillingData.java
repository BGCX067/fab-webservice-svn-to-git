
package fab.formatic.web.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for billingData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="billingData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://fab/}number" minOccurs="0"/>
 *         &lt;element name="discAmount" type="{http://fab/}number" minOccurs="0"/>
 *         &lt;element name="isPaid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="revCodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "billingData", propOrder = {
    "amount",
    "discAmount",
    "isPaid",
    "period",
    "productName",
    "revCodeName"
})
public class BillingData {

    protected Number amount;
    protected Number discAmount;
    protected boolean isPaid;
    protected String period;
    protected String productName;
    protected String revCodeName;

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Number }
     *     
     */
    public Number getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Number }
     *     
     */
    public void setAmount(Number value) {
        this.amount = value;
    }

    /**
     * Gets the value of the discAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Number }
     *     
     */
    public Number getDiscAmount() {
        return discAmount;
    }

    /**
     * Sets the value of the discAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Number }
     *     
     */
    public void setDiscAmount(Number value) {
        this.discAmount = value;
    }

    /**
     * Gets the value of the isPaid property.
     * 
     */
    public boolean isIsPaid() {
        return isPaid;
    }

    /**
     * Sets the value of the isPaid property.
     * 
     */
    public void setIsPaid(boolean value) {
        this.isPaid = value;
    }

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriod(String value) {
        this.period = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the revCodeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevCodeName() {
        return revCodeName;
    }

    /**
     * Sets the value of the revCodeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevCodeName(String value) {
        this.revCodeName = value;
    }

}
