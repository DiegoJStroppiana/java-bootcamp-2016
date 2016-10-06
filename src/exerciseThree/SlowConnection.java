package exerciseThree;

public class SlowConnection extends ConnectionDataBase {

	public SlowConnection() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
