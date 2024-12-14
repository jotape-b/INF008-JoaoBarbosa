package app;
import auth.SessionManager;
import shopping.ProductManager;
import shopping.ShoppingCart;
import users.UserManager;
import users.UserType;
public class Main{
    public static void main(String[] args) throws Exception{
        ProductManager productManager = new ProductManager();
        ShoppingCart shoppingCart = new ShoppingCart(productManager);
        SessionManager sessionManager = new SessionManager(null, productManager, shoppingCart);
        
        UserManager userManager = new UserManager();
        sessionManager = new SessionManager(userManager, productManager, shoppingCart);

        userManager.addUser(UserType.ADMIN, "admin", "admin@email.com", "admin", "none");
        Menu menu = new Menu(sessionManager);
        menu.mainUserMenu();
    }
}