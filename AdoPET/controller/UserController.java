package AdoPET.controller;

import java.util.Scanner;

import AdoPET.dao.PseudoDataBase;
import AdoPET.model.User;
import AdoPET.service.UserService;
import AdoPET.view.LoginText;
import AdoPET.view.Profile;

public class UserController implements Controller {
    
    LoginText loginText;
    Profile profileScreen;
    UserService userService;
    Scanner scanner;
    int escolhaDeUsuario;

    public UserController() {
        loginText = new LoginText();
        profileScreen = new Profile();
        userService = new UserService();
        scanner = new Scanner(System.in);
    }

    @Override
    public void abrirView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'abrirView'");
    }
}
