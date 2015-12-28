
package fab.formatic.web.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for tarrifList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tarrifList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="initiationFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isToBeBilled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="periodUnit" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="quantity" type="{http://fab/}number" minOccurs="0"/>
 *         &lt;element name="recurringFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="salesEnd" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="salesStart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="serviceID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serviceUnit" type="{http://fab/}number" minOccurs="0"/>
 *         &lt;element name="terminationFee" type="{http://fab/}number" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tarrifList", propOrder = {
    "initiationFee",
    "isToBeBilled",
    "period",
    "periodUnit",
    "quantity",
    "recurringFee",
    "salesEnd",
    "salesStart",
    "serviceID",
    "serviceUnit",
    "terminationFee"
})
public class TarrifList {

    protected String initiationFee;
    protected boolean isToBeBilled;
    protected int period;
    @XmlSchemaType(name = "unsignedShort")
    protected int periodUnit;
    protected Number quantity;
    protected String recurringFee;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar salesEnd;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar salesStart;
    protected int serviceID;
    protected Number serviceUnit;
    protected Number terminationFee;

    /**
     * Gets the value of the initiationFee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitiationFee() {
        return initiationFee;
    }

    /**
     * Sets the value of the initiationFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitiationFee(String value) {
        this.initiationFee = value;
    }

    /**
     * Gets the value of the isToBeBilled property.
     * 
     */
    public boolean isIsToBeBilled() {
        return isToBeBilled;
    }

    /**
     * Sets the value of the isToBeBilled property.
     * 
     */
    public void setIsToBeBilled(boolean value) {
        this.isToBeBilled = value;
    }

    /**
     * Gets the value of the period property.
     * 
     */
    public int getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     */
    public void setPeriod(int value) {
        this.period = value;
    }

    /**
     * Gets the value of the periodUnit property.
     * 
     */
    public int getPeriodUnit() {
        return periodUnit;
    }

    /**
     * Sets the value of the periodUnit property.
     * 
     */
    public void setPeriodUnit(int value) {
        this.periodUnit = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link Number }
     *     
     */
    public Number getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Number }
     *     
     */
    public void setQuantity(Number value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the recurringFee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecurringFee() {
        return recurringFee;
    }

    /**
     * Sets the value of the recurringFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecurringFee(String value) {
        this.recurringFee = value;
    }

    /**
     * Gets the value of the salesEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSalesEnd() {
        return salesEnd;
    }

    /**
     * Sets the value of the salesEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSalesEnd(XMLGregorianCalendar value) {
        this.salesEnd = value;
    }

    /**
     * Gets the value of the salesStart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSalesStart() {
        return salesStart;
    }

    /**
     * Sets the value of the salesStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSalesStart(XMLGregorianCalendar value) {
        this.salesStart = value;
    }

    /**
     * Gets the value of the serviceID property.
     * 
     */
    public int getServiceID() {
        return serviceID;
    }

    /**
     * Sets the value of the serviceID property.
     * 
     */
    public void setServiceID(int value) {
        this.serviceID = value;
    }

    /**
     * Gets the value of the serviceUnit property.
     * 
     * @return
     *     possible object is
     *     {@link Number }
     *     
     */
    public Number getServiceUnit() {
        return serviceUnit;
    }

    /**
     * Sets the value of the serviceUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Number }
     *     
     */
    public void setServiceUnit(Number value) {
        this.serviceUnit = value;
    }

    /**
     * Gets the value of the terminationFee property.
     * 
     * @return
     *     possible object is
     *     {@link Number }
     *     
     */
    public Number getTerminationFee() {
        return terminationFee;
    }

    /**
     * Sets the value of the terminationFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Number }
     *     
     */
    public void setTerminationFee(Number value) {
        this.terminationFee = value;
    }

}
