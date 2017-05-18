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

public class Launch extends AppCompatActivity {

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
        setContentView(R.layout.activity_launch);

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

                if (ip.isEmpty() && port.isEmpty()) {
                    Toast.makeText(Launch.this, "Please Fill All Fields", Toast.LENGTH_LONG).show();
                } else {

                    et.putString("ip", ip);
                    et.putString("port", port);
                    et.commit();

                    sip = pref.getString("ip", null);
                    sport = pref.getString("port", null);

                    if (sip.isEmpty() && sport.isEmpty()) {
                        Toast.makeText(Launch.this, "Unable to store", Toast.LENGTH_LONG).show();
                        tv.setText("Unable to Store");
                    } else {
                        //Toast.makeText(Launch.this, " Successfully stored", Toast.LENGTH_LONG).show();
                        tv.setText("Successfully Stored");
                        Intent a = new Intent(Launch.this, DashBoard.class);
                        startActivity(a);
                        finish();
                    }
                }
            }
        });

        sip = pref.getString("ip",null);
        sport = pref.getString("port",null);

        if (sip!=null && sport!=null){
            Intent a= new Intent(Launch.this,DashBoard.class);
            startActivity(a);
            finish();
        }
    }
}
