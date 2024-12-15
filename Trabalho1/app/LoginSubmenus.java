package app;

import java.util.Scanner;

import auth.SessionManager;
import users.UserManager;

public class LoginSubmenus {
    Scanner scanner = new Scanner(System.in);
    UserManager userManager = new UserManager();
    SessionManager sessionManager = new SessionManager(userManager);
    
    public LoginSubmenus(SessionManager sessionManager){
        this.sessionManager = sessionManager;
    }

    protected void loginMenu() throws Exception{
        String email, password;
        boolean isLoginFinished = false;
        
        do{
            System.out.println("-----------------------------\n");
            System.out.println("WELCOME!\n");
            System.out.println("PLEASE LOG-IN TO ACCESS THE SYSTEM.\n");
            System.out.println("\n");
            System.out.println("Email: ");
            email = scanner.nextLine();
            System.out.println("\nPassword: ");
            password = scanner.nextLine();
            isLoginFinished = sessionManager.login(email, password);
        }while (isLoginFinished == false);
    }

    protected void logoutMenu(){
        int selectedOption;
        System.out.println("DO YOU WISH TO LOGOUT?\n");

        System.out.println("\n1 - YES, LOG ME OUT.");
        System.out.println("\n2 - NO, TAKE ME BACK TO THE MAIN MENU.");
        System.out.println("\n3 - QUIT THE SYSTEM ALTOGETHER.");
        selectedOption = scanner.nextInt();
        scanner.nextLine();
        switch(selectedOption){
            case 1:
                sessionManager.logout();
                break;
        }
    }
}
