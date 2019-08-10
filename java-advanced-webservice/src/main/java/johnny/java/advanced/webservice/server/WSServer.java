package johnny.java.advanced.webservice.server;

import javax.xml.ws.Endpoint;

public class WSServer {
    static final String host = "http://localhost:8888/ws/demo";
    public static void main(String[] args){
        Endpoint.publish(host, new HelloServiceImpl());
        System.out.println("Web service started at: " + host);
    }
}
