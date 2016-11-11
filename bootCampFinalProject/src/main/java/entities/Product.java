package entities;

public class Product {
	 private int id_product;
	 private String name;
	 private String category;
	 private int stock;
	 private double price;
	 private int quantity;
	 
	 public Product(){
		 
	 }
	 
	 public Product(int id_product, int quantity){
		 this.setId_product(id_product);
		 this.setQuantity(quantity);
	 }
	 
	 
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	 
	 
}
