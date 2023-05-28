package com.example.co3assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class email extends AppCompatActivity {
    EditText mreceipentemail,subject,message;
    Button send,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        mreceipentemail=findViewById(R.id.editTextTextPersonName1);
        subject=findViewById(R.id.editTextTextPersonName2);
        message=findViewById(R.id.editTextTextPersonName3);
        home=findViewById(R.id.home2);
        send=findViewById(R.id.send_email);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  inent=new Intent(email.this, com.example.co3assignment.MainActivity.class);
                startActivity(inent);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String receipent=mreceipentemail.getText().toString().trim();
                String msubject=subject.getText().toString().trim();
                String mmessage=message.getText().toString().trim();
                sendemail(receipent,msubject,mmessage);
            }


        });

    }

    private void sendemail(String receipent, String msubject, String mmessage) {
        Intent mailintent=new Intent(Intent.ACTION_SEND);
        mailintent.setData(Uri.parse("mailto:"));
        mailintent.setType("text/plain");
        mailintent.putExtra(Intent.EXTRA_EMAIL,new String[]{receipent});
        mailintent.putExtra(Intent.EXTRA_SUBJECT,msubject);
        mailintent.putExtra(Intent.EXTRA_TEXT,mmessage);
        try{
            startActivity(Intent.createChooser(mailintent,"choose an Email clinet"));
        }
        catch(Exception e){
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}