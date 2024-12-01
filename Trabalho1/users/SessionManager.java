package users;

public class SessionManager {

    private User loggedInUser;
    private UserManager userManager;

    public SessionManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean validateAddUser(UserType userType, String name, String email, String password) throws Exception{
        if(!(loggedInUser instanceof Admin)){
            System.out.println("Invalid action. User is not administrator.");
            return false;
        }
        System.out.println("User successfully registered.");
        return userManager.addUser(userType, name, email, password);
    }

    public void login(String email, String password) throws Exception{
        loggedInUser = userManager.authenticateUser(email, password);
    }

    public void logout(){
        loggedInUser = null;
    }
    
}
