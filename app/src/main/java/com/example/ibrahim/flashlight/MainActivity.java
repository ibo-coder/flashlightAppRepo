package com.example.ibrahim.flashlight;

import android.app.ActionBar;
import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import java.security.Policy;

public class MainActivity extends AppCompatActivity {
private Camera cam1;
    Camera.Parameters params;
    private boolean isOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.launcher);
final MediaPlayer clickSound=MediaPlayer.create(this,R.raw.hitsound);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        cam1=Camera.open();
        final ImageButton btn=(ImageButton)findViewById(R.id.btnpower);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();

                if(isOn){
                    params.setFlashMode(Parameters.FLASH_MODE_OFF);
                    cam1.setParameters(params);
                    cam1.stopPreview();
                    isOn=false;
                    btn.setBackgroundResource(R.drawable.officon);
                }else{
                    params=cam1.getParameters();
                    params.setFlashMode(Parameters.FLASH_MODE_TORCH);
                    cam1.setParameters(params);
                    cam1.startPreview();
                    isOn=true;
                    btn.setBackgroundResource(R.drawable.onicon);
                }
            }
        });





    }
}
