package com.example.simeiling.dialogdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View cview = LayoutInflater.from(MainActivity.this).inflate(R.layout.cutsom_dialog, null);
                CustomDialog.Builder builder = new CustomDialog.Builder(MainActivity.this);
                builder.setGravity(Gravity.TOP);
                builder.setView(cview);
                builder.show();
            }
        });
        findViewById(R.id.center).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View cview = LayoutInflater.from(MainActivity.this).inflate(R.layout.cutsom_dialog, null);
                CustomDialog.Builder builder = new CustomDialog.Builder(MainActivity.this);
                builder.setGravity(Gravity.CENTER);
                builder.setView(cview);
                builder.show();
            }
        });
        findViewById(R.id.bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View cview = LayoutInflater.from(MainActivity.this).inflate(R.layout.cutsom_dialog, null);
                CustomDialog.Builder builder = new CustomDialog.Builder(MainActivity.this);
                builder.setGravity(Gravity.BOTTOM);
                builder.setView(cview);
                builder.show();
            }
        });
        findViewById(R.id.full).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View cview = LayoutInflater.from(MainActivity.this).inflate(R.layout.cutsom_dialog, null);
                CustomDialog.Builder builder = new CustomDialog.Builder(MainActivity.this);
                builder.setGravity(Gravity.BOTTOM);
                DisplayMetrics dm = new DisplayMetrics();
                MainActivity.this.getWindowManager().getDefaultDisplay().getMetrics(dm);
                builder.setWidth(dm.widthPixels);
                builder.setHeight(dm.heightPixels);
                builder.setView(cview);
                builder.show();
            }
        });
    }
}
