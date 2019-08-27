/**
 * MyService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package userpackage;

public interface MyService extends java.rmi.Remote {
    public userpackage.Comment[] getAllCommentByPlaceId(int arg0) throws java.rmi.RemoteException;
    public userpackage.User createUser(userpackage.User arg0) throws java.rmi.RemoteException;
    public java.lang.String updatePlace(userpackage.Place arg0) throws java.rmi.RemoteException;
    public userpackage.User getUserByName(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String deletePlace(int arg0) throws java.rmi.RemoteException;
    public java.lang.String createPlace(userpackage.Place arg0) throws java.rmi.RemoteException;
    public userpackage.Place getPlaceById(int arg0) throws java.rmi.RemoteException;
    public userpackage.Comment createComment(userpackage.Comment arg0) throws java.rmi.RemoteException;
    public userpackage.Place[] getAllPlace() throws java.rmi.RemoteException;
}
