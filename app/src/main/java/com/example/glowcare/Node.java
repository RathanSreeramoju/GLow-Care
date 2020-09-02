package com.example.glowcare;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Node {
    @POST("register")
    @FormUrlEncoded
    Observable<String> registerUser(@Field("email") String email,
                                    @Field("password") String password);
    @POST("login")
    @FormUrlEncoded
    Observable<String> loginUser(@Field("email") String name,
                                 @Field("password") String password);
}
