package maven.exercise.bootCampTopic3Ex45;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserCRUDServiceImpTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		UserDB.getInstance().addUser(new User(1, "Diego", "Stoppiana", 22, 1000));
		UserDB.getInstance().addUser(new User(2, "Tomas", "Pierantoni", 20, 1300));
		UserDB.getInstance().addUser(new User(3, "Jesica", "Restiffo", 23, 1500));
		UserDB.getInstance().addUser(new User(4, "Ignacio", "Sanchez", 25, 1600));
		UserDB.getInstance().addUser(new User(5, "Bruno", "Burzacca", 26, 2000));
		UserDB.getInstance().addUser(new User(6, "Gaston", "Abasto", 22, 3000));		
	}

	@Test
	public void newUser() {
		System.out.println("");
		System.out.println("Test 1: new user");
		UserCRUDServiceImp userCrud = new UserCRUDServiceImp();
		userCrud.newUser(new User (7, "Julian", "Aiup", 23, 0));
		assertTrue(UserDB.getInstance().getUsers().size()==7);
		userCrud.showUserList();
		UserDB.getInstance().finalize();
		
	}

	@Test
	public void removeUser() {
		System.out.println("");
		System.out.println("Test 2: remove user");
		UserCRUDServiceImp userCrud = new UserCRUDServiceImp();
		userCrud.deleteUser(2);
		assertTrue(UserDB.getInstance().getUsers().size()==5);
		userCrud.showUserList();
		UserDB.getInstance().finalize();		
	}
	
	@Test
	public void getUser() {
		System.out.println("");
		System.out.println("Test 3: get user");
		UserCRUDServiceImp userCrud = new UserCRUDServiceImp();
		User u = userCrud.getUser(1);
		assertTrue(u.getName().equals("Diego"));
		System.out.println("User code: "+ u.getUserCode() +" Name: " + u.getName() + " Surname: " + u.getSurname() + " Money: " + u.getMoney());
		UserDB.getInstance().finalize();	
	}
	
	@Test
	public void updateUser() {
		System.out.println("");
		System.out.println("Test 4: update user");
		UserCRUDServiceImp userCrud = new UserCRUDServiceImp();
		User u = userCrud.getUser(1);
		u.addMoney(2000);
		assertTrue(u.getMoney()==3000);
		System.out.println("User code: "+ u.getUserCode() +" Name: " + u.getName() + " Surname: " + u.getSurname() + " Money: " + u.getMoney());
		UserDB.getInstance().finalize();	
	}
	
	@Test
	public void getUserList() {
		System.out.println("");
		System.out.println("Test 5: get user list");
		UserCRUDServiceImp userCrud = new UserCRUDServiceImp();
		assertTrue(UserDB.getInstance().getUsers().size()==6);
		userCrud.showUserList();
		UserDB.getInstance().finalize();	
	}
}
