package entities;

public class ProductCart extends Product {

	 private int quantity;
	 
	 public ProductCart(){
		 
	 }
	 
	 public ProductCart(int id_product, int quantity){
		 this.setId_product(id_product);
		 this.setQuantity(quantity);
	 }

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	 
	 
}
