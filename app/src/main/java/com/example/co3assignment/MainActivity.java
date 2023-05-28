package com.example.co3assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button camera,email,gps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera=findViewById(R.id.gps1);
        email=findViewById(R.id.email);
        gps=findViewById(R.id.gps);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  inent=new Intent(MainActivity.this, com.example.co3assignment.camera.class);
                startActivity(inent);

            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  inent=new Intent(MainActivity.this, com.example.co3assignment.email.class);
                startActivity(inent);

            }
        });
        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  inent=new Intent(MainActivity.this, com.example.co3assignment.gps.class);
                startActivity(inent);

            }
        });
    }
}