
package fab.formatic.web.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTarrifOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTarrifOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tarriflist" type="{http://fab/}tarrifList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTarrifOutput", propOrder = {
    "outMsg",
    "tarriflist"
})
public class GetTarrifOutput {

    protected String outMsg;
    protected TarrifList tarriflist;

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
     * Gets the value of the tarriflist property.
     * 
     * @return
     *     possible object is
     *     {@link TarrifList }
     *     
     */
    public TarrifList getTarriflist() {
        return tarriflist;
    }

    /**
     * Sets the value of the tarriflist property.
     * 
     * @param value
     *     allowed object is
     *     {@link TarrifList }
     *     
     */
    public void setTarriflist(TarrifList value) {
        this.tarriflist = value;
    }

}
