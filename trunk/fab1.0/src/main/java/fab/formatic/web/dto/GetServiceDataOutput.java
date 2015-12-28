
package fab.formatic.web.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getServiceDataOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getServiceDataOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servicedatalist" type="{http://fab/}serviceDataList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getServiceDataOutput", propOrder = {
    "outMsg",
    "servicedatalist"
})
public class GetServiceDataOutput {

    protected String outMsg;
    protected ServiceDataList servicedatalist;

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
     * Gets the value of the servicedatalist property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDataList }
     *     
     */
    public ServiceDataList getServicedatalist() {
        return servicedatalist;
    }

    /**
     * Sets the value of the servicedatalist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDataList }
     *     
     */
    public void setServicedatalist(ServiceDataList value) {
        this.servicedatalist = value;
    }

}
