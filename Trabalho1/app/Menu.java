package app;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private AdminSubmenus adminSubmenus;
    private CustomerSubmenus customerSubmenus;
    public Menu(AdminSubmenus adminSubmenus, CustomerSubmenus customerSubmenus){
        this.adminSubmenus = adminSubmenus;
        this.customerSubmenus = customerSubmenus;
    }

    protected boolean mainAdminMenu() throws Exception{
        int selectedOption;
        while(true){
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
                case 5:
                    return true;
                default:
                    System.out.println("Invalid entry.");
                    break;
            }
        }
    }

    protected boolean mainCustomerMenu() throws IOException{
        int selectedOption;
        while(true){
            System.out.println("-----------------------------\n");
            System.out.println("CUSTOMER MENU\n");
            System.out.println("-----------------------------");
            
            System.out.println("\n1 - START NEW ORDER");
            System.out.println("\n2 - EXIT");
            selectedOption = scanner.nextInt();
            switch(selectedOption){
                case 1:
                    customerSubmenus.newOrderMenu();
                    break;
                case 2:
                    return true;
                default:
                    System.out.println("Invalid entry.");
                    break;
            }
        }
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
