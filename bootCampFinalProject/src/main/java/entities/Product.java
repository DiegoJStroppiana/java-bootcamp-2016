package entities;

public class Product {
	 private int id_product;
	 private String name;
	 private String category;
	 private int stock;
	 private double price;

	 
	 public Product(){
		 
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
	
	public String toString(){
		String product = new String();
		product = product.concat("Id_product: ").concat(Integer.toString(this.getId_product()));
		product = product.concat(" - Name: ").concat(this.getName());
		product = product.concat(" - Category: ").concat(this.getCategory());
		product = product.concat(" - Stock: ").concat(Integer.toString(this.getStock()));
		product = product.concat(" - Price: ").concat(Double.toString(this.getPrice())).concat("/// ");
		return product;
	}


}
