/**
 * MyService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mypackage;

public interface MyService extends java.rmi.Remote {
    public mypackage.Comment[] getAllCommentByPlaceId(int arg0) throws java.rmi.RemoteException;
    public mypackage.User getUserByName(java.lang.String arg0) throws java.rmi.RemoteException;
    public mypackage.User createUser(mypackage.User arg0) throws java.rmi.RemoteException;
    public mypackage.Place[] getAllPlace() throws java.rmi.RemoteException;
    public void deletePlace(int arg0) throws java.rmi.RemoteException;
    public void updatePlace(mypackage.Place arg0) throws java.rmi.RemoteException;
    public void createPlace(mypackage.Place arg0) throws java.rmi.RemoteException;
    public mypackage.Place getPlaceById(int arg0) throws java.rmi.RemoteException;
    public mypackage.Comment createComment(mypackage.Comment arg0) throws java.rmi.RemoteException;
}
