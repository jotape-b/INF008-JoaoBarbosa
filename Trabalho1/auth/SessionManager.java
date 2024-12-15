package auth;
import users.User;
import users.UserManager;

public class SessionManager {
    
    public static User loggedInUser;
    private UserManager userManager;
    
    public SessionManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean login(String email, String password) throws Exception{
        loggedInUser = userManager.authenticateUser(email, password);
        return (loggedInUser != null);
    }
    
    public void logout(){
        loggedInUser = null;
    }
}
