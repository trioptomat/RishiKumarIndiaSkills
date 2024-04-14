package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView tv_logEmail,tv_logPass,btn_forPass,btn_Login,btn_toRegister,tv_Hi,tv_Welcome;

    ImageView Logo;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_logEmail = findViewById(R.id.id_tv_logEmail);
        tv_logPass = findViewById(R.id.id_tv_LogPass);
        btn_forPass = findViewById(R.id.id_tv_ForgetPass);
        btn_Login = findViewById(R.id.id_tv_Login);
        btn_toRegister = findViewById(R.id.id_tv_toRegister);
        tv_Hi = findViewById(R.id.tv_Hi);
        tv_Welcome = findViewById(R.id.tv_Welcom);

        Logo = findViewById(R.id.id_img_Logo);



        Logo.animate().alpha(1.0f).setDuration(3000).start();

        tv_Hi.animate().alpha(1.0f).setDuration(3000).start();
        tv_Welcome.animate().alpha(1.0f).setDuration(4000).start();



//        new Timer().scheduleAtFixedRate(new TimerTask(){
//            @Override
//            public void run(){
//                Logo.animate().alpha(1.0f).setDuration(1000).start();
//
//            }
//
//
//        },0,1000);

//        Handler handler = new Handler(Looper.getMainLooper());
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                // Do the task...
////                handler.postDelayed(this, 1000); // Optional, to repeat the task.
//                Log.d("tag","ok");
//
//            }
//        };
//        handler.postDelayed(runnable, 3000);

// Stop a repeating task like this.
//        handler.removeCallbacks(runnable);

//






        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail,userPassword;

                userEmail = tv_logEmail.getText().toString();
                userPassword = tv_logPass.getText().toString();

                boolean isValid = false;

                for (int i=0;i<userEmail.length();i++){
                    char c = userEmail.charAt(i);

                    if (c=='@'){
                        isValid=true;
                        break;
                    }

                }

                SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);



                String email = sharedPreferences.getString("email","");
                String Password = sharedPreferences.getString("password","");

                if (email.equals(userEmail) && Password.equals(userPassword)){
                    Toast.makeText(MainActivity.this, "Logged In Succesfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,HomeScreen.class));
                }
                else if(!isValid){
                    tv_logEmail.setText("Please Enter A Valid Email");
                }
                else{

                    tv_logEmail.setError("Incorrect Details Or Do Not Exist");
                    tv_logPass.setError("Incorrect Details Or Do Not Exist");

                }



            }
        });

        btn_toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),Register.class));
            }
        });

        btn_forPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ForgotPassword.class));
            }
        });





    }
}