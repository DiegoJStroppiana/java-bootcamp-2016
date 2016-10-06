package exerciseThree;

import java.util.Date;

public class ProxySlowConnection {

	SlowConnection slowConnection;

	public ProxySlowConnection() {
		System.out.println("Creating proxy at " + new Date());
	}

	public void sayConnection() {
		if (slowConnection == null) {
			slowConnection = new SlowConnection();
		}
		slowConnection.sayConnection();
	}

}
