package app;
import java.util.Scanner;

import auth.SessionManager;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private SessionManager sessionManager;
    private AdminSubmenus adminSubmenus;
    public Menu(SessionManager sessionManager, AdminSubmenus adminSubmenus){
        this.sessionManager = sessionManager;
        this.adminSubmenus = adminSubmenus;
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

    protected void mainAdminMenu() throws Exception{
        int selectedOption;
        do{
            System.out.println("-----------------------------\n");
            System.out.println("ADMIN MENU\n");
            System.out.println("-----------------------------");

            System.out.println("\n1 - CREATE NEW PRODUCT");
            System.out.println("\n2 - CREATE NEW USER");
            System.out.println("\n3 - REPORT: MOST EXPENSIVE ORDER");
            System.out.println("\n4 - REPORT: PRODUCT WITH LOWEST INVENTORY");
            System.out.println("\n5 - EXIT");
            selectedOption = scanner.nextInt();
            switch(selectedOption){
                case 1:
                    adminSubmenus.newProductMenu();
                    break;
                case 2:
                    adminSubmenus.newUserMenu();
                    break;
                case 3:
                    adminSubmenus.mostExpensiveOrderReportMenu();
                    break;
                case 4:
                    adminSubmenus.lowestStockReportMenu();
                    break;
                default:
                    System.out.println("Invalid entry.");
                    break;
            }
        }while(selectedOption != 5);

    }

            
        /*• Menus e submenus a serem criados:

        ◦ Para ambos os usuários (primeiro menu apresentado):
            ▪ Login
                • Solicitar usuário e senha e realizar a validação.
                • O sistema deve ser entregue com um único usuário “admin” (com senha “admin”)
                criado.
        ◦ Para usuários administradores:
            ▪ Create new product
            ▪ Create new user
                • Deverá solicitar se o novo usuário sendo criado é um cliente ou um
                administrador, seu login e sua senha.
            ▪ Report – more expensive order
            ▪ Report – product with lowest inventory
            ▪ Exit
        ◦ Para usuários clientes:
            ▪ Start new order
                • Add product
                • View shopping cart
                    ◦ Listar todos os produtos incluídos no carrinho de compras
                • Finish order
            ▪ Exit */
    
}
