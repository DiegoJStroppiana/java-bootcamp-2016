package data;

import static org.junit.Assert.*;

import java.sql.SQLException;
import org.junit.Test;
import entities.Product;



public class ProductCatalogTest {



	@Test
	public void findByName() throws SQLException {
		Product p = ProductCatalog.getInstance().findByName("Samsung J7");
		if (p==null){
			System.out.println("Product doesn't exist");
		}else{
			assertTrue(p.getName().equals("Samsung J7"));
		    System.out.println(p.getId_product() + " " + p.getName()+ " " + p.getPrice());	
		}
	}
	
	@Test
	public void findByCategory() throws SQLException {
		Product p = ProductCatalog.getInstance().findByName("Samsung J7");
		if (p==null){
			System.out.println("Category doesn't exist");
		}else{
			assertTrue(p.getName().equals("Samsung J7"));
		    System.out.println(p.getId_product() + " " + p.getName()+ " " + p.getPrice());	
		}
	}

}
