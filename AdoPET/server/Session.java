package AdoPET.server;

import AdoPET.model.User;

public class Session {
    private static Session instance; //garante que existe só uma instancia da Sessão
    private User loggedUser;

    //* Permite pegar a instancia atual da Sessão
    public static Session getInstance(){
        if (instance == null) {
            instance = new Session();
        }

        return instance;
    }

    public void setLoggedUser(User loggedUser){
        this.loggedUser = loggedUser;
    }

    public User getLoggedUser(){
        return this.loggedUser;
    }
}
