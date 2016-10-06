package exerciseTwo;

public class FactoryTransactional extends AbstractFactory {
	
	@Override
	public TransactionalDataBase getTransactionalDB(String transactionalType){
		
		if(transactionalType == null){
	         return null;
	      }	
		 

		 if(transactionalType.equalsIgnoreCase("Transaccional tipo 1")){
	         
			 return new TransactionalTypeOne();
	         
	      }else if(transactionalType.equalsIgnoreCase("Transaccional tipo 2")){
	         
	    	 return new TransactionalTypeTwo();
	         
	      }
	
		return null;
	}
	
	 @Override
	RelationalDataBase getRelationalDB(String relationalType){
		return null;
	}


	
	
	}


