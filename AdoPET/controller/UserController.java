package AdoPET.controller;

import java.util.Scanner;

import AdoPET.dao.PseudoDataBase;
import AdoPET.model.User;
import AdoPET.service.UserService;

public class UserController implements Controller {
    
    LoginText loginText;
    Profile profileScreen;
    UserService userService;
    Scanner scanner;
    int escolhaDeUsuario;
}
