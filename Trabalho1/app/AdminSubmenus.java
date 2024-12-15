package app;

import java.util.Scanner;

import shopping.OrderManager;
import shopping.ProductManager;
import shopping.ShoppingCart;
import users.UserManager;
import users.UserType;

public class AdminSubmenus {
    Scanner scanner = new Scanner(System.in);
    ProductManager productManager = new ProductManager();
    UserManager userManager = new UserManager();
    OrderManager orderManager;
    ShoppingCart shoppingCart;

    public AdminSubmenus(ProductManager productManager, UserManager userManager, OrderManager orderManager){
        this.productManager = productManager;
        this.userManager = userManager;
        this.orderManager = orderManager;
    }

    protected void newProductMenu(){
        String name;
        String description;
        double price;
        int stock;
        String category;
        boolean isOperationFinished = false;
        System.out.println("INSERT PRODUCT DATA");

        do{
            System.out.println("\nName: ");
                name = scanner.nextLine();
            System.out.println("\nDescription: ");
                description = scanner.nextLine();
            System.out.println("\nPrice: ");
                price = scanner.nextDouble();
            System.out.println("\nStock: ");
                stock = scanner.nextInt();
                scanner.nextLine();
            System.out.println("\nCategory: ");
                category = scanner.nextLine();
            isOperationFinished = productManager.addProduct(name, description, price, stock, category);
        }while(isOperationFinished == false);
    }

    protected void newUserMenu() throws Exception{
        UserType userType = null;
        String name;
        String email;
        String password;
        String deliveryAddress = "none";
        boolean isOperationFinished = false;

        System.out.println("INSERT USER DATA");

        do{
            System.out.println("\nUser Type (ADMIN OR CUSTOMER): ");
                String input = scanner.nextLine().toUpperCase();
                userType = UserType.valueOf(input);
            System.out.println("\nName");
                name = scanner.nextLine();
            System.out.println("\nEmail");
                email = scanner.nextLine();
            System.out.println("\nPassword");
                password = scanner.nextLine();
            if(userType == UserType.CUSTOMER){
                System.out.println("\nDelivery Address: ");
                deliveryAddress = scanner.nextLine();
            }
            isOperationFinished = userManager.addUser(userType, name, email, password, deliveryAddress, productManager, orderManager);
        }while(isOperationFinished == false);
    }

    protected void mostExpensiveOrderReportMenu(){
        System.out.println("REPORT - MOST EXPENSIVE ORDER: \n");
        orderManager.reportHighestOrderTotal();
    }

    protected void lowestStockReportMenu(){
        System.out.println("REPORT - PRODUCT WITH LOWEST TOTAL STOCK: \n");
        productManager.reportLowestStock();
    }

    /*◦ Para usuários administradores:
    ▪ Create new product
    ▪ Create new user
        • Deverá solicitar se o novo usuário sendo criado é um cliente ou um
        administrador, seu login e sua senha.
    ▪ Report – more expensive order
    ▪ Report – product with lowest inventory
    ▪ Exit*/
    
}
