package com.example.raj.remotedroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Updation extends AppCompatActivity {

    EditText etip,etport;
    Button btadd;
    String ip,port;
    TextView tv;

    SharedPreferences pref;
    SharedPreferences.Editor et;

    String sip,sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updation);

        pref = getApplicationContext().getSharedPreferences("Mypref",0);
        et = pref.edit();

        etip = (EditText)findViewById(R.id.etip);
        etport  =(EditText)findViewById(R.id.etport);

        btadd = (Button)findViewById(R.id.btadd);

        tv = (TextView)findViewById(R.id.tv);

        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip = etip.getText().toString();
                port = etport.getText().toString();
                tv.setText(ip+"\n"+port);

                et.putString("ip",ip);
                et.putString("port",port);
                et.commit();

                sip = pref.getString("ip",null);
                sport = pref.getString("port",null);

                if (sip.isEmpty() && sport.isEmpty()){
                    Toast.makeText(Updation.this,"PLEASE FILL ALL FIELDS",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Updation.this," SUCCESSFULLY UPDATED",Toast.LENGTH_LONG).show();
                    Intent a= new Intent(Updation.this,MainActivity.class);
                    startActivity(a);
                    finish();
                }
            }
        });

        sip = pref.getString("ip",null);
        sport = pref.getString("port",null);


    }
    }

