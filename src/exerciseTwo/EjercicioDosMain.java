package exerciseTwo;

public class EjercicioDosMain {

	public static void main(String[] args) {

	      AbstractFactory relationalFactory = FactoryProducer.getFactory("Relacional");

	      RelationalDataBase rdb1 = relationalFactory.getRelationalDB("Relacional tipo 1");
	      
	      rdb1.consulta();
	      
	      
	      RelationalDataBase rdb2 = relationalFactory.getRelationalDB("Relacional tipo 2");
	      
	      rdb2.consulta();
	      
	      AbstractFactory transactionalFactory = FactoryProducer.getFactory("Transaccional");
	      
	      TransactionalDataBase tdb1 = transactionalFactory.getTransactionalDB("Transaccional tipo 1");
	      
	      tdb1.consulta();
	      
	      
	      TransactionalDataBase tdb2 = transactionalFactory.getTransactionalDB("Transaccional tipo 2");
	      
	      tdb2.consulta();
	      
	      
	      


	     

	}

}
