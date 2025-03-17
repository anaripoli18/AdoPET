package AdoPET.model;

public class User {
    private int id;
    private String nameUser;
    private String email;
    private String password;
    private int phone;
    private Types types;
    
    public enum Types {
        USER,
        ONG,
        TUTOR
    }

    public User(int id, String nameUser, String email, String password, int phone, Types types) {
        this.id = id;
        this.nameUser = nameUser;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.types = types;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    public String getNameUser() {
        return nameUser;
    }

    public void setEmail(String email) {
        this.email = email;
    } 
    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    public int getPhone() {
        return phone;
    }

    public void setTypes(Types types) {
        this.types = types;
    }
    public Types getTypes() {
        return this.types;
    }
    
}
