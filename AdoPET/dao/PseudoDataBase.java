package AdoPET.dao;

import java.util.HashMap;
import java.util.Collections;

import AdoPET.model.User;

public class PseudoDataBase {
    
    public static HashMap<Integer, User> users = new HashMap<Integer, User>();


    public static void addUser(User newUser) {
        users.put(newUser.getId(), newUser);
    }
    public static void deleteUserById(int id) {
        users.remove(id);
    }
    public static void editUser(User newUser) {
        users.replace(newUser.getId(), newUser);
    }

    public static User doesUserExist(String email) {
        for(User user :  users.values()) {
            if(user.getEmail().equals(email)) 
                    return user;
        }
        return null;
    }

    public static int getLastId() {
        if(users.isEmpty()) {
            return 0;
        }
        return Collections.max(users.keySet());
    } 
}
