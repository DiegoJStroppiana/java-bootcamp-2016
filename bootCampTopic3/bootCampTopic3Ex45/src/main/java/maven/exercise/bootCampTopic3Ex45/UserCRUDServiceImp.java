package maven.exercise.bootCampTopic3Ex45;


public class UserCRUDServiceImp implements IUserCRUDService{
	
	/**
	  * This is a service which allows to add a user, delete one existing, get one from the list, update it and
	  * get all users
	  *@author Diego Jesús Stroppiana
	  *@version 1.0
	  *@see UserDB
	  */
	
	
	
	public void newUser (User u){	
		/**
		  * This method adds a new user to the list
		  * @param u This parameter is the user which will be added to the list
		  */
		UserDB.getInstance().addUser(u);
	}

	public void deleteUser(int userCode) {
		/**
		  * This method deletes an user from the existing list
		  * @param userCode This parameter is the code which identifies a user that will be deleted from the list 
		  */
		
		UserDB.getInstance().deleteUser(userCode);
	}

	public User getUser(int userCode) {
		/**
		  * This method gets a specific user from the list
		  * @param userCode This parameter is the code which identifies the required user
		  * @return This method returns the obtained user
		  */
		return UserDB.getInstance().getUser(userCode);
	}

	public void updateUser(User u) {
		/**
		  * This method updates a user from the list
		  * @param u This parameter is the user which will be modified from the list with new data
		  */
		
		UserDB.getInstance().updateUser(u);
	}

	public void showUserList() {
		
		/**
		  * This method shows the users on the list
		  */
		
		for(User u : UserDB.getInstance().getUsers()){
			System.out.println("User code: "+ u.getUserCode() +" Name: " + u.getName() + " Surname: " + u.getSurname() + " Money: " + u.getMoney());
		}
	}
	
	

}
