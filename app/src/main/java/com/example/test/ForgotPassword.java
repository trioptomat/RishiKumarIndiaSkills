package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    TextView tv_forEmail,tv_forPassword,tv_forOtp,btn_updatePass;
    private static final String OTP = "1234";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        tv_forEmail = findViewById(R.id.id_tv_forEmail);

        tv_forOtp = findViewById(R.id.id_tv_otp);
        btn_updatePass = findViewById(R.id.id_tv_upPass);
        tv_forPassword = findViewById(R.id.id_tv_forPass);

        btn_updatePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = tv_forEmail.getText().toString();
                String otp = tv_forOtp.getText().toString();
                String pass = tv_forPassword.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String orgEmail = sharedPreferences.getString("email","");



                if (otp.equals(OTP)){

                    if (email.equals(orgEmail)){

                        editor.putString("password",pass);
                        editor.commit();

                        Toast.makeText(ForgotPassword.this, "Password Updated", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(ForgotPassword.this,MainActivity.class));


                    }else {
                        tv_forEmail.setError("No Email");
                    }
                }
                else{
                    tv_forOtp.setError("Wrong OTP");
                }
            }
        });


    }
}