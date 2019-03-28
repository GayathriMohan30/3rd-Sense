package com.example.root.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;
import android.content.Intent;
import android.speech.RecognizerIntent;
public class MainActivity extends AppCompatActivity {

    private final int REQ_CODE_SPEECH_INPUT = 100;
    TextView textview;
    FloatingActionButton floatingActionButton2;
    FloatingActionButton floatingActionButton3;
    FloatingActionButton floatingActionButton4;
    FloatingActionButton floatingActionButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        textview = (TextView) findViewById(R.id.textView);
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "speak something");
                startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
            }
        });
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.floatingActionButton1);
        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),text.class);
                startActivity(i);
            }
        });
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.floatingActionButton3);
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),vibrate.class);
                startActivity(i);
            }
        });
        floatingActionButton4 = (FloatingActionButton) findViewById(R.id.floatingActionButton4);
        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),call.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textview.setText(result.get(0));
                }
                break;
            }
        }
    }
}