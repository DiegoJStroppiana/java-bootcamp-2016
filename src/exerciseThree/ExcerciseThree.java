package exerciseThree;

public class ExcerciseThree {


		public static void main(String[] args) {

			ProxySlowConnection proxy = new ProxySlowConnection();

			FastConnection fastConnection = new FastConnection();
			fastConnection.sayConnection();

			proxy.sayConnection();

		}

	

}
