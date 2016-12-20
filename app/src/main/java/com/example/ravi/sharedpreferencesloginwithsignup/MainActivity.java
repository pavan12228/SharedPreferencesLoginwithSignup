package com.example.ravi.sharedpreferencesloginwithsignup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


   private EditText ed1,ed2,ed3;
    private Button b1;
     SharedPreferences sharedPreferences;
     SharedPreferences.Editor editor;
    private static final String PREFER_NAME = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        b1=(Button)findViewById(R.id.button);
       sharedPreferences=getSharedPreferences(PREFER_NAME,MODE_PRIVATE);
        editor=sharedPreferences.edit();
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String name  = ed1.getText().toString().trim();
                 String password  = ed2.getText().toString().trim();
                 String email  = ed3.getText().toString().trim();

                   editor.putString("name",name);
                   editor.putString("password",password);
                   editor.putString("email",email);
                    editor.commit();

                 startActivity(new Intent(getApplicationContext(),LoginActivity.class));






             }
         });

    }
}
