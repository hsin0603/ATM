package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NickNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nick_name);
    }
    public void next (View view){
        EditText ednickname = findViewById(R.id.ed_nickname);
        String nicknmae = ednickname.getText().toString();
        getSharedPreferences("user",MODE_PRIVATE)
                .edit()
                .putString("NICKNAME",nicknmae)
                .apply();
        Intent age = new Intent(this,AgeActivity.class);
        startActivity(age);
    }
    public void back (View view){
        Intent login =new Intent(this,LoginActivity.class);
        startActivity(login);
    }
}
