package AdoPET.controller;

import java.util.Scanner;

import AdoPET.model.User;
import AdoPET.server.Session;
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

    public void longinOuRegister() {
        loginText.entrandoNoSistema();
        switch (escolhaDeUsuario) {
            case 1:
                autenticarEmailLogin();
                break;
            case 2:
                autenticarEmailRegister();
                break;
            case 3:
                return;
            default:
                longinOuRegister();
                break;
        };
    }

    protected String emailInput() {
        loginText.pedirEmail();
        return scanner.nextLine();
    }

    protected String senhaInput() {
        loginText.pedirSenha();
        return scanner.nextLine();
    }

    private void autenticarEmailLogin() {
        String userEmail = emailInput();

        if(retornarPaginaLogin(userEmail))
            return;

        User usuarioEncontrado = userService.verificacaoEmail(userEmail);
        if(usuarioEncontrado == null) {
            loginText.mensagemDeErroGenerico("Email correto ou usuário inexistente");
            autenticarEmailLogin();

            return;
        }
        autenticarSenhaLogin(usuarioEncontrado);
    }

    private void autenticarSenhaLogin(User usuarioEncontrado) {
        String senhaDoUsuario = senhaInput();

        if(retornarPaginaLogin(senhaDoUsuario)){
            return;
        } 
    
        if(userService.verificacaoSenha(usuarioEncontrado, senhaDoUsuario)) {
            Session.getInstance().setLoggedUser(usuarioEncontrado);
            loginText.limparConsole();
        }
        else{
            loginText.mensagemDeErroGenerico("Senha incorreta!");
            autenticarSenhaLogin(usuarioEncontrado);
        }
    }

    private void autenticarEmailRegister() {
        String userEmail = emailInput();
        
        if(retornarPaginaLogin(userEmail)) {
            return;
        }

        User usuarioEncontrado = userService.verificacaoEmail(userEmail);
        if(usuarioEncontrado != null) {
            loginText.jaExiste();
            autenticarEmailRegister();

            return;
        }

        boolean IsEmailCorrect = userService.confirmarSeEmailEstaCorreto(userEmail);
        if(!IsEmailCorrect) {
            loginText.mensagemDeErroGenerico("O email deve conter @!");
            autenticarEmailRegister();

            return;
        } 
        User user = new User(0, "", userEmail, "", 0, null);
        autenticarSenhaRegister(user);
    }

    private void autenticarSenhaRegister(User user) {
        loginText.senhaControle();
        String password = senhaInput();

        boolean IsPasswordCorrect = userService.confirmarSeSenhaEstaCorreta(password);
        if(!IsPasswordCorrect) {
            loginText.mensagemDeErroGenerico("Senha inválida!");
            autenticarSenhaRegister(user);

            return;
        }

        user.setPassword(password);

        userService.completarRegistro(user);
        longinOuRegister();
    } 

    private boolean retornarPaginaLogin(String input) {
        if(input.compareTo("0") == 0) {
            loginText.limparConsole();
            longinOuRegister();

            return true;
        }
        return false;
    }

    @Override
    public void abrirView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'abrirView'");
    }
}
