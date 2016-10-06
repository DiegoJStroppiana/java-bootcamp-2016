package excerciseFour;

public class ExerciseFourMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionBuilder connBuilder = new LocalConnectionBuilder();
		ConnectionDirector connDirector = new ConnectionDirector(connBuilder);
		connDirector.constructConnection();
		Connection conn = connDirector.getConnection();
		System.out.println("Actual Connection: " + conn);
		
		connBuilder = new RemoteConnectionBuilder();
		connDirector = new ConnectionDirector(connBuilder);
		connDirector.constructConnection();
		conn = connDirector.getConnection();
		System.out.println("Actual Connection: " + conn);
		
	}

}
