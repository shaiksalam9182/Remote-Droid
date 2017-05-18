package com.example.raj.remotedroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }


    public void changevoice(View v){
        startActivity(new Intent(DashBoard.this,Voice.class));
    }
    public void changeother(View v){
        startActivity(new Intent(DashBoard.this,MainActivity.class));
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
                startActivity(new Intent(DashBoard.this,Updation.class));
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
