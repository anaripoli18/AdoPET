package AdoPET.view;

public class Text {

    public void limparConsole() {
        System.out.print("\033[H\033[2J");
    }

    public void mensagemDeErroGenerico(String message) {
        
        if (!message.isEmpty()) {
            System.out.println(message);
        } else {
            System.out.println("Algo deu errado!");
        }
    }
    
}
