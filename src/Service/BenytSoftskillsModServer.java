package Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import Entities.User;



public class BenytSoftskillsModServer {
	 public static boolean trustedUser = false;
	    
		public static void main(String[] args) throws MalformedURLException, Exception {
	        URL url = new URL("http://ubuntu4.javabog.dk:9959/softskills?WSDL");
	        //URL url = new URL("http://localhost:9959/galgeservice?wsdl");
	        QName qname = new QName("http://Service/", "ServermanagerService");
	        Service service = Service.create(url, qname);
	        ServerI I = service.getPort(ServerI.class);
	        String brugernavn;
	        String adgangskode;
	        User currentUser = null;
	        
	        Scanner scanner = new Scanner(System.in);
	        
	        while(trustedUser == false) {        
	            System.out.print("Indtast dit brugernavn: ");        
	            brugernavn = scanner.next();
	            System.out.print("Indtast din adgangskode: ");
	            adgangskode = scanner.next();

	            boolean login = I.login(brugernavn, adgangskode);

	            if (login == true) {
	                trustedUser = true;
	                currentUser = new User(I.getName(), I.getSurName(),I.getEmail(),I.getRetning());
	                
	            }
	            else {
	                trustedUser = false;
	                System.out.print("Forkert brugernavn og/eller adgangskode \n");
	            }
	        }
	        System.out.println("Login successfuldt");
	        while(trustedUser == true){
	        	System.out.println("Velkommen til Softskills Toolbox");
	        	System.out.println("Vælg et menupunkt:");
	        	System.out.println("1. Se dine profiler");
	        	System.out.println("2. Butik");
	        	System.out.println("3. Mine resultater");
	        	System.out.println("4. Indstillinger");
	        	System.out.println("5. Log ud");
	        	int menupunkt = scanner.nextInt();
	        	switch(menupunkt){
	        	case 1: 
	        		currentUser.getSafe();
	        		break;
	        	case 2: 
	        		break;
	        	case 3:
	        		break;
	        	case 4:
	        		break;
	        	case 5: 
	        		System.out.println("Du er nu logget ud!");
	        		trustedUser = false;
	        		break;
	        	}
	        }

}
}
