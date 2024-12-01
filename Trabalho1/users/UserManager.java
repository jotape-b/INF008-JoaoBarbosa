package users;

import java.util.HashMap;

public class UserManager{
    
    private HashMap<String, User> users = new HashMap<String, User>();
    private SessionManager sessionManager;
    
    public boolean addUser(UserType userType, String name, String email, String password) throws Exception{
        if(!sessionManager.isAdmin()){
            System.out.println("Invalid action. User is not administrator.");
            return false;
        }
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
}