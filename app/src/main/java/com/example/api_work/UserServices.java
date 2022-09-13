package com.example.api_work;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserServices {

    @POST("login/")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @POST("insertuser/?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IjgyMzgzMjg" +
            "5MzAiLCJVc2VySWQiOjEsImlhdCI6MTY2MTg3MzY0NiwiZXhwIjoxNjY3MDU3NjQ2fQ.RuZ19vbolqHQAB3Mw_KMYpBBTSzU5NTS2wgiG7SSiSo")
    Call<RegisterResponse> registerUsers(@Body RegisterRequestModel registerRequest );

}
