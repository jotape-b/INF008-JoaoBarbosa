package app;
import auth.SessionManager;
import shopping.OrderManager;
import shopping.ProductManager;
import users.Admin;
import users.Customer;
import users.UserManager;
import users.UserType;
public class Main{
    public static void main(String[] args) throws Exception{
        ProductManager productManager = new ProductManager();
        UserManager userManager = new UserManager();
        OrderManager orderManager = new OrderManager(userManager);
        SessionManager sessionManager = new SessionManager(userManager);

        userManager.addUser(UserType.ADMIN, "admin", "admin@email.com", "admin", "none", productManager, orderManager);
        LoginSubmenus loginSubmenus = new LoginSubmenus(sessionManager);

        while(SessionManager.loggedInUser == null){
            loginSubmenus.loginMenu();
            while(SessionManager.loggedInUser instanceof Customer){
                CustomerSubmenus customerSubmenus = new CustomerSubmenus(productManager, (Customer) SessionManager.loggedInUser);
                Menu menu = new Menu(loginSubmenus, null, customerSubmenus);
                menu.mainCustomerMenu();
            }
            while(SessionManager.loggedInUser instanceof Admin){
                AdminSubmenus adminSubmenus = new AdminSubmenus(productManager, userManager, orderManager, (Admin) SessionManager.loggedInUser);
                Menu menu = new Menu(loginSubmenus, adminSubmenus, null);
                menu.mainAdminMenu();
            }
        }
    }
}