package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static final String message = "com.example.CryptoBug.MESSAGE";
    private String str;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate: Starting onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //launchDetailActivity = (Button) findViewById(R.id.launchDetailActivity);
        //userInput = (EditText) findViewById(R.id.userInput);
        launchDetailActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });


    }
    public void openActivity() {
        Intent intent = new Intent(this, DetailActivity.class);
        str = userInput.getText().toString();
        intent.putExtra("CoinName", str);
        startActivity(intent);
    }

}