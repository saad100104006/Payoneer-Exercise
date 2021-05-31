package com.example.paymentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.paymentlist.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
}