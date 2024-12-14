package app;
import java.util.Scanner;

import auth.SessionManager;
import users.UserManager;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private SessionManager sessionManager;
    public Menu(SessionManager sessionManager){
        this.sessionManager = sessionManager;
    }

    protected void mainUserMenu() throws Exception{
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
