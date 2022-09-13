package com.example.api_work;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserServices {

    @POST("login/")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @POST("users/")
    Call<RegisterResponse> registerUsers(@Body RegisterRequestModel registerRequest );

}
