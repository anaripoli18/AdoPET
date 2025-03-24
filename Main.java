import AdoPET.model.User;
import AdoPET.model.User.Types;
import AdoPET.dao.PseudoDataBase;

public class Main {
    public static void main(String[] args) {
        User admin = new User(0,"admin", "admin@gmail.com", "admin", 12345678, Types.USER);
        PseudoDataBase.addUser(admin);
    }
}
