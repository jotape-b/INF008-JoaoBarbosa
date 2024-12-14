package app;
import auth.SessionManager;
import shopping.OrderManager;
import shopping.ProductManager;
import shopping.ShoppingCart;
import users.Admin;
import users.Customer;
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
        CustomerSubmenus customerSubmenus = new CustomerSubmenus(productManager, shoppingCart);

        userManager.addUser(UserType.ADMIN, "admin", "admin@email.com", "admin", "none", productManager, orderManager, shoppingCart);
        Menu menu = new Menu(sessionManager, adminSubmenus, customerSubmenus);

        while(true){
            if((SessionManager.loggedInUser instanceof Admin)){
                menu.mainAdminMenu();
            }
            if(SessionManager.loggedInUser instanceof Customer){
                menu.mainCustomerMenu();
            }
            if(SessionManager.loggedInUser == null){
                menu.loginMenu();
            }
        }
    }
}