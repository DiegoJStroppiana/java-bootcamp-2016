package maven.exercise.bootCampTopic3Ex45;

public class User {
	private int userCode;
	private String name;
	private String surname;
	private int age;
	private double money = 0;
	
	public User(int userCode, String name, String surname, int age, double money){
		this.setUserCode(userCode);
		this.setName(name);
		this.setSurname(surname);
		this.setAge(age);
		this.addMoney(money);
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getMoney() {
		return money;
	}
	public void addMoney(double money) {
		this.money += money;
	}
	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	
	

	
	
}
