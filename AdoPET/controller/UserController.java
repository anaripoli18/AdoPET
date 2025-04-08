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

    @Override
    public void abrirView() {
        loginOuRegister();
    }


    //Método principal que apresenta um menu para o usuário contendo "login, registro ou sair"
    public void loginOuRegister() {
        loginText.entrandoNoSistema();
        setarEscolhaNumerica();
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
                loginOuRegister();
                break;
        };
    }

    
    //Esses dois métodos pedem as informações (email e senha) do usuário
    protected String emailInput() {
        loginText.pedirEmail();
        return scanner.nextLine();
    }

    protected String nameInput() {
        loginText.pedirNome();
        return scanner.nextLine();
    }

    protected String senhaInput() {
        loginText.pedirSenha();
        return scanner.nextLine();
    }

    protected String phoneInput() {
        loginText.pedirPhone();
        return scanner.nextLine();
    }


    //Método que verifica se o usuário existe
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


    //Método que verificar se a senha está correta e se tiver, cria uma sessão para o usuário
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


    //Método que faz o registro do usuário a partir do email, verificando se ele está seguindo as normas
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


    //Método que faz o registro da senha do usuário, verificando se está seguindo as normas
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
        loginOuRegister();
    } 
 

    //Método que retorna a página principal caso o usuário digite 0
    private boolean retornarPaginaLogin(String input) {
        if(input.compareTo("0") == 0) {
            loginText.limparConsole();
            loginOuRegister();

            return true;
        }
        return false;
    }


    //Método que permite o usuário escolher uma opção no menu
    protected void setarEscolhaNumerica() {
        try {
            this.escolhaDeUsuario = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            loginText.mensagemDeErroGenerico("Escolha uma opção valida");
        }
    }
}
