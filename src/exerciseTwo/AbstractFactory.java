package exerciseTwo;

public abstract class AbstractFactory {
        abstract RelationalDataBase getRelationalDB(String relatinalType);
        abstract TransactionalDataBase getTransactionalDB(String transactionalType);
        
}
