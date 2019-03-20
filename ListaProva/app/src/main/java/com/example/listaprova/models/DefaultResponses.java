package com.example.listaprova.models;

import com.google.gson.annotations.SerializedName;

public class DefaultResponses {

    @SerializedName("error")
    private boolean err;

    @SerializedName("message")
    private String msg;

     //Costruttore
    public DefaultResponses(boolean err, String msg) {
        this.err = err;
        this.msg = msg;
    }

    //Metodi getter
    public boolean isErr() {
        return err;
    }

    public String getMsg() {
        return msg;
    }
}
