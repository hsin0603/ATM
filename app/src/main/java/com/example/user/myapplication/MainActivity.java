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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends BaseActivity {
    private static final int RC_LOGIN = 100;
    boolean logon = false;
    List<String> fruit = Arrays.asList("芒果", "水梨", "草莓");

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
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FruitAdapter());

    }

    class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {
        @NonNull
        @Override
        public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new FruitViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
            holder.nameText.setText(fruit.get(position));
        }



    @Override
    public int getItemCount() {
        return fruit.size();
    }

    class FruitViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        public FruitViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(android.R.id.text1);
        }
    }

}



    private void listView() {
        List<String> fruits =  Arrays.asList("芒果","水梨","草莓");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        ListView listView1 = findViewById(R.id.list);

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
