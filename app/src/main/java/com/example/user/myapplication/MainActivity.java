package com.example.user.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends BaseActivity {
    private static final int RC_LOGIN = 100;
    boolean logon = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView nickText = findViewById(R.id.nickname);
        nickText.setText(user.getNickname());
        if (!logon) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, RC_LOGIN);
        }
//       ListView
//        listView();
//        RecyclerView
//        RecyclerView recyclerView = findViewById(R.id.recycler);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter();
//
//
//    }
//    class FruitAdapter {
//        class FruitViewHolder extends RecyclerView.ViewHolder{
//            TextView nameText;
//            public FruitViewHolder(View view){
//                super(itemView);
//                nameText = itemView.findViewById(android.R.id.text1);
//            }
//        }
}



    private void ListView() {
        List<String> fruits =  Arrays.asList("香蕉","鳳梨","芭樂");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_LOGIN){
            if (resultCode != RESULT_OK){
                finish();
            }else{
           logon = true;
//                String nickname = getSharedPreferences("user",MODE_PRIVATE)
//                        .getString("NICKMNAME",null);
//                int age = getSharedPreferences("user",MODE_PRIVATE)
//                        .getInt("AGE",0);
//                int gender = getSharedPreferences("user",MODE_PRIVATE)
//                        .getInt("GENDER",0);

                if(!user.isValid()) {
//                TODO:check nickname.age.gender exist
                    Intent nick = new Intent(this, NickNameActivity.class);
                    startActivity(nick);
                }
            }
        }
    }
}
