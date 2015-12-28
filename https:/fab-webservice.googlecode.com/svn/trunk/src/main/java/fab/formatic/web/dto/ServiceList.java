
package fab.formatic.web.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for serviceList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isToBeBilled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="servPeriodUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceCount" type="{http://fab/}number" minOccurs="0"/>
 *         &lt;element name="serviceEnd" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="serviceID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serviceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servicePeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serviceSeq" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serviceStart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="serviceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceList", propOrder = {
    "isToBeBilled",
    "servPeriodUnit",
    "serviceAmt",
    "serviceCount",
    "serviceEnd",
    "serviceID",
    "serviceName",
    "servicePeriod",
    "serviceSeq",
    "serviceStart",
    "serviceType",
    "serviceUnit"
})
public class ServiceList {

    protected boolean isToBeBilled;
    protected String servPeriodUnit;
    protected String serviceAmt;
    protected Number serviceCount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar serviceEnd;
    protected int serviceID;
    protected String serviceName;
    protected int servicePeriod;
    protected int serviceSeq;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar serviceStart;
    protected String serviceType;
    protected String serviceUnit;

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
     * Gets the value of the servPeriodUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServPeriodUnit() {
        return servPeriodUnit;
    }

    /**
     * Sets the value of the servPeriodUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServPeriodUnit(String value) {
        this.servPeriodUnit = value;
    }

    /**
     * Gets the value of the serviceAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceAmt() {
        return serviceAmt;
    }

    /**
     * Sets the value of the serviceAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceAmt(String value) {
        this.serviceAmt = value;
    }

    /**
     * Gets the value of the serviceCount property.
     * 
     * @return
     *     possible object is
     *     {@link Number }
     *     
     */
    public Number getServiceCount() {
        return serviceCount;
    }

    /**
     * Sets the value of the serviceCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Number }
     *     
     */
    public void setServiceCount(Number value) {
        this.serviceCount = value;
    }

    /**
     * Gets the value of the serviceEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getServiceEnd() {
        return serviceEnd;
    }

    /**
     * Sets the value of the serviceEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setServiceEnd(XMLGregorianCalendar value) {
        this.serviceEnd = value;
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
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * Gets the value of the servicePeriod property.
     * 
     */
    public int getServicePeriod() {
        return servicePeriod;
    }

    /**
     * Sets the value of the servicePeriod property.
     * 
     */
    public void setServicePeriod(int value) {
        this.servicePeriod = value;
    }

    /**
     * Gets the value of the serviceSeq property.
     * 
     */
    public int getServiceSeq() {
        return serviceSeq;
    }

    /**
     * Sets the value of the serviceSeq property.
     * 
     */
    public void setServiceSeq(int value) {
        this.serviceSeq = value;
    }

    /**
     * Gets the value of the serviceStart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getServiceStart() {
        return serviceStart;
    }

    /**
     * Sets the value of the serviceStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setServiceStart(XMLGregorianCalendar value) {
        this.serviceStart = value;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceType(String value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the serviceUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceUnit() {
        return serviceUnit;
    }

    /**
     * Sets the value of the serviceUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceUnit(String value) {
        this.serviceUnit = value;
    }

}
