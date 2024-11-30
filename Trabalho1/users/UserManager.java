package users;

import java.util.HashMap;

public class UserManager{
    
    HashMap<String, User> users = new HashMap<String, User>();

    public boolean addUser(UserType userType, String name, String email, String password) throws Exception{
        if(users.containsKey(email)){
            System.out.println("Invalid register. E-mail already in use.");
            return false;
        }
        User newUser = (userType == UserType.ADMIN) 
            ? new Admin(userType, name, email, password, this) 
            : new Customer(userType, name, email, password);
        users.put(newUser.getEmail(), newUser);
        System.out.println("User successfully registered.");
        return true;
    }
}