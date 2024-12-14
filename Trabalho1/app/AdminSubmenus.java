package app;

import java.util.Scanner;

import shopping.ProductManager;

public class AdminSubmenus {
    ProductManager productManager = new ProductManager();
    Scanner scanner = new Scanner(System.in);
    public AdminSubmenus(ProductManager productManager){
        this.productManager = productManager;
    }

    protected void newProductMenu(){
        String name;
        String description;
        double price;
        int stock;
        String category;
        boolean isOperationFinished = false;
        System.out.println("INSERT PRODUCT DATA\n");

        do{
            System.out.println("\nName: ");
                name = scanner.nextLine();
            System.out.println("\nDescription: ");
                description = scanner.nextLine();
            System.out.println("\nPrice: ");
                price = scanner.nextDouble();
            System.out.println("\nStock: ");
                stock = scanner.nextInt();
            System.out.println("\nCategory: ");
                category = scanner.nextLine();
            isOperationFinished = productManager.addProduct(name, description, price, stock, category);
        }while(isOperationFinished == false);

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
