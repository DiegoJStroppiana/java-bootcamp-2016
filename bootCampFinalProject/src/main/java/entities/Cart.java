package entities;

import java.sql.SQLException;
import java.util.ArrayList;


public class Cart {
	private int id_cart; 
	private int id_user;
	private String state;
	private ArrayList<Product> productList= new ArrayList<Product>();
	
	
	public Cart(){	
	}
		
	public int getId_cart() {
		return id_cart;
	}
	public void setId_cart(int id_cart) {
		this.id_cart = id_cart;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	
	public void addProduct(Product p) throws SQLException{
				productList.add(p);
	}
	
	public boolean removeProduct(int id_product){
		for (Product p : productList){
			if(p.getId_product()==id_product){
				productList.remove(p);
				return true;
			}
		}
		return false;
	}	
	 
}
