package Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import Controllers.Groupmanager;
import Controllers.Usermanager;
import Entities.AbstractItem;
import Entities.Group;
import Entities.Safe;
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
	public void setName(String newName, String newSurName, User user) {
		manager.setName(newName, newSurName, user);
    }

    /***************************************
     * This method gets the name of a user *
     ***************************************/

    public String getName(User user) {
    	return manager.getName(user);
    }

    /******************************************
     * This method gets the surname of a user *
     ******************************************/

    public String getSurName(User user) {
    	return manager.getSurName(user);
    }

    /****************************************
     * This method sets the email of a user *
     ****************************************/

    public void setEmail(String newEmail, User user) {
    	manager.setEmail(newEmail, user);
    }

    /****************************************
     * This method gets the email of a user *
     ****************************************/

    public String getEmail(User user){
    	return manager.getEmail(user);
    }

    /**********************************************
     * This method sets the phone number of a user *
     **********************************************/

    public void setRetning(String newRetning, User user){
    	manager.setRetning(newRetning, user);
    }

    /**********************************************
     * This method gets the phone number of a user *
     **********************************************/

    public String getRetning(User user){
    	return manager.getRetning(user);
    }

    /*********************************
     * This method gets and the safe *
     *********************************/

    public List<AbstractItem> retrieveSafeObjects(User user) {
		return manager.retrieveSafeObjects(user);
    }

    /*****************************
     * This method gets the safe *
     *****************************/

    public Safe getSafe(User user) {
    	return manager.getSafe(user);
    }

    /*****************************
     * This method sets the safe *
     *****************************/

    public void setSafe(Safe safe, User user) {
    	manager.setSafe(safe, user);
    }

    public void setfullName(User user){
    	manager.setfullName(user);
    }

    /******************************************
     * This method gets the results of a user *
     ******************************************/

    public List<AbstractItem> hentResults(User user) {
    	return manager.hentResults(user);
    }
    
    public String getFullName(User user){
        return manager.getFullName(user);
    }

    /*********************************************
     * This method adds bought tests to the safe *
     *********************************************/

    public void addToSafe(AbstractItem item, int qty, User user){
    	manager.addToSafe(item, qty, user);
    }



    public void setFirstRun(Boolean firstRun, User user){
    	manager.setFirstRun(firstRun, user);
    }
    
    public boolean getFirstRun(User user){
        return manager.getFirstRun(user);
    }

    public boolean getAdministrativ(User user) {
        return manager.getAdministrativ(user);
    }

    public boolean getNotifikationer(User user) {
        return manager.getNotifikationer(user);
    }

    public boolean getInverter(User user) {
        return manager.getInverter(user);
    }

    public void setAdministrativ(boolean administrativ, User user) {
    	manager.setAdministrativ(administrativ, user);
    }

    public void setNotifikationer(boolean notifikationer, User user) {
    	manager.setNotifikationer(notifikationer, user);
    }

    public void setInverter(boolean inverter, User user) {
    	manager.setInverter(inverter, user);
    }
	
}
