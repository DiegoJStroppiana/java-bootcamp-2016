package maven.exercise.bootCampTopic3Ex123;



import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class ServiceShoppingCartImpTest {
	
	static ServiceShoppingCartImp SSCI;
	static ServiceShoppingCartImp SSCI2;
	

    @Before
	public void setUpUT() throws Exception {
    	SSCI = new ServiceShoppingCartImp();
		ShoppingCart.getInstance().addItem(new Item("T-shirt", 50));
		ShoppingCart.getInstance().addItem(new Item("I-phone 7",700));
		ShoppingCart.getInstance().addItem(new Item("Smart TV 40'' ", 300));
		ShoppingCart.getInstance().addItem(new Item("Tablet Samsung 16'' ", 100));
		
	}
    
	
	@Test
	public void addItem() throws IOException {
		System.out.println("");
		System.out.println("Test 1: add new item");	
		SSCI.addItem(new Item("Tennis racket", 200));
		assertTrue(ShoppingCart.getInstance().getItems().size()==5);
		SSCI.showItems();
		ShoppingCart.getInstance().finalize();
	}
	
	@Test 
	public void deleteItem() throws IOException{
		System.out.println("");
		System.out.println("Test 2: delete item");	
		SSCI.deleteItem("Smart TV 40'' ");
		SSCI.showItems();
		assertTrue(ShoppingCart.getInstance().getItems().size()==3);
		ShoppingCart.getInstance().finalize();
	}
	
	@Test
	public void showItems() throws IOException{
		
		System.out.println("");
		System.out.println("Test 3: show items");
		assertTrue(ShoppingCart.getInstance().getItems().size()==4);
		SSCI.showItems();
		ShoppingCart.getInstance().finalize();
	}

}
