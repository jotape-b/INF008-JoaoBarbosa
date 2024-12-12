package users;

import auth.SessionManager;

public class Admin extends User{
    private SessionManager sessionManager;

    public Admin(UserType userType, String name, String email, String password, SessionManager sessionManager) throws Exception{
        super(userType, name, email, password);
        this.sessionManager = sessionManager;
    }
    
    public boolean addUser(UserType userType, String name, String email, String password, String deliveryAddress) throws Exception{
        return sessionManager.validateAddUser(userType, name, email, password, deliveryAddress);
    }

    public boolean addProduct(String name, String description, float price, int inStock, String productType){
        return sessionManager.validateAddProduct(name, description, price, inStock, productType);
    }

    public boolean reportHighestOrderTotal(){
        return sessionManager.validateReportHighestOrderTotal();
    }

    public boolean reportLowestStock(){
        return sessionManager.validateReportLowestStock();
    }

    //create new product
    //create new user
        //Solicitar tipo do perfil do novo usuário, seu login e sua senha
    //report - more expensive order
    //report - product with lowerst inventory
    //exit
}
