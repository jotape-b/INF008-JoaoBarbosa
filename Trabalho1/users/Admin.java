package users;
import java.util.HashMap;
import java.util.HashSet;
public class Admin extends User{
    HashMap<Integer, User> users = new HashMap<Integer, User>();
    HashSet<String> registeredEmails = new HashSet<String>();

    public Admin(UserType userType, String name, String email, String password) throws Exception{
        super(userType, name, email, password);
    }

    public boolean addUser(UserType userType, String name, String email, String password) throws Exception{
        if(registeredEmails.contains(email)){
            System.out.println("Invalid register. E-mail already in use.");
            return false;
        }
        User newUser = (userType == UserType.ADMIN) ? new Admin(userType, name, email, password) : new Customer(userType, name, email, password);
        users.put(newUser.getId(), newUser);
        registeredEmails.add(email);
        System.out.println("User successfully registered.");
        return true;
    }

    //gerenciar produtos
    //acessar relatórios

    //create new product
    //create new user
        //Solicitar tipo do perfil do novo usuário, seu login e sua senha
    //report - more expensive order
    //report - product with lowerst inventory
    //exit
}
