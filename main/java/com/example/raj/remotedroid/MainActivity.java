package com.example.raj.remotedroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.WindowDecorActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.zip.Inflater;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Context context;
    Button playPauseButton;
    Button nextButton;
    Button previousButton;
    TextView mousePad;

    private boolean isConnected=false;
    private boolean mouseMoved=false;
    private Socket socket;
    private PrintWriter out;

    private float initX =0;
    private float initY =0;
    private float disX =0;
    private float disY =0;

    SharedPreferences pref;
    SharedPreferences.Editor et;

    String sip,sort;
    int sport;


    SlidingDrawer sd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this; //save the context to show Toast messages

        //Get references of all buttons
        playPauseButton = (Button)findViewById(R.id.playPauseButton);
        nextButton = (Button)findViewById(R.id.nextButton);
        previousButton = (Button)findViewById(R.id.previousButton);

        sd = (SlidingDrawer)findViewById(R.id.sliding);







        pref = getApplicationContext().getSharedPreferences("Mypref",0);
        et = pref.edit();

        sip = pref.getString("ip",null);
        sort = pref.getString("port",null);
        sport = Integer.parseInt(sort);

        Toast.makeText(MainActivity.this, "Connecting\nPlease Wait....", Toast.LENGTH_SHORT).show();





        //this activity extends View.OnClickListener, set this as onClickListener
        //for all buttons
        playPauseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);

        //Get reference to the TextView acting as mousepad
        mousePad = (TextView)findViewById(R.id.mousePad);

        //capture finger taps and movement on the textview
        mousePad.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(isConnected && out!=null){
                    switch(event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            //save X and Y positions when user touches the TextView
                            initX =event.getX();
                            initY =event.getY();
                            mouseMoved=false;
                            break;
                        case MotionEvent.ACTION_MOVE:
                            disX = event.getX()- initX; //Mouse movement in x direction
                            disY = event.getY()- initY; //Mouse movement in y direction
                            /*set init to new position so that continuous mouse movement
                            is captured*/
                            initX = event.getX();
                            initY = event.getY();
                            if(disX !=0|| disY !=0){
                                out.println(disX +","+ disY); //send mouse movement to server
                            }
                            mouseMoved=true;
                            break;
                        case MotionEvent.ACTION_UP:
                            //consider a tap only if usr did not move mouse after ACTION_DOWN
                            if(!mouseMoved){
                                out.println(Constants.MOUSE_LEFT_CLICK);
                            }
                    }
                }
                return true;
            }
        });

        mousePad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.MOUSE_LEFT_CLICK);
            }
        });
        ConnectPhoneTask connectPhoneTask = new ConnectPhoneTask();
        connectPhoneTask.execute(sip);
    }



    public void aa(View v){
        if (isConnected && out!=null) {
            out.println("a"); //send "next" to server
            Toast.makeText(this,"a to pc", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send a to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void bb(View v){
        if (isConnected && out!=null) {
            out.println("b"); //send "next" to server
            Toast.makeText(this,"b to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send b to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void cc(View v){
        if (isConnected && out!=null) {
            out.println("c"); //send "next" to server
            Toast.makeText(this,"c to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send c to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void dd(View v){
        if (isConnected && out!=null) {
            out.println("d"); //send "next" to server
            Toast.makeText(this,"d to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send d to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void ee(View v){
        if (isConnected && out!=null) {
            out.println("e"); //send "next" to server
            Toast.makeText(this,"e to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send e to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void ff(View v){
        if (isConnected && out!=null) {
            out.println("f"); //send "next" to server
            Toast.makeText(this,"f to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void gg(View v){
        if (isConnected && out!=null) {
            out.println("g"); //send "next" to server
            Toast.makeText(this,"g to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send g to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void hh(View v){
        if (isConnected && out!=null) {
            out.println("h"); //send "next" to server
            Toast.makeText(this,"h to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send h to server", Toast.LENGTH_SHORT).show();
        }

    } public void ii(View v){
        if (isConnected && out!=null) {
            out.println("i"); //send "next" to server
            Toast.makeText(this,"i to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send i to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void jj(View v){
        if (isConnected && out!=null) {
            out.println("j"); //send "next" to server
            Toast.makeText(this,"j to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send j to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void kk(View v){
        if (isConnected && out!=null) {
            out.println("k"); //send "next" to server
            Toast.makeText(this,"k to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send k to server", Toast.LENGTH_SHORT).show();
        }

    } public void ll(View v){
        if (isConnected && out!=null) {
            out.println("l"); //send "next" to server
            Toast.makeText(this,"l to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send l to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void mm(View v){
        if (isConnected && out!=null) {
            out.println("m"); //send "next" to server
            Toast.makeText(this,"m to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send m to server", Toast.LENGTH_SHORT).show();
        }

    } public void nn(View v){
        if (isConnected && out!=null) {
            out.println("n"); //send "next" to server
            Toast.makeText(this,"n to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send n to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void oo(View v){
        if (isConnected && out!=null) {
            out.println("o"); //send "next" to server
            Toast.makeText(this,"o to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send o to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void pp(View v){
        if (isConnected && out!=null) {
            out.println("p"); //send "next" to server
            Toast.makeText(this,"p to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send p to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void qq(View v){
        if (isConnected && out!=null) {
            out.println("p"); //send "next" to server
            Toast.makeText(this,"p to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send p to server", Toast.LENGTH_SHORT).show();
        }

    } public void rr(View v){
        if (isConnected && out!=null) {
            out.println("r"); //send "next" to server
            Toast.makeText(this,"r to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send r to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void ss(View v){
        if (isConnected && out!=null) {
            out.println("s"); //send "next" to server
            Toast.makeText(this,"s to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send s to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void tt(View v){
        if (isConnected && out!=null) {
            out.println("t"); //send "next" to server
            Toast.makeText(this,"t to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send t to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void uu(View v){
        if (isConnected && out!=null) {
            out.println("u"); //send "next" to server
            Toast.makeText(this,"u to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send u to server", Toast.LENGTH_SHORT).show();
        }

    } public void vv(View v){
        if (isConnected && out!=null) {
            out.println("v"); //send "next" to server
            Toast.makeText(this,"v to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send v to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void ww(View v){
        if (isConnected && out!=null) {
            out.println("w"); //send "next" to server
            Toast.makeText(this,"w to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send w to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void xx(View v){
        if (isConnected && out!=null) {
            out.println("x"); //send "next" to server
            Toast.makeText(this,"x to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send x to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void yy(View v){
        if (isConnected && out!=null) {
            out.println("y"); //send "next" to server
            Toast.makeText(this,"y to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send y to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void zz(View v){
        if (isConnected && out!=null) {
            out.println("z"); //send "next" to server
            Toast.makeText(this,"z to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send z to server", Toast.LENGTH_SHORT).show();
        }

    }







    public void f1(View v){
        if (isConnected && out!=null) {
            out.println("f1"); //send "next" to server
            Toast.makeText(this,"f1 to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f1 to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void f2(View v){
        if (isConnected && out!=null) {
            out.println("f2"); //send "next" to server
            Toast.makeText(this,"f2 to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f2 to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void f3(View v){
        if (isConnected && out!=null) {
            out.println("f3"); //send "next" to server
            Toast.makeText(this,"f3 to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f3 to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void f4(View v){
        if (isConnected && out!=null) {
            out.println("f4"); //send "next" to server
            Toast.makeText(this,"f4 to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f4 to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void f5(View v){
        if (isConnected && out!=null) {
            out.println("f5"); //send "next" to server
            Toast.makeText(this,"f5 to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f5 to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void f6(View v){
        if (isConnected && out!=null) {
            out.println("f6"); //send "next" to server
            Toast.makeText(this,"f6 to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f6 to server", Toast.LENGTH_SHORT).show();
        }

    } public void f7(View v){
        if (isConnected && out!=null) {
            out.println("f7"); //send "next" to server
            Toast.makeText(this,"f7 to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f7 to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void f8(View v){
        if (isConnected && out!=null) {
            out.println("f8"); //send "next" to server
            Toast.makeText(this,"f8 to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f8 to server", Toast.LENGTH_SHORT).show();
        }

    } public void f9(View v){
        if (isConnected && out!=null) {
            out.println("f9"); //send "next" to server
            Toast.makeText(this,"f9 to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f9 to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void f10(View v){
        if (isConnected && out!=null) {
            out.println("f10"); //send "next" to server
            Toast.makeText(this,"f10 to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f10 to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void f11(View v){
        if (isConnected && out!=null) {
            out.println("f11"); //send "next" to server
            Toast.makeText(this,"f11 to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f11 to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void f12(View v){
        if (isConnected && out!=null) {
            out.println("f12"); //send "next" to server
            Toast.makeText(this,"f12 to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send f12 to server", Toast.LENGTH_SHORT).show();
        }

    }






    public void space(View v){
        if (isConnected && out!=null) {
            out.println("space"); //send "next" to server
            Toast.makeText(this,"space to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send space to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void enter(View v){
        if (isConnected && out!=null) {
            out.println("enter"); //send "next" to server
            Toast.makeText(this,"enter to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send enter to server", Toast.LENGTH_SHORT).show();
        }

    } public void windows(View v){
        if (isConnected && out!=null) {
            out.println("windows"); //send "next" to server
            Toast.makeText(this,"windows to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send windows to server", Toast.LENGTH_SHORT).show();
        }

    }







    public void one(View v){
        if (isConnected && out!=null) {
            out.println("one"); //send "next" to server
            Toast.makeText(this,"one to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send one to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void two(View v){
        if (isConnected && out!=null) {
            out.println("two"); //send "next" to server
            Toast.makeText(this,"two to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send two to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void three(View v){
        if (isConnected && out!=null) {
            out.println("three"); //send "next" to server
            Toast.makeText(this,"three to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send three to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void four(View v){
        if (isConnected && out!=null) {
            out.println("four"); //send "next" to server
            Toast.makeText(this,"four to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send four to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void five(View v){
        if (isConnected && out!=null) {
            out.println("five"); //send "next" to server
            Toast.makeText(this,"five to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send five to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void six(View v){
        if (isConnected && out!=null) {
            out.println("six"); //send "next" to server
            Toast.makeText(this,"six to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send six to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void seven(View v){
        if (isConnected && out!=null) {
            out.println("seven"); //send "next" to server
            Toast.makeText(this,"seven to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send seven to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void eight(View v){
        if (isConnected && out!=null) {
            out.println("eight"); //send "next" to server
            Toast.makeText(this,"eight to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send eight to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void nine(View v){
        if (isConnected && out!=null) {
            out.println("nine"); //send "next" to server
            Toast.makeText(this,"nine to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send nine to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void backspace(View v){
        if (isConnected && out!=null) {
            out.println("backspace"); //send "next" to server
            Toast.makeText(this,"backspace to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send backspace to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void zero(View v){
        if (isConnected && out!=null) {
            out.println("zero"); //send "next" to server
            Toast.makeText(this,"zero to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send zero to server", Toast.LENGTH_SHORT).show();
        }

    }





    public void up(View v){
        if (isConnected && out!=null) {
            out.println("up"); //send "next" to server
            Toast.makeText(this,"up to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send up to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void left(View v){
        if (isConnected && out!=null) {
            out.println("left"); //send "next" to server
            Toast.makeText(this,"left to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send left to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void right(View v){
        if (isConnected && out!=null) {
            out.println("right"); //send "next" to server
            Toast.makeText(this,"right to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send right to server", Toast.LENGTH_SHORT).show();
        }

    }
    public void down(View v){
        if (isConnected && out!=null) {
            out.println("down"); //send "next" to server
            Toast.makeText(this,"down to PC", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"unable to send down to server", Toast.LENGTH_SHORT).show();
        }




    }



    //OnClick method is called when any of the buttons are pressed
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.playPauseButton:
                if (isConnected && out!=null) {
                    out.println(Constants.MOUSE_RIGHT_CLICK);//send "play" to server
                    Toast.makeText(this,"Play to PC", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(MainActivity.this,Testing.class));
                }
                else {
                    Toast.makeText(this,"unable to send Play to server", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nextButton:
                startActivity(new Intent(MainActivity.this,Voice.class));
                break;
            case R.id.previousButton:
                if (isConnected && out!=null) {
                    out.println(Constants.MOUSE_LEFT_CLICK); //send "previous" to server
                    Toast.makeText(this,"Left click to PC", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this,"unable to send previous to server", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    @Override
    public void onDestroy()
    {
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
            Toast.makeText(context,isConnected?"CONNECTED TO PC!":"ERROR WHILE CONNECTING",Toast.LENGTH_LONG).show();
            try {
                if(isConnected) {
                    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                            .getOutputStream())), true); //create output stream to send data to server
                }
            }catch (IOException e){
                Log.e("remotedroid", "Error while creating OutWriter", e);
                Toast.makeText(context,"Error while connecting",Toast.LENGTH_LONG).show();
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
                startActivity(new Intent(MainActivity.this,Updation.class));
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}