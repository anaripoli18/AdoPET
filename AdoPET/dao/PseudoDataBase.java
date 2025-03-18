package AdoPET.dao;

import java.util.HashMap;

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
        for(int i=0; i<= users.size(); i++) {
            if(users.get(i) != null) 
                if(users.get(i).getEmail().compareTo(email) == 0)
                    return users.get(i);
        }
        return null;
    }
 }
