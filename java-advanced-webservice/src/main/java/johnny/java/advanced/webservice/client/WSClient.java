package johnny.java.advanced.webservice.client;

import johnny.java.advanced.webservice.server.HelloService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class WSClient {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8888/ws/demo?wsdl");

        // You can get the namespace and local part from the wsdl
        QName qname = new QName("http://server.webservice.advanced.java.johnny/", "HelloServiceImplService");

        Service service = Service.create(url, qname);

        HelloService hello = service.getPort(HelloService.class);

        System.out.println(hello.helloWorld());
        System.out.println(hello.hi("johnny"));
    }
}
