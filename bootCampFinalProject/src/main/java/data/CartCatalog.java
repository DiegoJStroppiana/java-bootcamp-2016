package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Cart;
import entities.Product;

public class CartCatalog {
	private Statement statement;
	private ResultSet resultSet;	
	private static CartCatalog cartCatalog = null;
	
	
	private CartCatalog() {
	}
	
	public static CartCatalog getInstance() {
		if (cartCatalog == null) {
			cartCatalog = new CartCatalog();
		}
		return cartCatalog;
	}
	
	public boolean saveCart(Cart cart) throws SQLException{
		
		Connection connect = ConnectionDB.getInstance().getConnection();
		statement = connect.createStatement();
	    resultSet = statement.executeQuery("SELECT * FROM cart WHERE id_cart="+cart.getId_cart());
	    if(resultSet.next()){
	    	CartCatalog.getInstance().deleteCartFromDataBase(cart);
	    }
		
		int id_user=cart.getId_user();
		
		String query = " INSERT INTO cart (id_user, state)"
				+ " VALUES (?,?)";
		
		PreparedStatement preparedStmt = connect.prepareStatement(query);
		preparedStmt.setInt(1, id_user);
		preparedStmt.setString(2, "Saved");		
		preparedStmt.execute();
		
		statement = connect.createStatement();
	    resultSet = statement.executeQuery("SELECT MAX(id_cart) FROM cart");
	    resultSet.next();
	    int id_cart=resultSet.getInt(1);   		
		ArrayList<Product> productList = cart.getProductList();
		for(Product p : productList){
		  String query2 = " INSERT INTO cart_product (id_cart, id_product, quantity)"
			        + " VALUES (?, ?, ?)";
		      PreparedStatement preparedStmt2 = connect.prepareStatement(query2);
		      preparedStmt2.setInt (1, id_cart);
		      preparedStmt2.setInt (2, p.getId_product());
		      preparedStmt2.setInt (3, p.getQuantity());
		      preparedStmt2.execute();
		}
		return true;
	}
	
	public boolean deleteCartFromDataBase (Cart cart) throws SQLException{
		Connection connect = ConnectionDB.getInstance().getConnection();
		int id_user = cart.getId_user();
		statement = connect.createStatement();
		resultSet = statement.executeQuery("SELECT id_cart FROM cart WHERE id_user="+id_user);
	    resultSet.next();
	    int id_cart=resultSet.getInt(1);
	    String query = "DELETE FROM cart_product WHERE id_cart=?";
	    PreparedStatement preparedStmt = connect.prepareStatement(query);
	    preparedStmt.setInt (1, id_cart);
	    preparedStmt.execute();
	    
	    query = "DELETE FROM cart WHERE id_cart=?";
	    preparedStmt = connect.prepareStatement(query);
	    preparedStmt.setInt (1, id_cart);
	    preparedStmt.execute();

		return true;
	}
	
	public Cart getCartFromDataBase(int id_user) throws SQLException{
		Cart cart = new Cart();
		cart.setId_user(id_user);
		Connection connect = ConnectionDB.getInstance().getConnection();
		statement = connect.createStatement();
		resultSet = statement.executeQuery("SELECT id_cart, state FROM cart WHERE id_user="+id_user);
	    if(!resultSet.next()){
	    	return null;
	    }
	    
	    int id_cart = resultSet.getInt(1);
	    cart.setId_cart(id_cart);
	    cart.setState(resultSet.getString(2));
	    ArrayList<Product> productList = new ArrayList<Product>();
	    
	    resultSet = statement.executeQuery("SELECT cart_product.id_product, cart_product.quantity, product.name, product.category, product_price.price, product.stock"
	    		+ " FROM cart_product INNER JOIN product ON cart_product.id_product=product.id_product "
	    		+ " INNER JOIN product_price ON product.id_product=product_price.id_product "
	    		+ " WHERE cart_product.id_cart="+id_cart);
	    while(resultSet.next()){
	    	Product p = new Product();	    	
	    	p.setId_product(resultSet.getInt(1));
	    	p.setQuantity(resultSet.getInt(2));
	    	p.setName(resultSet.getString(3));
	    	p.setCategory(resultSet.getString(4));
	    	p.setPrice(resultSet.getDouble(5));	
	    	p.setStock(resultSet.getInt(6));
	    	productList.add(p);
	    }
	    cart.setProductList(productList);    
		return cart;
	}
	
	public boolean updateCartProducts(Cart cart, ArrayList<Product> productsAdded, ArrayList<Product> productsDeleted) throws SQLException{
		Connection connect = ConnectionDB.getInstance().getConnection();
		int id_cart = cart.getId_cart();
		
		for(Product p: productsAdded){
			String query = " INSERT INTO cart_product (id_cart, id_product, quantity) VALUES (?, ?, ?)";
		    PreparedStatement preparedStmt = connect.prepareStatement(query);
		    preparedStmt.setInt (1, id_cart);
		    preparedStmt.setInt (2, p.getId_product());
		    preparedStmt.setInt (3, p.getQuantity());
		    preparedStmt.execute();
		}
		
		for(Product p: productsDeleted){
			String query = "DELETE FROM cart_product WHERE id_cart=? AND id_product=?";
		    PreparedStatement preparedStmt = connect.prepareStatement(query);
		    preparedStmt.setInt (1, id_cart);
		    preparedStmt.setInt (2, p.getId_product());
		    preparedStmt.execute();
		}
		return false;
	}
	
		
}
