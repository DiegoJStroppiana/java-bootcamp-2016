package org.diego.topic6.bootCampTopic6ex3;

import java.util.ArrayList;

public interface UserService {
			
	public ArrayList<User> showUsers();
	public String addUser(String nickname, String name, String surname);
	public String deleteUser(String nickname);
	public User findByName(String name);
	public String updateUser(String nickname, String name, String surname);
	public User findByNickName(String nickname);
}
