package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    TextView tv_mainName,tv_mainEmail,tv_Logout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        tv_mainName = findViewById(R.id.id_tv_mainName);
        tv_mainEmail=findViewById(R.id.id_tv_mainEmail);

        tv_Logout = findViewById(R.id.id_tv_logout);

        SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        tv_mainName.setText((sharedPreferences.getString("fname","")+" "+sharedPreferences.getString("lname","")));
        tv_mainEmail.setText(sharedPreferences.getString("email",""));

        tv_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeScreen.this, "Logged out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeScreen.this,MainActivity.class));
            }
        });
    }
}