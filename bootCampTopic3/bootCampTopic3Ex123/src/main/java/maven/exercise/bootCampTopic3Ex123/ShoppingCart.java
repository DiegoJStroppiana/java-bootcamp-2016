package maven.exercise.bootCampTopic3Ex123;

import java.util.ArrayList;



public class ShoppingCart {
	
	private static ArrayList<Item> items = new ArrayList<Item>();	
	private static ShoppingCart shoppingcart = null;

	public ShoppingCart() {	
	}
	
	public static ShoppingCart getInstance() {
		if (shoppingcart == null) {
			shoppingcart = new ShoppingCart();
		}
		return shoppingcart;
	}
	
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		ShoppingCart.items = items;
	}
	
	public boolean addItem (Item i){
		return items.add(i);		
	}
	
	
	public boolean deleteItem (String name){
		for (Item i : items){
			if (i.getName().equals(name)){
				return items.remove(i);
			}
		}
		return false;
	}
	public void finalize(){
		shoppingcart = null;
		items = new ArrayList<Item>();
	}
	
	
	
	

}
