package johnny.java.advanced.webservice.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "johnny.java.advanced.webservice.server.HelloService")
public class HelloServiceImpl implements HelloService {
    @WebMethod
    public String helloWorld() {
        return "Hello World";
    }

    @WebMethod
    public String hi(String name) {
        return "Hi " + name;
    }
}
