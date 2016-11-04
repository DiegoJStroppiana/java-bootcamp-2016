package org.diego.topic6;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ServiceShoppingCartImp implements ServiceShoppingCart{

	ShoppingCart cartInstance = ShoppingCart.getInstance();
	ArrayList<Item> itemList = null;
	
	
	@RequestMapping("/")
	String ShoppingCart(){
		return "Shopping Cart API";
	}
	
	@RequestMapping("/add")
	public String addItem(@RequestParam(value="name", defaultValue="null") String name , @RequestParam(value="price", defaultValue="0") double price  ) {
		Item i = new Item(name, price);
		cartInstance.addItem(i);
		return "Item " + name + " added";
	
	}

	@RequestMapping("/delete")
	public String deleteItem(@RequestParam(value="name", defaultValue="null") String name) {
		cartInstance.deleteItem(name);
		return "Item " + name + " deleted";
	}

	@RequestMapping("/showItems")
	public ShoppingCart showItems() {
		return cartInstance;
	}


}
