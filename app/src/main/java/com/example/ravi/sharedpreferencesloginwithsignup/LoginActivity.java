package com.example.ravi.sharedpreferencesloginwithsignup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ravi on 20-12-2016.
 */
public class LoginActivity  extends AppCompatActivity
{
    public static android.content.SharedPreferences SharedPreferences = null;

    private static final String PREFER_NAME = null;

    private EditText editText2,editText3;
    private Button button;
    SharedPreferences sharedPreferences;
    String emails,passwords;
    SessionMangement sessionMangement;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
            editText2= (EditText) findViewById(R.id.editText2);
            editText3= (EditText) findViewById(R.id.editText3);
             button= (Button) findViewById(R.id.login);
        sessionMangement=new SessionMangement(getApplicationContext());
        sharedPreferences=getSharedPreferences(PREFER_NAME,MODE_PRIVATE);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             String email=  editText2.getText().toString().trim() ;
             String password=  editText3.getText().toString().trim();

               if(email.length()>0 || password.length()>0){


                    if(sharedPreferences.contains("email")){
                      emails= sharedPreferences.getString("email",null);
                    }
                   if(sharedPreferences.contains("password")){
                        passwords= sharedPreferences.getString("password",null);
                   }
                       //Object emails=null;
                     //  Object passwords=null;
                   if(email.equals(emails) && password.equals(passwords)){
                       sessionMangement.createUserLoginSession(emails,passwords);

                       Toast.makeText(LoginActivity.this, "loggin succesful", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(getApplicationContext(),WelcomeActivity.class));

                   }
                   else {
                       Toast.makeText(LoginActivity.this, "login failed", Toast.LENGTH_SHORT).show();
                   }







               }

            }
        });

    }
}
