package com.example.user.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  LoginActivity extends AppCompatActivity {

    private String userid;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText Usesrid = findViewById(R.id.ed_userid);
        String userid =getSharedPreferences("atm",MODE_PRIVATE).getString("userid","");
        Usesrid.setText(userid);
    }

    public void login(View view){
        userid = ((EditText)findViewById(R.id.ed_userid)).getText().toString();
        password = ((EditText)findViewById(R.id.ed_password)).getText().toString();
        if ("june".equals(userid) && "8863".equals(password)){
          setResult(RESULT_OK);
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("userid", userid)
                    .apply();
            finish();
        }else {
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}
