package com.example.api_work;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.api_work.databinding.ActivityRegisterBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding registerBinding;
    Calendar calendar;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        calendar = Calendar.getInstance();
        registerBinding = DataBindingUtil.setContentView(this,R.layout.activity_register);

        registerBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (registerBinding.username.getText().toString().isEmpty() || registerBinding.mobileNo.getText().toString().isEmpty()
                        || registerBinding.email.getText().toString().isEmpty()  || registerBinding.password.getText().toString().isEmpty()
                        || registerBinding.cPassword.getText().toString().isEmpty() ||
                registerBinding.address.getText().toString().isEmpty() || registerBinding.companyName.getText().toString().isEmpty() ||
                registerBinding.whatsappNo.getText().toString().isEmpty() || registerBinding.country.getText().toString().isEmpty()) {

                    String msg = "All input Required...";
                    Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
                }else{

                    if(registerBinding.password.getText().toString().trim().equals(registerBinding.cPassword.getText().toString().trim())) {
                        date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                        RegisterRequestModel registerRequest = new RegisterRequestModel(
                                registerBinding.username.getText().toString(),
                                registerBinding.mobileNo.getText().toString(),
                                registerBinding.email.getText().toString(),
                                registerBinding.password.getText().toString(),
                                registerBinding.address.getText().toString(),
                                "User",
                                registerBinding.companyName.getText().toString(),
                                registerBinding.whatsappNo.getText().toString(),
                                registerBinding.country.getText().toString(),
                                "true",
                                date
                        );

                        Log.d("Date", date);
//                    registerRequest.setEmail(email.getText().toString());
//                    registerRequest.setCpassword(cpassword.getText().toString());
                        registerUser(registerRequest);
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "Please conform your password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
    public void registerUser(RegisterRequestModel registerRequest){

        Call<RegisterResponse> registerresponscall = ApiClient.getservice().registerUsers(registerRequest);
        registerresponscall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(@NonNull Call<RegisterResponse> call, @NonNull Response<RegisterResponse> response) {
                String msg;
                if(!response.isSuccessful()){

                    msg = "An error occured please try again later...";
                    Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();

                }else {
                    msg = "Successful...";
                    Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    //finish();
                    msg = response.body().toString();
                }
                Log.d("Message",msg);

            }

            @Override
            public void onFailure(@NonNull Call<RegisterResponse> call, @NonNull Throwable t) {
                String msg = t.getLocalizedMessage();
                Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
                Log.d("Message",msg);
            }
        });
    }
}