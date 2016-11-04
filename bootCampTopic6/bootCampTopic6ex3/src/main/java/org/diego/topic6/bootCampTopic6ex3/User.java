package org.diego.topic6.bootCampTopic6ex3;

public class User {
		
	private String name;
	private String surname;
	private String nickname;
	
	public User(){
	
	}
	
	public User(String nickname, String name, String surname){
		this.setName(name);
		this.setNickname(nickname);
		this.setSurname(surname);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
}
