package com.example.co3assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class gps extends AppCompatActivity {
    EditText source,destination;
    Button track,home;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        source=findViewById(R.id.editTextTextPersonName);
        destination=findViewById(R.id.editTextTextPersonName1);
        home=findViewById(R.id.button);
        track=findViewById(R.id.gps1);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  inent=new Intent(gps.this, com.example.co3assignment.MainActivity.class);
                startActivity(inent);
            }
        });


        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String esource=source.getText().toString().trim();
                String edestination=destination.getText().toString().trim();
                if(esource.equals("")&&edestination.equals("")){
                    Toast.makeText(gps.this, "Enter both loctaion", Toast.LENGTH_SHORT).show();
                }
                else{
                    DisplayTrack(esource,edestination);
                }
            }


        });
    }

    private void DisplayTrack(String esource, String edestination) {
        try{
            Uri uri=Uri.parse("https://www.google.co.in/maps/dir/"+esource +"/"+ edestination);
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }catch(ActivityNotFoundException e){
            Uri uri=Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }
}