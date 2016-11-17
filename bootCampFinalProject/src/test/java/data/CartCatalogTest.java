package data;




import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import entities.Cart;
import entities.ProductCart;

public class CartCatalogTest {


	@Test
	public void saveCart() throws SQLException {
		Cart cart = new Cart();
		cart.setId_user(1);
		ArrayList<ProductCart> productList= new ArrayList<ProductCart>();
		productList.add(new ProductCart(1, 1));
		productList.add(new ProductCart(2, 2));
		productList.add(new ProductCart(10, 1));
		cart.setProductList(productList);
		assertTrue(CartCatalog.getInstance().saveCart(cart));
	}

}
