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

    private boolean retornarPaginaLogin(String input) {
        if(input.compareTo("0") == 0) {
            loginText.limparConsole();
            longinOuRegister();

            return true;
        }
        return false;
    }

    private void autenticarUsuarioRegister() {
        String userEmail = emailInput();
        
        if(retornarPaginaLogin(userEmail)) {
            return;
        }

        User usuarioEncontrado = userService.verificacaoEmail(userEmail);
        if(usuarioEncontrado != null) {
            loginText.jaExiste();
            autenticarUsuarioRegister();

            return;
        }
    }


    public void longinOuRegister() {
        loginText.entrandoNoSistema();
        switch (escolhaDeUsuario) {
            case 1:
                autenticarEmailLogin();
                break;
            case 2:
                autenticarUsuarioRegister();
                break;
            case 3:
                return;
            default:
                longinOuRegister();
                break;
        };
    }
    @Override
    public void abrirView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'abrirView'");
    }
}
