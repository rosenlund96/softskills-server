package Service;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import Entities.AbstractItem;
import Entities.Group;
import Entities.User;

@WebService
public interface ServerI {

	
	@WebMethod boolean login(String bruger, String adgangskode) throws Exception;
	@WebMethod boolean createGroup(String name, ArrayList<User> users, int size) throws Exception;
	@WebMethod boolean getGroup(String name) throws Exception;
	@WebMethod boolean deleteGroup(String name) throws Exception;
	@WebMethod boolean getAllUsers() throws Exception;
	@WebMethod boolean addProductToUser(AbstractItem item, User user, int qty) throws Exception;
	@WebMethod boolean addToResults(User user,AbstractItem item) throws Exception;
	//hej
}
