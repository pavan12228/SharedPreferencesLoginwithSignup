package com.example.ravi.sharedpreferencesloginwithsignup;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ravi on 20-12-2016.
 */
public class WelcomeActivity  extends AppCompatActivity implements View.OnClickListener

{
    TextView email, password;
    SharedPreferences sharedPreferences;
    String email1, pass;
    Button logout;
    private static final String PREFER_NAME = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        email = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.password);
        logout = (Button) findViewById(R.id.logout);
        sharedPreferences = getSharedPreferences(PREFER_NAME, MODE_PRIVATE);
        email1 = sharedPreferences.getString("email", null);
        pass = sharedPreferences.getString("password", null);
        email.setText(email1);
        password.setText(pass);
        logout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
      final AlertDialog.Builder adb = new AlertDialog.Builder(getApplicationContext());
        switch (v.getId()) {
            case R.id.logout:

            adb.setIcon(R.mipmap.ic_launcher);
            adb.setTitle("My Alert Box");
            adb.setMessage("Do you want to Continue or Not");
            adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            });

           adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
               }
           }) ;
            adb.show();


            break;

          }










    }
}
