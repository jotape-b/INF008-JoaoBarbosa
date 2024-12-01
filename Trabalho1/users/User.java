package users;

public class User {
    private static int idCounter = 0;
    private int id;
    private UserType userType;
    private String name;
    private String email;
    private String salt;
    private String password;

    public User(UserType userType, String name, String email, String password) throws Exception{
        this.id = idCounter++;
        this.userType = userType;
        this.name = name;
        this.email = email;
        String[] hashAndSalt = PasswordHasher.createHashWithSalt(password);
        this.salt = hashAndSalt[0];
        this.password = hashAndSalt[1];
    }

    public UserType getUserType(){
        return userType;
    }

    protected String getEmail(){
        return email;
    }

    protected String getPassword(){
        return password;
    }

    protected String getSalt(){
        return salt;
    }

}
