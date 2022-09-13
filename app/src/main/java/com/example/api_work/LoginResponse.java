package com.example.api_work;

public class LoginResponse {

    public int status;
    public Data[] data;

    public Data[] getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }
}
