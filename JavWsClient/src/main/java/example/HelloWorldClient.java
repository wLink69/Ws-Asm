package example;

import userpackage.MyService;
import userpackage.MyServiceServiceLocator;
import userpackage.Place;

public class HelloWorldClient {
  public static void main(String[] argv) {
      try {
          MyServiceServiceLocator locator = new MyServiceServiceLocator();
          MyService service = locator.getMyServicePort();
          // If authorization is required
          //((MyServicePortBindingStub)service).setUsername("user3");
          //((MyServicePortBindingStub)service).setPassword("pass3");
          // invoke business method
          Place[] places = service.getAllPlace();
          for (Place place:
               places) {
              System.out.println(place.getImage());
          }
      } catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      } catch (java.rmi.RemoteException ex) {
          ex.printStackTrace();
      }
  }
}
