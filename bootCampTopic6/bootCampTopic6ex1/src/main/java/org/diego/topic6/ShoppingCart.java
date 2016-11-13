package org.diego.topic6;

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
	
	public void addItem (Item i){
		items.add(i);
	}
	
	public void deleteItem (String name){
		for (Item i : items){
			if (i.getName().equals(name)){
				items.remove(i);
				break;
			}
		}
	}
	public void finalize(){
		shoppingcart = null;
		items = new ArrayList<Item>();
	}
	
	
	
	

}
