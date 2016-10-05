package excerciseFour;

public class RemoteConnectionBuilder implements ConnectionBuilder {
	
	private Connection connection;
	
	public RemoteConnectionBuilder(){
		connection = new Connection();
	}
	
	public void buildType(){
		connection.setType("Remote");
	}
	
	public void buildDistance(){
		connection.setDistance(1000);
	}
	public void buildStatus(){
		connection.setStatus("Connecting");
	}
	
	public Connection getConnection(){
		return connection;
	}

}
