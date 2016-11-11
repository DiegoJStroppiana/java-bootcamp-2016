package data;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import org.junit.Test;

import entities.User;
public class UserCatalogTest {



	@Test
	public void getUser() throws SQLException{
		User u = UserCatalog.getInstance().getUser("diegopujato");
		if (u==null){
			System.out.println("User doesn't exist");
		}else{
			assertTrue(u.getNick_name().equals("diegopujato"));
		    System.out.println(u.getId_user() + " " + u.getNick_name());	
		}
		
	}
	
	@Test
	public void newUser() throws SQLException{
		if (UserCatalog.getInstance().newUser("diegopujato","hola123","Diego","Stroppiana").equals("New user created")){
			assertTrue(true);
			System.out.println("User created");
		} else {
			System.out.println("Nick name already exists");
		}
		
	}

}
