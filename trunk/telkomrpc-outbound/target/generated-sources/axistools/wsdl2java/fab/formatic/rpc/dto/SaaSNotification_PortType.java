/**
 * SaaSNotification_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fab.formatic.rpc.dto;

public interface SaaSNotification_PortType extends java.rmi.Remote {
    public void saaSNotification(java.lang.String hostID, java.lang.String orderID, java.lang.String custID, java.lang.String typeTransaction, java.lang.String status, java.lang.String message, fab.formatic.rpc.dto.NotifyAttr[] notifyAttr, javax.xml.rpc.holders.StringHolder outStatus, javax.xml.rpc.holders.StringHolder outMessage, fab.formatic.rpc.dto.holders.ArrayOfENCOutAttrHolder outAttr) throws java.rmi.RemoteException;
}
