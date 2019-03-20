package com.example.listaprova.models;

public class User {

   //Variabili di classe
    private int id;
    private String email, name ,username;

   //Costruttore
    public User(int id, String email, String name, String username) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.username = username;
    }

    //Metodi Getter
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
}
