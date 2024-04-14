package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    TextView tv_fName,tv_lName,tv_date,tv_month,tv_year,tv_email,tv_pass,btn_Signup,btn_toLogin,tv_new;
    ImageView facebook,google,linkedin,twiter,Logo;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tv_fName = findViewById(R.id.id_tv_firstName);
        tv_lName = findViewById(R.id.id_tv_ReglastName);
        tv_date = findViewById(R.id.id_tv_date);
        tv_month = findViewById(R.id.id_tv_month);
        tv_year = findViewById(R.id.id_tv_year);
        tv_email = findViewById(R.id.id_tv_RegisterEmail);
        tv_pass = findViewById(R.id.id_tv_RegPassword);
        tv_new = findViewById(R.id.tv_new);

        btn_Signup = findViewById(R.id.id_tv_SignUp);
        btn_toLogin = findViewById(R.id.id_tv_RegisterLogin);

        facebook = findViewById(R.id.facebook2);
        google = findViewById(R.id.google2);
        linkedin = findViewById(R.id.linkedin2);
        twiter = findViewById(R.id.twiter2);
        Logo = findViewById(R.id.imageView2);


        Logo.animate().alpha(1.0f).setDuration(3000).start();


        tv_new.animate().alpha(1.0f).setDuration(3000).start();



        btn_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname,lname,email,dob,pass;
                fname = tv_fName.getText().toString();
                lname = tv_lName.getText().toString();
                email = tv_email.getText().toString();
                dob = tv_date.getText().toString()+"/"+tv_month.getText().toString()+"/"+tv_year.getText().toString();
                pass = tv_pass.getText().toString();
                boolean isValid = false;

                for (int i=0;i<email.length();i++){
                    char c = email.charAt(i);

                    if (c=='@'){
                        isValid=true;
                        break;
                    }

                }

                if (fname.equals("") ){
                    tv_fName.setError("Please Enter First Name");
                }
                else if (tv_year.getText().toString().length()<4){
                    tv_year.setError("Enter Correct Year");
                }
                else if (lname.equals("")){
                    tv_lName.setError("Please Enter Last Name");

                }
                else if(email.equals("")){
                    tv_email.setError("Please Enter Email");
                }
                else if(pass.equals("")){
                    tv_pass.setError("Please Enter Password");

                }

                else if (tv_date.getText().toString().equals("")){
                    tv_date.setError("Please Enter Date");
                }

                else if (tv_month.getText().toString().equals("")){
                    tv_month.setError("Please Enter Month");
                }

                else if (tv_year.getText().toString().equals("")){
                    tv_year.setError("Please Enter Year");
                }
                else if (pass.length()<6 || pass.length()>10 ){
                   tv_pass.setError("Password Must be More Than 6 char & less than 10 char");
                }
                else if (!isValid){
                    tv_email.setError("Please Enter A Valid Email!");
                }
                else{

                    SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("email",email);
                    editor.putString("password",pass);
                    editor.putString("fname",fname);
                    editor.putString("lname",lname);
                    editor.putString("dob",dob);

                    editor.commit();

                    Toast.makeText(Register.this, "User Added", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Register.this,HomeScreen.class));


                }


            }
        });

        btn_toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,MainActivity.class));
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/")));

            }
        });

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/")));



            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")));

            }
        });

        twiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twiter.com/")));

            }
        });
    }
}