package Service;

import java.net.URL;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import Controllers.Groupmanager;
import Controllers.Usermanager;
import Entities.AbstractItem;
import Entities.Group;
import Entities.User;
import Brugerautorisation.data.Bruger;
import Brugerautorisation.transport.Brugeradmin;


@WebService(endpointInterface = "Service.ServerI")
public class Servermanager {

	Bruger b = null;
	User current = null;
	public Groupmanager aManager;
	public Usermanager manager;
	
	public Servermanager(){
		manager = new Usermanager();
		this.aManager = new Groupmanager(manager);
		
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
    current = new User(b.getName(),b.getLastname(),b.getMail(),b.getRetning());
    
    return current;
}
	
	//All methods from Groupmanager//
	public void createGroup(String name, ArrayList<User> users, int size) {
		aManager.createGroup(name, users, size);
	}
	
	public Group getGroup(String name){
		return aManager.getGroup(name);
	}
	
	public Boolean deleteGroup(String name){
		return aManager.deleteGroup(name);
	}
	
	//All methods from Usermanager//
	public ArrayList<User> getAllUsers(){
		return manager.getAllUsers();
	}
	
	public void addProductToUser(AbstractItem item, User user, int qty){
		 manager.addProductToUser(item, user, qty);
	}
	
	public void addToResults(User user,AbstractItem item) {
		manager.addToResults(user, item);
	}
	// Alle metoder fra User
}
