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

    //Verificação para saber se a senha fornecida é igual a senha armazenada do usuario
    public boolean verificacaoSenha(User user, String password) {
        return user.getPassword().equals(password);
    }

    public boolean confirmarSeEmailEstaCorreto(String email) {
        return email.contains("@");
    }

    public boolean confirmarSeSenhaTemNumero(String password) {
        for(int i=0; i < password.length(); i++) {
            if(Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean confirmarSeSenhaEstaCorreta(String password) {
        return password.length() >= 8 && confirmarSeSenhaTemNumero(password);
    }

    public void completarRegistro(User user) {
        user.setId(PseudoDataBase.getLastId()+1);
        
        PseudoDataBase.addUser(user);
    }

}
