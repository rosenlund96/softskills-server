package Service;

import java.net.URL;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import Controllers.Groupmanager;
import Controllers.Usermanager;
import Entities.User;
import Brugerautorisation.data.Bruger;
import Brugerautorisation.transport.Brugeradmin;


@WebService(endpointInterface = "Service.ServerI")
public class Servermanager {

	Bruger b = null;
	
	public Servermanager(){
		Usermanager manager = new Usermanager();
		Groupmanager gManager = new Groupmanager(manager);
		
	}
	
	public User login(String bruger, String adgangskode) throws Exception {
        URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
        QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
        Service service = Service.create(url, qname);
        Brugeradmin ba = service.getPort(Brugeradmin.class);
        
        try {
    b = ba.hentBruger(bruger, adgangskode);
} catch (Throwable e) {
    return null;
}
    User current = new User(b.getName(),b.getLastname(),b.getMail(),b.getRetning());
    
    return current;
}
	
	//All methods from Usermanager//
	
	//All methods from Groupmanager//
	
}
