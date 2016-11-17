package business;

import java.sql.SQLException;
import java.util.ArrayList;
import data.CartCatalog;
import data.ProductCatalog;
import data.UserCatalog;
import entities.Cart;
import entities.Product;
import entities.ProductCart;
import entities.User;


public class ServiceShoppingCartImp implements ServiceShoppingCart{

	private User userLoggedIn = null;
	private Cart currentCart = null;
	private ArrayList<ProductCart> productsAdded = new ArrayList<ProductCart>();
	private ArrayList<ProductCart> productsDeleted = new ArrayList<ProductCart>();
	private ArrayList<String> productsUpdated = new ArrayList<String>();
	
	
	private static ServiceShoppingCartImp serviceShoppingCartImp = null;
	
	
	private ServiceShoppingCartImp() {
	}
	
	public static ServiceShoppingCartImp getInstance() {
		if (serviceShoppingCartImp == null) {
			serviceShoppingCartImp = new ServiceShoppingCartImp();
		}
		return serviceShoppingCartImp;
	}
	
	public String welcome(){
		return "Welcome to shopping cart REST api";
	}


	public String login(String nick_name, String password, String newCart) throws SQLException {
		if (userLoggedIn!=null){
			return "You are already logged in";
		}
		User u = UserCatalog.getInstance().getUser(nick_name);
		if (u==null||!u.getPassword().equals(password)){
			return "Incorrect user or password";
		}else{
			userLoggedIn = u;;
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
	

	public String logoff(){
		if (userLoggedIn==null){
			return "You aren't logged in";
		}
		userLoggedIn = null;
		currentCart = new Cart();
		return "User logged off";
	}
	

	public String register(String nick_name,String password,String first_name, String last_name) throws SQLException {
		if(UserCatalog.getInstance().newUser(nick_name, password, first_name, last_name)){
			userLoggedIn = UserCatalog.getInstance().getUser(nick_name);
			return "User Created";			
		}
		return "Nickname already exists";
	}


	public String findProductByName(String name) throws SQLException {
		Product p = ProductCatalog.getInstance().findByName(name);
		if (p==null){
			return "Product doesn't exist";
		}
		return p.toString();
	}
	
	public String findProductByCategory(String category) throws SQLException {		
		ArrayList<Product> productList = ProductCatalog.getInstance().findByCategory(category);
		if(productList.size()==0){
			return "Category doesn't exist or has not any product";	
		}
		String product = new String();
		for (Product p: productList){			
			product = product.concat(p.toString());
		}
		return product;
	}

	public String addProductToCart(String name, int quantity) throws SQLException {
		if (userLoggedIn==null){
			return "You must be logged in";
		}
		if (ProductCatalog.getInstance().findByName(name)==null){
			return "Product doesn't exist";
		}
		Product product = ProductCatalog.getInstance().findByName(name);
		ProductCart p = new ProductCart();
		p.setCategory(product.getCategory());
		p.setId_product(product.getId_product());
		p.setName(product.getName());
		p.setPrice(product.getPrice());
		p.setQuantity(quantity);
		if(currentCart.containsProduct(name)){
			if(currentCart.addAQuantityOfAProduct(p.getId_product(), quantity)){
				currentCart.setState("Not saved");
				productsUpdated.add(name);
				return "Quantity added to cart";
			}
			return "Insuficient stock";
			
		}
		if(currentCart.addProduct(p)){
			if (currentCart.getId_cart()!=0){
				productsAdded.add(p);
			}
			currentCart.setState("Not saved");
			return "Item added to cart";
		}
		return "Insuficient stock";
	}
	
	public String deleteProductFromCart( String name,int quantity) throws SQLException {
		if (userLoggedIn==null){
			return "You must be logged in";
		}
		if (ProductCatalog.getInstance().findByName(name)==null){
			return "Product doesn't exist";
		}
		int id_product = ProductCatalog.getInstance().findByName(name).getId_product();
		if(quantity!=0){
			if(currentCart.removeQuantityOfAProduct(id_product, quantity)){
			currentCart.setState("Not saved");
			productsUpdated.add(name);
			return "You've removed " + quantity + " of " + name;
			}
			return "There isn't so many products of this type";
		}
		if(currentCart.removeProduct(id_product)){
			currentCart.setState("Not saved");
			if (currentCart.getId_cart()!=0){
				Product product = ProductCatalog.getInstance().findByName(name);
				ProductCart p = new ProductCart();
				p.setCategory(product.getCategory());
				p.setId_product(product.getId_product());
				p.setName(product.getName());
				p.setPrice(product.getPrice());
				p.setQuantity(quantity);
				productsDeleted.add(p);
			}
			return "Item deleted from cart";
		}
		return "Product isn't in the cart";
	}
	
	public String showCurrentCart(){
		if(userLoggedIn==null){
			return "You aren't logged in";
		}
		if(currentCart.getProductList().size()==0){
			return "Empty cart";
		}		
		return currentCart.toString();		
	}

	public String saveCart() throws SQLException {
		if(userLoggedIn==null){
			return "You must be logged in";
		}
		if (currentCart.getProductList().size()==0){
			if (currentCart.getId_cart()!=0){
				CartCatalog.getInstance().deleteCartFromDataBase(currentCart);
				return "Your cart has not any products - Your cart has been removed";
			}
			return "Your cart has not any products";
		}
		if (currentCart.getId_cart()!=0){
			CartCatalog.getInstance().updateCartProducts(currentCart, productsAdded, productsDeleted, productsUpdated);
			productsAdded = new ArrayList<ProductCart>();
			productsDeleted = new ArrayList<ProductCart>();
			productsUpdated = new ArrayList<String>();
			currentCart.setState("Saved");
		} else {
			currentCart.setState("Saved");
			CartCatalog.getInstance().saveCart(currentCart);
		}			
		currentCart=CartCatalog.getInstance().getCartFromDataBase(userLoggedIn.getId_user());
		return "Your cart has been saved";
	}
	
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
		ArrayList<ProductCart> productListToUpdate = currentCart.getProductList();
		for(ProductCart p : productListToUpdate){
			ProductCatalog.getInstance().updateStock(p.getId_product(), p.getQuantity());
		}
		currentCart = new Cart();
		currentCart.setId_user(userLoggedIn.getId_user());
		currentCart.setState("Not saved");
		return "Succefull Purchase";
	}
	


}
