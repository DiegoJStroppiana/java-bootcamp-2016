package maven.exercise.bootCampTopic3Ex123;

public class ServiceShoppingCartImp implements ServiceShoppingCart{

	public ServiceShoppingCartImp(){
		
	};
	/**
	  * This is a service which allows to add an item, delete one existing item and show
	  * actual items in a shopping cart
	  *@author Diego Jesús Stroppiana
	  *@version 1.0
	  *@see ShoppingCart
	  */
	
	public void addItem(Item i) {
		/**
		  * This method takes an item an adds it to a shopping cart
		  * @param i This parameter is an item which is added to a Shopping Cart	 
		  */
		
		ShoppingCart.getInstance().addItem(i);
	
	}

	public void deleteItem(String name) {	
		/**
		  * This method takes an item an deletes it from a Shopping Cart
		  * @param i This parameter is an item which is deleted from the existing Shopping Cart	 
		  */
		
		ShoppingCart.getInstance().deleteItem(name);
	}


	public void showItems() {	
		/**
		  * This method shows the actual shopping cart's items		  	 
		  */
		int count = 1;
		for (Item i: ShoppingCart.getInstance().getItems()){
			System.out.println(count++ +". Name: "+i.getName()+ " Price: " + i.getPrice());
			
		}
	}


}
