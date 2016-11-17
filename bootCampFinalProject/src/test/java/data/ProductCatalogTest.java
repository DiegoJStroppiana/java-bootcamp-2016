package data;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import entities.Product;



public class ProductCatalogTest {



	@Test
	public void findByName() throws SQLException {
		Product product = ProductCatalog.getInstance().findByName("Samsung J7");		
		if (product==null){
			System.out.println("Product doesn't exist");
		}else{
			assertTrue(product.getName().equals("Samsung J7"));
		    System.out.println(product.getId_product() + " " + product.getName()+ " " + product.getPrice());	
		}
	}
	
	@Test
	public void findByCategory() throws SQLException {
		ArrayList<Product> productList = ProductCatalog.getInstance().findByCategory("Electronics");
		if (productList==null){
			System.out.println("Category doesn't exist");
		}else{
			Product product = productList.get(0);
			assertTrue(product.getCategory().equals("Electronics"));
		    System.out.println(product.getId_product() + " " + product.getName()+ " " + product.getPrice());	
		}
	}

}
