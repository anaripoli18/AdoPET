package AdoPET.service;

import AdoPET.dao.PseudoDataBase;
import AdoPET.model.User;

public class UserService {

    //Verificação para saber se o email está de acordo com a regra (conter "@")
    public User verificacaoEmail(String email) {
        User doesUserExist = PseudoDataBase.doesUserExist(email);
        if(doesUserExist == null && email.contains("@") == false) {
            return null;
        }
        return doesUserExist;
    }

    public boolean verificacaoSenha(User userAlvo, String password) {
        return userAlvo.getPassword().equals(password);
    }
}
