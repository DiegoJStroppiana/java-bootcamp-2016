package excerciseFour;

public class LocalConnectionBuilder implements ConnectionBuilder {
	private Connection connection;
	
	public LocalConnectionBuilder(){
		connection = new Connection();
	}
	
	public void buildType(){
		connection.setType("Local");
	}
	
	public void buildDistance(){
		connection.setDistance(0);
	}
	public void buildStatus(){
		connection.setStatus("Connected");
	}
	
	public Connection getConnection(){
		return connection;
	}
}
