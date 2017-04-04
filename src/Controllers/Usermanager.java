package Controllers;

import java.util.ArrayList;

import Entities.AbstractItem;
import Entities.User;

public class Usermanager {

	
	
	public Usermanager(){
		
	}
	
	public ArrayList<User> getAllUsers(){
		return null;
	}
	
	public void addProductToUser(AbstractItem item, User user, int qty){
		user.addToSafe(item,qty);
	}
	
	 public void addToResults(User user,AbstractItem item) {

	        user.addToResults(item);
	    }
	
	
}
