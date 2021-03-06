
package fab.formatic.web.dto;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "FABwsService", targetNamespace = "http://fab/", wsdlLocation = "file:/home/gilang/Documents/swgworkspace/fab/src/main/webapp/WEB-INF/wsdl/FABwsService.wsdl")
public class FABwsService
    extends Service
{

    private final static URL FABWSSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(fab.formatic.web.dto.FABwsService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = fab.formatic.web.dto.FABwsService.class.getResource(".");
            url = new URL(baseUrl, "file:/home/gilang/Documents/swgworkspace/fab/src/main/webapp/WEB-INF/wsdl/FABwsService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/home/gilang/Documents/swgworkspace/fab/src/main/webapp/WEB-INF/wsdl/FABwsService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        FABWSSERVICE_WSDL_LOCATION = url;
    }

    public FABwsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FABwsService() {
        super(FABWSSERVICE_WSDL_LOCATION, new QName("http://fab/", "FABwsService"));
    }

    /**
     * 
     * @return
     *     returns FABws
     */
    @WebEndpoint(name = "FABwsPort")
    public FABws getFABwsPort() {
        return super.getPort(new QName("http://fab/", "FABwsPort"), FABws.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FABws
     */
    @WebEndpoint(name = "FABwsPort")
    public FABws getFABwsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://fab/", "FABwsPort"), FABws.class, features);
    }

}
