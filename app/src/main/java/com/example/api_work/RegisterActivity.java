package com.example.api_work;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText username,email,password,cpassword;
    Button rsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);

        rsubmit = findViewById(R.id.rsubmit);
        rsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().isEmpty() || email.getText().toString().isEmpty()  || password.getText().toString().isEmpty() || cpassword.getText().toString().isEmpty() ) {
                    String msg = "All input Required...";
                    Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
                }else{
                    RegisterRequestModel registerRequest = new RegisterRequestModel();
//                    registerRequest.setEmail(email.getText().toString());
                    registerRequest.setUsername(username.getText().toString());
                    registerRequest.setPassword(password.getText().toString());
//                    registerRequest.setCpassword(cpassword.getText().toString());
                    registeruser(registerRequest);
                }

            }
        });

    }
    public void registeruser(RegisterRequestModel registerRequest){

//        Call<RegisterRequestModel> registerresponscall = ApiClient.getservice().registerUsers(registerRequest);
//        registerresponscall.enqueue(new Callback<RegisterRequestModel>() {
//            @Override
//            public void onResponse(@NonNull Call<RegisterRequestModel> call, @NonNull Response<RegisterRequestModel> response) {
//                if(!response.isSuccessful()){
//
//                    String msg = "An error occured please try again later...";
//                    Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                    String msg = "Successful...";
//                    Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(RegisterActivity.this,MainActivity.class));
//                    finish();
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<RegisterRequestModel> call, @NonNull Throwable t) {
//                String msg = t.getLocalizedMessage();
//                Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}