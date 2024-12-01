package users;

public class SessionManager {

    private User loggedInUser;
    private UserManager userManager;

    public SessionManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public void login(String email, String password) throws Exception{
        loggedInUser = userManager.authenticateUser(email, password);
    }

    public void logout(){
        loggedInUser = null;
    }

    public boolean isAdmin(){
        return loggedInUser instanceof Admin;
    }

    public User getLoggedInUser(){
        return loggedInUser;
    }
    
}
