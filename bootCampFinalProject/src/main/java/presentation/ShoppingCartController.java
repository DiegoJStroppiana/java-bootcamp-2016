package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.ServiceShoppingCartImp;
import entities.Cart;
import entities.ProductCart;
import entities.User;


@RestController
public class ShoppingCartController {

	User userLoggedIn = null;
	Cart currentCart = null;
	ArrayList<ProductCart> productsAdded = new ArrayList<ProductCart>();
	ArrayList<ProductCart> productsDeleted = new ArrayList<ProductCart>();
	ArrayList<String> productsUpdated = new ArrayList<String>();
	
	
	@RequestMapping("/")
	public String welcome(){
		return ServiceShoppingCartImp.getInstance().welcome();
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value="nick_name", defaultValue="")String nick_name, @RequestParam(value="password", defaultValue="")String password, @RequestParam(value="newCart", defaultValue="no")String newCart) throws SQLException {
		
		return ServiceShoppingCartImp.getInstance().login(nick_name, password, newCart);
	}
	
	@RequestMapping("/logoff")
	public String logoff(){

		return ServiceShoppingCartImp.getInstance().logoff();
	}
	
	@RequestMapping("/register")
	public String register(@RequestParam(value="nick_name", defaultValue="")String nick_name, 
						@RequestParam(value="password", defaultValue="")String password, 
						@RequestParam(value="first_name", defaultValue="")String first_name, 
						@RequestParam(value="last_name", defaultValue="")String last_name) throws SQLException {
		
		return ServiceShoppingCartImp.getInstance().register(nick_name, password, first_name, last_name);
	}

	@RequestMapping("/findByName")
	public String findProductByName(@RequestParam(value="name", defaultValue="")String name) throws SQLException {
		return ServiceShoppingCartImp.getInstance().findProductByName(name);
	}

	@RequestMapping("/findByCategory")
	public String findProductByCategory(@RequestParam(value="category", defaultValue="")String category) throws SQLException {		
		return ServiceShoppingCartImp.getInstance().findProductByCategory(category);
	}

	@RequestMapping("/addProductToCart")
	public String addProductToCart(@RequestParam(value="name", defaultValue="") String name, 
							@RequestParam(value="quantity", defaultValue="1")int quantity) throws SQLException {
		return ServiceShoppingCartImp.getInstance().addProductToCart(name, quantity);
	}
	
	@RequestMapping("/deleteProductFromCart")
	public String deleteProductFromCart(@RequestParam(value="name", defaultValue="") String name,
								@RequestParam(value="quantity", defaultValue="0")int quantity) throws SQLException {
		
		return ServiceShoppingCartImp.getInstance().deleteProductFromCart(name, quantity);
	}
	
	@RequestMapping("/showCurrentCart")
	public String showCurrentCart(){
		return ServiceShoppingCartImp.getInstance().showCurrentCart();		
	}

	@RequestMapping("/saveCart")
	public String saveCart() throws SQLException {
		
		return ServiceShoppingCartImp.getInstance().saveCart();
	}
	
	@RequestMapping("/buyCurrentCart")
	public String buyCart() throws SQLException {

		return ServiceShoppingCartImp.getInstance().buyCart();
	}
	


}
