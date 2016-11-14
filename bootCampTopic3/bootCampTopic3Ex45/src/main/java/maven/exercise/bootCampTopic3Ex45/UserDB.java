package maven.exercise.bootCampTopic3Ex45;

import java.util.ArrayList;



public class UserDB {
	
	private static ArrayList<User> users = new ArrayList<User>();	
	private static UserDB userDB = null;

	private UserDB() {	
	}
	
	public static UserDB getInstance() {
		if (userDB == null) {
			userDB = new UserDB();
		}
		return userDB;
	}
	
	
	public void addUser(User u){
		users.add(u);
	}
	
	public void deleteUser(int userCode){
		for (User u: users){
			if (u.getUserCode()==userCode){
				users.remove(u);
				break;
			}
		}
	}
	
	public User getUser(int userCode){
		for (User u: users){
			if (u.getUserCode()==userCode){
				return u;
			}
		}
		return null;
	}
	
	public void updateUser (User user){
		for (User u: users){
			if (user.getUserCode()==u.getUserCode()){
				int position=users.indexOf(u);
				users.remove(u);
				users.add(position,user);
			}
		}
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public void finalize(){
		users = new ArrayList<User>();
		userDB= null;
	}

}
