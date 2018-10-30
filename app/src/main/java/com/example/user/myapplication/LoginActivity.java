package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){
        String userid = ((EditText)findViewById(R.id.ed_userid)).getText().toString();
        String password = ((EditText)findViewById(R.id.ed_password)).getText().toString();
        if ("june".equals(userid) && "8863".equals(password)){
            setResult(RESULT_OK);
            finish();
        }else {
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}
