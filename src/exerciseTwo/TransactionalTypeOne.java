package exerciseTwo;

public class TransactionalTypeOne implements TransactionalDataBase {

	@Override
	public void consulta() {
		System.out.println("This is a type 1 transactional DB");		
	}

}
