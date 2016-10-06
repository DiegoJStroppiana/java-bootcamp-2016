package exerciseOne;

public class SingletonDataBase {

	private static SingletonDataBase singletonDataBase = null;

	private SingletonDataBase() {
	}

	public static SingletonDataBase getInstance() {
		if (singletonDataBase == null) {
			singletonDataBase = new SingletonDataBase();
		}
		return singletonDataBase;
	}

	public void connected() {
		System.out.println("Connected to Database");
	}
}