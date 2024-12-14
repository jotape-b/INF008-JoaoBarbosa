package app;
import auth.SessionManager;
import shopping.OrderManager;
import shopping.ProductManager;
import shopping.ShoppingCart;
import users.Admin;
import users.UserManager;
import users.UserType;
public class Main{
    public static void main(String[] args) throws Exception{
        ProductManager productManager = new ProductManager();
        UserManager userManager = new UserManager();
        ShoppingCart shoppingCart = new ShoppingCart(productManager);
        OrderManager orderManager = new OrderManager(userManager);
        SessionManager sessionManager = new SessionManager(userManager);

        AdminSubmenus adminSubmenus = new AdminSubmenus(productManager, userManager, orderManager);

        userManager.addUser(UserType.ADMIN, "admin", "admin@email.com", "admin", "none", productManager, orderManager, shoppingCart);
        Menu menu = new Menu(sessionManager, adminSubmenus);
        menu.loginMenu();
        if((SessionManager.loggedInUser instanceof Admin)){
            menu.mainAdminMenu();
        }
    }
}