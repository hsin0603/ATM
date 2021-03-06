package com.example.user.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    private Context context;
    String id;
    String nickname;
    int age ;
    int gender;
    String address;
    SharedPreferences settings;
    boolean valid = false;

    public User (Context context){
        this.context = context;
        settings = context.getSharedPreferences("user",context.MODE_PRIVATE);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        if (nickname == null) {
            nickname = settings.getString("NICKNAME", null);
        }
        return nickname;
    }

    public void setNickname(String username) {
        settings.edit()
                .putString("NICKNAME", username).apply();
        this.nickname = username;
    }

    public int getAge() {
        if (age == 0) {
            age = settings.getInt("AGE", 0);
        }
        return age;
    }

    public void setAge(int age) {
        settings.edit()
                .putInt("AGE", age).apply();
        this.age = age;
    }

    public int getGender() {
        if (gender == 0) {
            gender = settings.getInt("GENDER", 0);
        }
        return gender;
    }

    public void setGender(int gender) {
        settings.edit()
                .putInt("GENDER", gender).apply();
        this.gender = gender;
    }

    public String getAddress() {
        address = "dummy address";
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




    public boolean isValid() {
        valid = getNickname() != null && getAge() != 0 && getGender() !=0;
        return valid;
    }


}
