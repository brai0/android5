package com.example.fifthapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button sendBtn;
    Button btnSendEmail;
    Button btnPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendBtn=findViewById(R.id.btnSendSMS);
        btnSendEmail=findViewById(R.id.btnSendEmail);
        btnPhone=findViewById(R.id.btnDialPhone);

        sendBtn.setOnClickListener(v -> sendSMSMessage());
        btnPhone.setOnClickListener(view -> PhoneDial());
        btnSendEmail.setOnClickListener(view -> sendEmail());

    }
    protected void sendSMSMessage() {
        Intent smsintent = new Intent(Intent.ACTION_VIEW);
        smsintent.setData(Uri.parse("sms:"));
        smsintent.putExtra("sms_body", "smsMsgVar");

        try {
            startActivity(smsintent);
            Toast.makeText(MainActivity.this,
                    "SMS Sent.", Toast.LENGTH_SHORT).show();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "SMS failed, please try again later.", Toast.LENGTH_SHORT).show();
        } }
    @SuppressLint("IntentReset")
    protected void sendEmail(){
        Intent emailIntent=new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[] {"1nt19cs036.anurag@nmit.ac.in"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"subject Test");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"Message Body Test");
        startActivity(emailIntent);
    }

    protected void PhoneDial(){
        Intent intent= new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }
}