package auth;

import shopping.ProductManager;
import users.Admin;
import users.User;
import users.UserManager;
import users.UserType;

public class SessionManager {

    private User loggedInUser;
    private UserManager userManager;
    private ProductManager productManager;

    public SessionManager(UserManager userManager, ProductManager productManager) {
        this.userManager = userManager;
        this.productManager = productManager;
    }

    private boolean isAdmin(){
        if(!(loggedInUser instanceof Admin)){
            System.out.println("Invalid action. User is not administrator.");
            return false;
        }
        return true;
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

    public void login(String email, String password) throws Exception{
        loggedInUser = userManager.authenticateUser(email, password);
    }

    public void logout(){
        loggedInUser = null;
    }
    
}
