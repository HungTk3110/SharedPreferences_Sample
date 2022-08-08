package com.example.sharedpreferences_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sharedpreferences_sample.data_local.DataLocalManager;
import com.example.sharedpreferences_sample.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        User user1 = new User(1,"Trịnh Khắc Hùng" ,"Hà Nam");
        User user2 = new User(3,"Trương Trung Chinh" ,"Hà Nam");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        DataLocalManager.setListUsers(list);

        Button btnGoToMain = findViewById(R.id.btn_goToMain);
        btnGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });
    }
}