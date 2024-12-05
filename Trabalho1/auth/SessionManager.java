package auth;

import shopping.Order;
import shopping.ProductManager;
import shopping.ShoppingCart;
import users.Admin;
import users.User;
import users.UserManager;
import users.UserType;

public class SessionManager {

    private User loggedInUser;
    private UserManager userManager;
    private ProductManager productManager;
    private ShoppingCart shoppingCart;

    public SessionManager(UserManager userManager, ProductManager productManager, ShoppingCart shoppingCart) {
        this.userManager = userManager;
        this.productManager = productManager;
        this.shoppingCart = shoppingCart;
    }

    private boolean isAdmin(){
        if(!(loggedInUser instanceof Admin)){
            System.out.println("Invalid action. User is not administrator.");
            return false;
        }
        return true;
    }

    private boolean isLoggedIn(){
        return (loggedInUser != null);
    }

    public boolean validateAddUser(UserType userType, String name, String email, String password) throws Exception{
        if(!isAdmin()) return false;
        System.out.println("User successfully registered.");
        return userManager.addUser(userType, name, email, password);
    }

    public boolean validateAddProduct(String name, String description, float price, int inStock, String productType){
        if(!isAdmin()) return false;
        System.out.println("Product successfully registered.");
        return productManager.addProduct(name, description, price, inStock, productType);
    }

    public boolean validateAddToCart(int productId, int quantity){
        if(!isLoggedIn()) return false;
        System.out.println("Item added to cart.");
        return shoppingCart.addToCart(productId, quantity);
    }

    public boolean validateRemoveFromCart(int itemId, int quantity){
        if(!isLoggedIn()) return false;
        System.out.println("Item removed from cart.");
        return shoppingCart.removeFromCart(itemId, quantity);
    }

    public Order validateCheckout(){
        if(isLoggedIn()) return null;
        System.out.println("Order made.");
        return shoppingCart.checkout();
    }

    public void login(String email, String password) throws Exception{
        loggedInUser = userManager.authenticateUser(email, password);
    }

    public void logout(){
        loggedInUser = null;
    }
    
}
