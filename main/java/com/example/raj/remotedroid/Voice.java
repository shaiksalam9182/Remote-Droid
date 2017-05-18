package com.example.raj.remotedroid;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.speech.RecognitionListener;
import android.speech.RecognitionService;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;

public class Voice extends AppCompatActivity {

    private TextView txtSpeechInput;
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    private boolean isConnected=false;
    private boolean mouseMoved=false;
    private Socket socket;
    private PrintWriter out;
    String command;

    SharedPreferences pref;
    SharedPreferences.Editor et;

    String sip,sort;

    SpeechRecognizer mspeechrecongnizer;
    int sport;

    FloatingActionButton fat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);


        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);

        fat = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        fat.setEnabled(false);

        mspeechrecongnizer = SpeechRecognizer.createSpeechRecognizer(this);

        fat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected){
                    out.println(command);
                    Toast.makeText(Voice.this,command+"to server",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Voice.this,"Unable to send"+command+" to server",Toast.LENGTH_LONG).show();
                }

            }
        });


        pref = getApplicationContext().getSharedPreferences("Mypref",0);
        et = pref.edit();

        sip = pref.getString("ip",null);
        sort = pref.getString("port",null);
        sport = Integer.parseInt(sort);

        Toast.makeText(Voice.this, "Connecting\nPlease Wait....", Toast.LENGTH_SHORT).show();

        // hide the action bar


        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });

        ConnectPhoneTask connectPhoneTask = new ConnectPhoneTask();
        connectPhoneTask.execute(sip);

    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        mspeechrecongnizer.startListening(intent);
        new CountDownTimer(2000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mspeechrecongnizer.stopListening();
            }
        }.start();


        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtSpeechInput.setText(result.get(0));
                    command = result.get(0);
                    if (command!=null){
                        fat.setEnabled(true);
                    }

                }
                break;
            }

        }
    }


    public class ConnectPhoneTask extends AsyncTask<String,Void,Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            boolean result = true;
            try {
                InetAddress serverAddr = InetAddress.getByName(params[0]);
                socket = new Socket(serverAddr, sport);//Open socket on server IP and port
            } catch (IOException e) {
                Log.e("remotedroid", "Error while connecting", e);
                result = false;
            }
            return result;
        }



        @Override
        protected void onPostExecute(Boolean result)
        {
            isConnected = result;
            Toast.makeText(Voice.this,isConnected?"Connected to server!":"Error while connecting",Toast.LENGTH_LONG).show();
            try {
                if(isConnected) {
                    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                            .getOutputStream())), true); //create output stream to send data to server
                }
            }catch (IOException e){
                Log.e("remotedroid", "Error while creating OutWriter", e);
                Toast.makeText(Voice.this,"Error while connecting",Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isConnected && out!=null) {
            try {
                out.println("ext"); //tell server to exit
                socket.close(); //close socket
            } catch (IOException e) {
                Log.e("remotedroid", "Error in closing socket", e);
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.change:
                startActivity(new Intent(Voice.this,Updation.class));
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
