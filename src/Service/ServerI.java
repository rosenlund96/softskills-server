package Service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import Entities.AbstractItem;
import Entities.Group;
import Entities.Safe;
import Entities.User;

@WebService
public interface ServerI {

	
	@WebMethod boolean login(String bruger, String adgangskode) throws Exception;
	@WebMethod void createGroup(String name, ArrayList<User> users, int size) throws Exception;
	@WebMethod Group getGroup(String name) throws Exception;
	@WebMethod boolean deleteGroup(String name) throws Exception;
	@WebMethod ArrayList<User> getAllUsers() throws Exception;
	@WebMethod void addProductToUser(AbstractItem item, User user, int qty) throws Exception;
	//@WebMethod void addToResults(User user,AbstractItem item) throws Exception;
	@WebMethod void setName(String newName, String newSurName) throws Exception;
	@WebMethod String getName() throws Exception;
	@WebMethod String getSurName() throws Exception;
	@WebMethod void setEmail(String newEmail) throws Exception;
	@WebMethod String getEmail() throws Exception;
	@WebMethod void setRetning(String newRetning) throws Exception;
	@WebMethod String getRetning() throws Exception;
	@WebMethod List<AbstractItem> retrieveSafeObjects()throws Exception;
	@WebMethod Safe getSafe() throws Exception;
	@WebMethod void setSafe(Safe safe) throws Exception;
	@WebMethod void setfullName() throws Exception;
	@WebMethod List<AbstractItem> hentResults() throws Exception;
	@WebMethod String getFullName() throws Exception;
	@WebMethod void addToSafe(AbstractItem item, int qty) throws Exception;
	@WebMethod void addToResults(AbstractItem item) throws Exception;
	@WebMethod void setFirstRun(Boolean firstRun) throws Exception;
	@WebMethod boolean getFirstRun() throws Exception;
	@WebMethod boolean getAdministrativ() throws Exception;
	@WebMethod boolean getNotifikationer() throws Exception;
	@WebMethod boolean getInverter() throws Exception;
	@WebMethod void setAdministrativ(boolean administrativ) throws Exception;
	@WebMethod void setNotifikationer(boolean notifikationer) throws Exception;
	@WebMethod void setInverter(boolean inverter) throws Exception;
	
}
