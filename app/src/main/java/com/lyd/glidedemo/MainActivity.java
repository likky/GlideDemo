package com.lyd.glidedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btV3;
    private Button btV4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btV3 = findViewById(R.id.bt_v3);
        btV4 = findViewById(R.id.bt_v4);
        btV3.setOnClickListener(this);
        btV4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_v3:
                startActivity(new Intent(MainActivity.this, GlideV3UseActivity.class));
                break;
            case R.id.bt_v4:
                startActivity(new Intent(MainActivity.this, GlideV4UseActivity.class));
                break;
        }
    }
}
