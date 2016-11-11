package business;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Cart;
import entities.Product;

public interface ServiceShoppingCart {
	 public String login(String nick_name, String password, String newCart) throws SQLException;
	 public String logoff();
	 public String register(String nick_name, String password, String first_name, String last_name) throws SQLException;
	 public Product findProductByName(String name) throws SQLException;
	 public ArrayList<Product> findProductByCategory(String category) throws SQLException;
	 public String addProductToCart(String name, int quantity) throws SQLException;
	 public String deleteProductFromCart(String name) throws SQLException;
	 public Cart showCurrentCart();
	 public String saveCart() throws SQLException;
	 public String buyCart() throws SQLException;
	 
}
