package com.example.listaprova.models;

public class LoginResponse {

    //Variabili di classe
    private boolean error;
    private String message;
    private User user;

    //Costruttore
    public LoginResponse(boolean error, String message, User user) {
        this.error = error;
        this.message = message;
        this.user = user;
    }

    //Metodi Getter

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
