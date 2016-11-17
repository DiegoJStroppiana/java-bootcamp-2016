package business;

import java.sql.SQLException;

public interface ServiceShoppingCart {
	 public String login(String nick_name, String password, String newCart) throws SQLException;
	 public String logoff();
	 public String register(String nick_name, String password, String first_name, String last_name) throws SQLException;
	 public String findProductByName(String name) throws SQLException;
	 public String findProductByCategory(String category) throws SQLException;
	 public String addProductToCart(String name, int quantity) throws SQLException;
	 public String deleteProductFromCart(String name, int quantity) throws SQLException;
	 public String showCurrentCart();
	 public String saveCart() throws SQLException;
	 public String buyCart() throws SQLException;
	 
}
