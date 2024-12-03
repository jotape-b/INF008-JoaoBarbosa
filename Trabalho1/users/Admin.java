package users;

import auth.SessionManager;

public class Admin extends User{
    private SessionManager sessionManager;

    public Admin(UserType userType, String name, String email, String password) throws Exception{
        super(userType, name, email, password);
    }
    
    public boolean addUser(UserType userType, String name, String email, String password) throws Exception{
        return sessionManager.validateAddUser(userType, name, email, password);
    }

    public boolean addProduct(String name, String description, float price, int inStock, String productType){
        return sessionManager.validateAddProduct(name, description, price, inStock, productType);
    }

    // public boolean addProduct(String name, String description, float price, int inStock, String productType, User user){
    //     return ProductManager.addProduct(name, description, price, inStock, productType, );
    // }

    //gerenciar produtos
    //acessar relatórios

    //create new product
    //create new user
        //Solicitar tipo do perfil do novo usuário, seu login e sua senha
    //report - more expensive order
    //report - product with lowerst inventory
    //exit
}
