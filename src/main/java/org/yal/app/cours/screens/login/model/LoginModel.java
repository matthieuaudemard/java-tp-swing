package org.yal.app.cours.screens.login.model;

public class LoginModel {
    private String login = "Mélanie";
    private String password;

    public LoginModel() {
    }

    public LoginModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
