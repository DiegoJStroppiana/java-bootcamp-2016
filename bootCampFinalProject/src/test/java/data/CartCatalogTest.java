package data;




import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import entities.Cart;
import entities.Product;

public class CartCatalogTest {


	@Test
	public void saveCart() throws SQLException {
		Cart cart = new Cart();
		cart.setId_user(1);
		ArrayList<Product> productList= new ArrayList<Product>();
		productList.add(new Product(1, 1));
		productList.add(new Product(2, 2));
		productList.add(new Product(10, 1));
		cart.setProductList(productList);
		assertTrue(CartCatalog.getInstance().saveCart(cart));
	}

}
