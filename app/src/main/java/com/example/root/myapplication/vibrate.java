package com.example.root.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Vibrator;

import java.util.ArrayList;

public class vibrate extends AppCompatActivity implements RecognitionListener {
    private final int REQ_CODE_SPEECH_INPUT = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vibrate);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 1);
        EditText et = (EditText)findViewById(R.id.editText2);
        et.setText("hello");
        final Intent speechIntent;
        speechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "en");
        speechIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
        final SpeechRecognizer speechInput;
        speechInput = SpeechRecognizer.createSpeechRecognizer(this);
        speechInput.setRecognitionListener(this);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speechInput.startListening(speechIntent);
            }
        });
        button.performClick();
    }
    @Override
    public void onReadyForSpeech(Bundle params) {

    }
    @Override
    public void onBeginningOfSpeech() {

    }
    @Override
    public void onRmsChanged(float rmsdB) {

    }
    @Override
    public void onBufferReceived(byte[] buffer) {

    }
    @Override
    public void onEndOfSpeech() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Button button = (Button) findViewById(R.id.button);
                button.performClick();
            }
        }, 1000);
    }
    @Override
    public void onError(int error) {

    }
    @Override
    public void onResults(Bundle results) {
        EditText et = (EditText) findViewById(R.id.editText2);
        ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if(matches.get(0).equals(et.getText().toString())){
            Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vib.vibrate(2000);
        }
        if(matches.get(0).contains(et.getText().toString())){
            Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vib.vibrate(2000);
        }
    }
    @Override
    public void onPartialResults(Bundle partialResults) {

    }
    @Override
    public void onEvent(int eventType, Bundle params) {

    }
}
