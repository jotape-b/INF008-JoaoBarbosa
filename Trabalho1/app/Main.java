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
        DataManager dataManager = new DataManager();
        LoginSubmenus loginSubmenus = new LoginSubmenus(sessionManager);

        dataManager.loadData(userManager, productManager);

        userManager.addUser(UserType.ADMIN, "admin", "admin@email.com", "admin", "none", productManager, orderManager);

        boolean logout = false;
        while(true){
            if(SessionManager.loggedInUser == null){
                loginSubmenus.loginMenu();
                logout = false;
            }
            while(SessionManager.loggedInUser instanceof Customer && logout == false){
                CustomerSubmenus customerSubmenus = new CustomerSubmenus(productManager, (Customer) SessionManager.loggedInUser);
                Menu menu = new Menu(null, customerSubmenus);
                logout = menu.mainCustomerMenu();
            }
            while(SessionManager.loggedInUser instanceof Admin && logout == false){
                AdminSubmenus adminSubmenus = new AdminSubmenus(productManager, userManager, orderManager, (Admin) SessionManager.loggedInUser);
                Menu menu = new Menu(adminSubmenus, null);
                logout = menu.mainAdminMenu();
            }
            if(logout == true){
                logout = loginSubmenus.logoutMenu(dataManager, userManager, productManager);
            }
        }
    }
}