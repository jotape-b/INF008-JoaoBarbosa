package users;
public class Customer extends User {
    private String address;
    //endereço de entrega
    //histórico/lista de compras

    public Customer(UserType userType, String name, String email, String password) throws Exception{
        super(userType, name, email, password);
    }

    //start new order
        //add product
        //view shopping cart
            //listar todos os produtos inclusos no carrinho de compras
        //finish order
    //exit
}
