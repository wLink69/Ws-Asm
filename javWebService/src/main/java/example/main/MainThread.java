package example.main;

import example.service.MyService;

import javax.xml.ws.Endpoint;

public class MainThread {
    public static void main(String[] argv) {
        System.setProperty("javax.xml.accessExternalDTD", "all");
        Object implementor = new MyService();
        String address = "http://localhost:9000/my-service";
        Endpoint.publish(address, implementor);
    }
}
