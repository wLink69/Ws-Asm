/**
 * MyServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package userpackage;

public interface MyServiceService extends javax.xml.rpc.Service {
    public java.lang.String getMyServicePortAddress();

    public userpackage.MyService getMyServicePort() throws javax.xml.rpc.ServiceException;

    public userpackage.MyService getMyServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
