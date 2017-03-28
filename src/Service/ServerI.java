package Service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ServerI {

	
	@WebMethod boolean login(String bruger, String adgangskode) throws Exception;
}
