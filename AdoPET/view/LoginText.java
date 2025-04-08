package AdoPET.view;

public class LoginText extends Text {

    public void entrandoNoSistema() {
        System.out.println("1. Login");
        System.out.println("2. Registrar");
        System.out.println("3. Fechar Sistema");
    }

    public void pedirEmail() {
        System.out.println("Escreva seu email. Para voltar, digite 0.");
        System.out.println("Email: ");
    }

    public void pedirNome() {
        System.out.println("Escreva seu nome. Para voltar, digite 0.");
        System.out.println("Nome: ");
    }

    public void pedirSenha() {
        System.out.println("Escreva sua senha. Para voltar, digite 0.");
        System.out.println("Senha: ");
    }

    public void pedirPhone() {
        System.out.println("Escreva seu número de celular. Para voltar, digite 0.");
        System.out.println("Número: ");
    }

    public void senhaControle() {
        System.out.println("A senha precisa de pelo menos 8 carateres e 2 números.");
    }

    public void jaExiste() {
        System.out.println("Usuário já existe.");
    }
}

    

