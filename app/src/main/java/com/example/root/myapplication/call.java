package com.example.root.myapplication;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder mHolder;
    private Camera mCamera;

    public CameraPreview(Context context, Camera camera) {
        super(context);
        mCamera = camera;
        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void surfaceCreated(SurfaceHolder holder) {
        // The Surface has been created, now tell the camera where to draw the preview.
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.setDisplayOrientation(90);
            mCamera.startPreview();
        } catch (IOException e) {

        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {

        if (mHolder.getSurface() == null){
            return;
        }

        try {
            mCamera.stopPreview();
        } catch (Exception e){

        }

        try {
            mCamera.setPreviewDisplay(mHolder);
            mCamera.startPreview();

        } catch (Exception e){

        }
    }
}
public class call extends AppCompatActivity implements SurfaceHolder.Callback,RecognitionListener {
private static Camera openFrontFacingCamera()
{
    int cameraCount = 0;
    Camera cam = null;
    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
    cameraCount = Camera.getNumberOfCameras();
    for ( int camIdx = 0; camIdx < cameraCount; camIdx++ ) {
        Camera.getCameraInfo( camIdx, cameraInfo );
        if ( cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT  ) {
            try {
                cam = Camera.open( camIdx );
            } catch (RuntimeException e) {

            }
        }
    }
    return cam;
}
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.call);
    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 1);
    final Intent speechIntent;
    speechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "en");
    speechIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
    final SpeechRecognizer speechInput;
    speechInput = SpeechRecognizer.createSpeechRecognizer(this);
    speechInput.setRecognitionListener(this);
    final Button button = (Button) findViewById(R.id.button);
    speechInput.startListening(speechIntent);
    TextView textview = (TextView) findViewById(R.id.textView2);
    textview.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            speechInput.startListening(speechIntent);
        }
    });
    Camera mCamera;
    CameraPreview mPreview;
    mCamera = getCameraInstance();
    mPreview = new CameraPreview(this, mCamera);
    FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
    preview.addView(mPreview);
}
private boolean checkCameraHardware(Context context) {
    if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
        return true;
    } else {
        return false;
    }
}

public Camera getCameraInstance() {
    Camera c = null;
    try {
        c = openFrontFacingCamera();
    } catch (Exception e) {

    }
    return c;
}
    private SurfaceHolder mHolder;
    private Camera mCamera;

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mCamera.setPreviewDisplay(holder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mCamera.startPreview();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

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
                TextView textview = (TextView) findViewById(R.id.textView2);
                textview.performClick();
            }
        }, 1000);
    }

    @Override
    public void onError(int error) {

    }

    @Override
    public void onResults(Bundle results) {
        ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText(matches.get(0));
    }

    @Override
    public void onPartialResults(Bundle partialResults) {

    }

    @Override
    public void onEvent(int eventType, Bundle params) {

    }
}