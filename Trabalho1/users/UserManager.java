package users;

import java.util.HashMap;
import java.util.HashSet;

public class UserManager{
    
    HashMap<Integer, User> users = new HashMap<Integer, User>();
    HashSet<String> registeredEmails = new HashSet<String>();

    public boolean addUser(UserType userType, String name, String email, String password) throws Exception{
        if(registeredEmails.contains(email)){
            System.out.println("Invalid register. E-mail already in use.");
            return false;
        }
        User newUser = (userType == UserType.ADMIN) 
            ? new Admin(userType, name, email, password, this) 
            : new Customer(userType, name, email, password);
        users.put(newUser.getId(), newUser);
        registeredEmails.add(email);
        System.out.println("User successfully registered.");
        return true;
    }
}