package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Product;

public class ProductCatalog {
	
	private Statement statement;
	private ResultSet resultSet;	
	private static ProductCatalog productCatalog = null;
	
	
	private ProductCatalog() {
	}
	
	public static ProductCatalog getInstance() {
		if (productCatalog == null) {
			productCatalog = new ProductCatalog();
		}
		return productCatalog;
	}
	
	public Product findByName(String name) throws SQLException{
		Connection connect = ConnectionDB.getInstance().getConnection();
		statement = connect.createStatement();
	    resultSet = statement.executeQuery("SELECT * FROM product "
	    		+ " INNER JOIN product_price ON product.id_product=product_price.id_product"
	    		+ " WHERE name='"+name+"'");
	    if(!resultSet.next()){
	    	return null;
	    	}
		Product p = new Product();
		p.setId_product(resultSet.getInt("product.id_product"));
		p.setName(resultSet.getString("product.name"));
		p.setCategory(resultSet.getString("product.category"));
		p.setStock(resultSet.getInt("product.stock"));
		p.setPrice(resultSet.getDouble("product_price.price"));
		return p;
	}
	
	public ArrayList<Product> findByCategory(String category) throws SQLException{
		ArrayList<Product> productList = new ArrayList<Product>();
		Connection connect = ConnectionDB.getInstance().getConnection();
		statement = connect.createStatement();
	    resultSet = statement.executeQuery("SELECT * FROM product "
	    		+ " INNER JOIN product_price ON product.id_product=product_price.id_product"
	    		+ " WHERE category='"+category+"'");
	    if(resultSet.wasNull()){
	    	return null;
	    }
	    
	    while(resultSet.next()){	    	
			Product p = new Product();
			p.setId_product(resultSet.getInt("product.id_product"));
			p.setName(resultSet.getString("product.name"));
			p.setCategory(resultSet.getString("product.category"));
			p.setStock(resultSet.getInt("product.stock"));
			p.setPrice(resultSet.getDouble("product_price.price"));
			productList.add(p);
	    }
		return productList;
	}
	
	public boolean updateStock(int id_product, int quantity)throws SQLException{
		
		Connection connect = ConnectionDB.getInstance().getConnection();
		statement = connect.createStatement();
	    resultSet = statement.executeQuery("SELECT stock FROM product WHERE id_product="+id_product);		
	    if(resultSet.next()){
	    	int stock = resultSet.getInt(1);
	    	stock = stock - quantity;
	    	String query = "UPDATE product SET stock=? WHERE id_product=?";
		    PreparedStatement preparedStmt = connect.prepareStatement(query);
		    preparedStmt.setInt (1, stock);
		    preparedStmt.setInt (2, id_product);
		    preparedStmt.execute();
	    	return true;
	    }
		return false;
	}
	
	
	
}
