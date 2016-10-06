package exerciseTwo;

public class FactoryRelational extends AbstractFactory{
	
	
	TransactionalDataBase getTransactionalDB(String transactionalType){
		return null;
		
	}
	
	
	 @Override
	public RelationalDataBase getRelationalDB(String relationalType){
		 
		 if(relationalType == null){
	         return null;
	      }	
		
		 if(relationalType.equalsIgnoreCase("Relacional tipo 1")){
	         
			 return new RelationalTypeOne();
	         
	      }else if(relationalType.equalsIgnoreCase("Relacional tipo 2")){
	         
	    	 return new RelationalTypeTwo();
	         
	      }
		return null;
		
	}

}
