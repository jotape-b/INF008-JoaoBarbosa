package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import shopping.Product;
import shopping.ProductManager;
import users.User;
import users.UserManager;

public class DataManager {

    public void saveData(UserManager userManager, ProductManager productManager) throws IOException{
        FileOutputStream fos = new FileOutputStream("newfile.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(userManager.getUsers());
        oos.writeObject(productManager.getProducts());
        oos.flush();
        oos.close();
    }

    public void loadData(UserManager userManager, ProductManager productManager){
        try(FileInputStream fis = new FileInputStream("newfile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis)){
            userManager.setUsers((HashMap<String, User>) ois.readObject());
            productManager.setProducts((HashMap<Integer, Product>) ois.readObject());
            System.out.println("Data loaded successfully.");
        } catch (Exception e){
            System.out.println("No data found.");
        }
    }    
}
