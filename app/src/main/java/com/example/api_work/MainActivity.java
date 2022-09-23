package com.example.api_work;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btn_Login,btn_sign_up;
    TextInputEditText username,password;

    //jo have
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.et_uname);
        password = findViewById(R.id.pd);


        btn_Login =findViewById(R.id.btn_login);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty() ) {
                    String msg = "All input Required...";
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }else{
                    LoginRequest loginRequest = new LoginRequest();
//                    registerRequest.setEmail(email.getText().toString());
                    loginRequest.setUsername(username.getText().toString());
                    loginRequest.setPassword(password.getText().toString());
//                    registerRequest.setCpassword(cpassword.getText().toString());
                    loginUser(loginRequest);
                }

            }
        });
        btn_sign_up =findViewById(R.id.btn_sign_up);


        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void loginUser(LoginRequest loginRequest) {
        Call<LoginResponse> loginResponseCall = ApiClient.getservice().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                String msg = null;
                if(response.isSuccessful()){

                    if (response.body().getData().length!=0) {
                        msg = "Successful Login";

                        Data data = response.body().getData().clone()[0];
                        msg = "Hello " + data.getName();

                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

                        Log.d("Message", msg);
                        Intent intent = new Intent(getApplicationContext(),DashBoardActivity.class);
                        intent.putExtra("Name",msg);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        msg = "User Invalid";
                    }


                }else{
                    msg = "An error occured please try again later...";
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }

                Log.d("Message",msg);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String msg = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                Log.d("Message",msg);
            }
        });
    }

}