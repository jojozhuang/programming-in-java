package johnny.java.advanced.webservice.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloService {

    @WebMethod
    public String helloWorld();

    @WebMethod
    public String hi(String name);
}
