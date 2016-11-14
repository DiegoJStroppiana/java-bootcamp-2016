package maven.exercise.bootCampTopic3Ex45;

public interface IUserCRUDService {
	
	public void newUser(User u);
	public void deleteUser(int userCode);
	public User getUser(int userCode);
	public void updateUser(User u);
	public void showUserList();
	

}
