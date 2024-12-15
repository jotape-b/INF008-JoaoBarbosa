package users;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import shopping.OrderManager;
import shopping.ProductManager;

public class UserManager implements Serializable{
    
    private final HashMap<String, User> users = new HashMap<String, User>();
        
    public boolean addUser(UserType userType, String name, String email, String password, String deliveryAddress, ProductManager productManager, OrderManager orderManager) throws Exception{
        if(users.containsKey(email)){
            System.out.println("Invalid register. E-mail already in use.");
            return false;
        }
        User newUser = (userType == UserType.ADMIN) 
            ? new Admin(userType, name, email, password, this, productManager, orderManager)
            : new Customer(userType, name, email, password, deliveryAddress, productManager);
        System.out.println("User registration succcessful.");
        users.put(newUser.getEmail(), newUser);
        return true;
    }

    public User authenticateUser(String insertedEmail, String insertedPassword) throws Exception{
        User user = users.get(insertedEmail);
        if(user != null && PasswordHasher.verifyPassword(insertedPassword, user.getPassword(), user.getSalt())){
            System.out.println("Login successful.");
            return user;
        }
        else{
            System.out.println("Login failed. Incorrect password or email."); 
            return null;
        }
    }

    public List<Customer> getCustomers(){
        return users.values().stream()
            .filter(user -> user instanceof Customer) 
            .map(user -> (Customer) user) 
            .toList(); 
    }

    public HashMap<String, User> getUsers(){
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users.clear();
        this.users.putAll(users);
    }
}