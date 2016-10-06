package exerciseTwo;


public class FactoryProducer {
	   public static AbstractFactory getFactory(String choice){
	   
	      if(choice.equalsIgnoreCase("Relacional")){
	         return new FactoryRelational();
	         
	      }else if(choice.equalsIgnoreCase("Transaccional")){
	         return new FactoryTransactional();
	      }
	      
	      return null;
	   }
	}
