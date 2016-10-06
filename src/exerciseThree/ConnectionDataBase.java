package exerciseThree;

import java.util.Date;

public abstract class ConnectionDataBase {
	public void sayConnection() {
		System.out.println(this.getClass().getSimpleName() + " conected to database at: " + new Date());
		}
}
