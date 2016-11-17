package entities;

import java.sql.SQLException;
import java.util.ArrayList;

import data.ProductCatalog;


public class Cart {
	private int id_cart; 
	private int id_user;
	private String state;
	private ArrayList<ProductCart> productList= new ArrayList<ProductCart>();
	
	
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

	public ArrayList<ProductCart> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<ProductCart> productList) {
		this.productList = productList;
	}
	
	public boolean addProduct(ProductCart p) throws SQLException{
				if(ProductCatalog.getInstance().suficientStock(p.getId_product(), p.getQuantity())){
					productList.add(p);
					return true;
				}
			return false;	
	}
	
	public boolean addAQuantityOfAProduct(int id_product,int quantity) throws SQLException{
		for (ProductCart p : productList){
			if(p.getId_product()==id_product){
				int stockRequired = p.getQuantity()+quantity; 
				if(ProductCatalog.getInstance().suficientStock(p.getId_product(), stockRequired)){
					p.setQuantity(stockRequired);
					return true;
				}
				}
	
			}
		return false;
		}
	
	
	public boolean containsProduct(String name){
		for (Product p : productList){
			if(p.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
		
	public boolean removeProduct(int id_product){
		for (ProductCart p : productList){
			if(p.getId_product()==id_product){
				productList.remove(p);
				return true;
			}
		}
		return false;
	}	
	
	public boolean removeQuantityOfAProduct(int id_product, int quantity){
		for (ProductCart p : productList){
			if(p.getId_product()==id_product){
				if(p.getQuantity()>=quantity){
				p.setQuantity(p.getQuantity()-quantity);
				return true;
				}
			}
		}
		return false;
	}	
	
	public String toString(){
		Double totalPrice = 0.0;
		String result = new String();
		result = result.concat(" Id_cart: ");
		result = result.concat(Integer.toString(this.getId_cart()));
		result = result.concat(" - Id_user: ");
		result = result.concat(Integer.toString(this.getId_user()));
		result = result.concat(" - State: ");
		result = result.concat(this.getState());
		result = result.concat(" - Product list: ///" );
		for (ProductCart p : this.getProductList()){
			if(p.getQuantity()!=0){
			result = result.concat(" - Id_product: ").concat(Integer.toString(p.getId_product()));
			result = result.concat(" - Name: ").concat(p.getName());
			result = result.concat(" - Category: ").concat(p.getCategory());
			result = result.concat(" - Price: ").concat(Double.toString(p.getPrice()));
			result = result.concat(" - Quantity: ").concat(Integer.toString(p.getQuantity()));
			totalPrice = totalPrice + (p.getQuantity()*p.getPrice());
			}
		}
		result = result.concat(" /// ").concat(" Total price: ").concat(Double.toString(totalPrice));
		return result;
	}
	 
}
