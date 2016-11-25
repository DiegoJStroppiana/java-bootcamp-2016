package entities;

public class User {
	private int id_user;
	private String nick_name;
	private String password;
	private String first_name;
	private String last_name;
	
	public User(){		
	}
	
	public User(int id_user,String nick_name, String password, String first_name, String last_name){
		this.setId_user(id_user);
		this.setNick_name(nick_name);
		this.setPassword(password);
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
	}
	
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
}
