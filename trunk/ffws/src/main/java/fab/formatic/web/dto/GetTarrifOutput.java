
package fab.formatic.web.dto;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="tarriflist" type="{http://fab/}tarrifList" maxOccurs="unbounded" minOccurs="0"/>
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
    protected List<TarrifList> tarriflist;

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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tarriflist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTarriflist().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TarrifList }
     * 
     * 
     */
    public List<TarrifList> getTarriflist() {
        if (tarriflist == null) {
            tarriflist = new ArrayList<TarrifList>();
        }
        return this.tarriflist;
    }

}
