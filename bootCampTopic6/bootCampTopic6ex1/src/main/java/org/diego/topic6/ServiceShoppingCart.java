package org.diego.topic6;

public interface ServiceShoppingCart {
	public String addItem(String name, double price);
	public String deleteItem(String name);
	public ShoppingCart showItems();
}
