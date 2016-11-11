package business;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.CartCatalog;
import data.ProductCatalog;
import data.UserCatalog;
import entities.Cart;
import entities.Product;
import entities.User;

@RestController
public class ServiceShoppingCartImp implements ServiceShoppingCart{

	User userLoggedIn;
	Cart currentCart;
	ArrayList<Product> productsAdded = new ArrayList<Product>();
	ArrayList<Product> productsDeleted = new ArrayList<Product>();;
	
	@RequestMapping("/")
	public String welcome(){
		return "Welcome to shopping cart REST api";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value="nick_name", defaultValue="")String nick_name, @RequestParam(value="password", defaultValue="")String password, @RequestParam(value="newCart", defaultValue="no")String newCart) throws SQLException {
		User u = UserCatalog.getInstance().getUser(nick_name);
		if (u==null){
			return "User doesn't exist";
		}
		if (u.getPassword().equals(password)){
			userLoggedIn = u;
		} else{
			return "Incorrect password";
		}
		
		currentCart=CartCatalog.getInstance().getCartFromDataBase(u.getId_user());
		if (currentCart==null){
			currentCart = new Cart();
			currentCart.setId_user(u.getId_user());
			currentCart.setState("Not saved");
		} else { if (newCart.equals("Yes")){
					CartCatalog.getInstance().deleteCartFromDataBase(currentCart);	
					currentCart = new Cart();
					currentCart.setId_user(u.getId_user());
					currentCart.setState("Not saved");
					}		
		}
		
		return "User logged";
	}
	
	@RequestMapping("/logoff")
	public String logoff(){
		if (userLoggedIn==null){
			return "You aren't logged in";
		}
		userLoggedIn = null;
		currentCart = new Cart();
		return "User logged off";
	}
	
	@RequestMapping("/register")
	public String register(@RequestParam(value="nick_name", defaultValue="")String nick_name, 
						@RequestParam(value="password", defaultValue="")String password, 
						@RequestParam(value="first_name", defaultValue="")String first_name, 
						@RequestParam(value="last_name", defaultValue="")String last_name) throws SQLException {
		UserCatalog.getInstance().newUser(nick_name, password, first_name, last_name);
		userLoggedIn = UserCatalog.getInstance().getUser(nick_name);
		return "User Created";
	}

	@RequestMapping("/findByName")
	public Product findProductByName(@RequestParam(value="name", defaultValue="")String name) throws SQLException {
		Product p = ProductCatalog.getInstance().findByName(name);
		return p;
	}

	@RequestMapping("/findByCategory")
	public ArrayList<Product> findProductByCategory(@RequestParam(value="category", defaultValue="")String category) throws SQLException {		
		ArrayList<Product> productList = ProductCatalog.getInstance().findByCategory(category);
		return productList;
	}

	@RequestMapping("/addProductToCart")
	public String addProductToCart(@RequestParam(value="name", defaultValue="") String name, 
							@RequestParam(value="quantity", defaultValue="1")int quantity) throws SQLException {
		if (userLoggedIn==null){
			return "You must be logged in";
		}
		if (ProductCatalog.getInstance().findByName(name)==null){
			return "Product doesn't exist";
		}
		Product p = ProductCatalog.getInstance().findByName(name);
		p.setQuantity(quantity);
		
		currentCart.addProduct(p);
		if (currentCart.getId_cart()!=0){
			productsAdded.add(p);
		}
		currentCart.setState("Not saved");
		return "Item added to cart";
	}
	
	@RequestMapping("/deleteProductFromCart")
	public String deleteProductFromCart(@RequestParam(value="name", defaultValue="") String name) throws SQLException {
		if (userLoggedIn==null){
			return "You must be logged in";
		}
		if (ProductCatalog.getInstance().findByName(name)==null){
			return "Product doesn't exist";
		}
		int id_product = ProductCatalog.getInstance().findByName(name).getId_product();
		if(currentCart.removeProduct(id_product)){
			currentCart.setState("Not saved");
			if (currentCart.getId_cart()!=0){				
				productsDeleted.add(ProductCatalog.getInstance().findByName(name));
			}
			return "Item deleted from cart";
		}
		return "Product isn't in the cart";
	}
	
	@RequestMapping("/showCurrentCart")
	public Cart showCurrentCart(){
		return currentCart;		
	}

	@RequestMapping("/saveCart")
	public String saveCart() throws SQLException {
		if(userLoggedIn==null){
			return "You must be logged in";
		}
		if (currentCart.getProductList().size()==0){
			return "Your cart has not any products";
		}
		if (currentCart.getId_cart()!=0){
			CartCatalog.getInstance().updateCartProducts(currentCart, productsAdded, productsDeleted);
			productsAdded = new ArrayList<Product>();
			productsDeleted = new ArrayList<Product>();;
		} else {
			currentCart.setState("Saved");
			CartCatalog.getInstance().saveCart(currentCart);
		}	
		currentCart=CartCatalog.getInstance().getCartFromDataBase(userLoggedIn.getId_user());
		return "Your cart has been saved";
	}
	
	@RequestMapping("/buyCurrentCart")
	public String buyCart() throws SQLException {
		if(userLoggedIn==null){
			return "You must be logged in";
		}
		if (currentCart.getProductList().size()==0){
			return "Your cart has not any products";
		}
		if (currentCart.getId_cart()!=0){
		CartCatalog.getInstance().deleteCartFromDataBase(currentCart);
		}
		ArrayList<Product> productListToUpdate = currentCart.getProductList();
		for(Product p : productListToUpdate){
			ProductCatalog.getInstance().updateStock(p.getId_product(), p.getQuantity());
		}
		currentCart = new Cart();
		currentCart.setId_user(userLoggedIn.getId_user());
		currentCart.setState("Not saved");
		return "Succefull Purchase";
	}
	


}
