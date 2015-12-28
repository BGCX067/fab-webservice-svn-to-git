/**
 * SaaSNotification_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fab.formatic.rpc.dto;

public class SaaSNotification_ServiceLocator extends org.apache.axis.client.Service implements fab.formatic.rpc.dto.SaaSNotification_Service {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4978638635404785844L;

	public SaaSNotification_ServiceLocator() {
    }


    public SaaSNotification_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SaaSNotification_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for telkomWSDL_telkomSAAS_SaaSNotification_Port
    private java.lang.String telkomWSDL_telkomSAAS_SaaSNotification_Port_address = "http://118.97.57.5:5555/ws/telkomWSDL.telkomSAAS:SaaSNotification";

    public java.lang.String gettelkomWSDL_telkomSAAS_SaaSNotification_PortAddress() {
        return telkomWSDL_telkomSAAS_SaaSNotification_Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String telkomWSDL_telkomSAAS_SaaSNotification_PortWSDDServiceName = "telkomWSDL_telkomSAAS_SaaSNotification_Port";

    public java.lang.String gettelkomWSDL_telkomSAAS_SaaSNotification_PortWSDDServiceName() {
        return telkomWSDL_telkomSAAS_SaaSNotification_PortWSDDServiceName;
    }

    public void settelkomWSDL_telkomSAAS_SaaSNotification_PortWSDDServiceName(java.lang.String name) {
        telkomWSDL_telkomSAAS_SaaSNotification_PortWSDDServiceName = name;
    }

    public fab.formatic.rpc.dto.SaaSNotification_PortType gettelkomWSDL_telkomSAAS_SaaSNotification_Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(telkomWSDL_telkomSAAS_SaaSNotification_Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return gettelkomWSDL_telkomSAAS_SaaSNotification_Port(endpoint);
    }

    public fab.formatic.rpc.dto.SaaSNotification_PortType gettelkomWSDL_telkomSAAS_SaaSNotification_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fab.formatic.rpc.dto.TelkomWSDL_telkomSAAS_SaaSNotification_BinderStub _stub = new fab.formatic.rpc.dto.TelkomWSDL_telkomSAAS_SaaSNotification_BinderStub(portAddress, this);
            _stub.setPortName(gettelkomWSDL_telkomSAAS_SaaSNotification_PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void settelkomWSDL_telkomSAAS_SaaSNotification_PortEndpointAddress(java.lang.String address) {
        telkomWSDL_telkomSAAS_SaaSNotification_Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fab.formatic.rpc.dto.SaaSNotification_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                fab.formatic.rpc.dto.TelkomWSDL_telkomSAAS_SaaSNotification_BinderStub _stub = new fab.formatic.rpc.dto.TelkomWSDL_telkomSAAS_SaaSNotification_BinderStub(new java.net.URL(telkomWSDL_telkomSAAS_SaaSNotification_Port_address), this);
                _stub.setPortName(gettelkomWSDL_telkomSAAS_SaaSNotification_PortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("telkomWSDL_telkomSAAS_SaaSNotification_Port".equals(inputPortName)) {
            return gettelkomWSDL_telkomSAAS_SaaSNotification_Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://118.97.57.5:5555/telkomWSDL/telkomSAAS/SaaSNotification", "SaaSNotification");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://118.97.57.5:5555/telkomWSDL/telkomSAAS/SaaSNotification", "telkomWSDL_telkomSAAS_SaaSNotification_Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("telkomWSDL_telkomSAAS_SaaSNotification_Port".equals(portName)) {
            settelkomWSDL_telkomSAAS_SaaSNotification_PortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
