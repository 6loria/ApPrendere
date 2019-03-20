package com.example.listaprova.api;

import com.example.listaprova.models.DefaultResponses;
import com.example.listaprova.models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

//API calls
public interface Api {

    //Registrazione utente
    @FormUrlEncoded
    @POST("createuser")
    Call<DefaultResponses> createUser(
    @Field("email")String email,
    @Field("password")String password,
    @Field("name")String name,
    @Field("username")String  username
    );

    //Login utente
    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginResponse> userLogin(
            @Field("email")String email,
            @Field("password")String password
            );

    //Aggiorna utente
    @FormUrlEncoded
    @PUT("updateuser/{id}")
    Call<LoginResponse> updateUser(
            @Path("id") int id,
            @Field("email")String email,
            @Field("name")String name,
            @Field("username")String username
    );

    //Aggiorna password
    @FormUrlEncoded
    @PUT("updatepassword")
    Call<DefaultResponses> updatePassword(
            @Field("currentpassword")String currentPassword,
            @Field("newpassword")String newPassword,
            @Field("email") String email
            );

    //Elimina Utente
    @DELETE("deleteuser/{id}")
    Call<DefaultResponses> deleteUser(
          @Path("id") int id

    );

}
