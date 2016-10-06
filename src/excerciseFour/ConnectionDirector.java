package excerciseFour;

public class ConnectionDirector {
	
	private ConnectionBuilder connBuilder = null;
	
	public ConnectionDirector(ConnectionBuilder connBuilder){
		this.connBuilder = connBuilder;	
	}
	
	public void constructConnection(){
		connBuilder.buildType();
		connBuilder.buildDistance();
		connBuilder.buildStatus();
	}
	
	public Connection getConnection(){
		return connBuilder.getConnection();
	}
}
