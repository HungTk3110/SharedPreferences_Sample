package com.example.sharedpreferences_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.sharedpreferences_sample.data_local.DataLocalManager;
import com.example.sharedpreferences_sample.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvUserInfor = findViewById(R.id.tv_user_infor);

        List<User> userList = DataLocalManager.getListUser();
        tvUserInfor.setText(userList.get(0).toString()+ "\n"+ userList.get(1).toString());
    }
}