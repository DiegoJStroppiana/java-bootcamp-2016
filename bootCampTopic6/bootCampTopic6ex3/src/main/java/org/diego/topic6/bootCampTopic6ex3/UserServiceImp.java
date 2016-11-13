package org.diego.topic6.bootCampTopic6ex3;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImp implements UserService {

	ArrayList<User> userList = new ArrayList<User>();
	
	@RequestMapping("/showUsers")
	public ArrayList<User> showUsers(){
		return userList;
	}

	@RequestMapping("/addUser")
	public String addUser(@RequestParam(value="nickname", defaultValue="")String nickname,
							@RequestParam(value="name", defaultValue="")String name, 
							@RequestParam(value="surname", defaultValue="") String surname) {
		for (User u : userList){
			if (u.getNickname().equals(nickname)){
				return "Nickname is already in use";
			}
		}
		userList.add(new User(nickname, name, surname));
		return "User " + nickname + " added";
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam(value="nickname", defaultValue="")String nickname) {
		for(User u: userList){
			if(u.getNickname().equals(nickname)){
				userList.remove(u);
				return "User " + nickname + " deleted";
			}
		}
		return nickname + " doesn't exist";
		
		
	}

	@RequestMapping("/findByName")
	public User findByName(@RequestParam(value="name", defaultValue="")String name) {	
		for (User u: userList){
			if (u.getName().equals(name)){
				return u;
			}
		}
		return null;
	}

	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam(value="nickname", defaultValue="")String nickname,
							@RequestParam(value="name", defaultValue="")String name, 
							@RequestParam(value="surname", defaultValue="") String surname) {
		for (User u: userList){
			if (u.getNickname().equals(u.getNickname())){
				u.setName(name);
				u.setSurname(surname);
				break;
			}
		}
		return "User updated";
	}

	@RequestMapping("/findByNickName")
	public User findByNickName(@RequestParam(value="nickname", defaultValue="") String nickname) {
		for (User u: userList){
			if (u.getNickname().equals(nickname)){
				return u;
			}
		}
		return null;
	}
	
	

}
