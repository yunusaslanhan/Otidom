package com.example.yunus.otidom;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdimSayarUygulama8 extends AppCompatActivity implements SensorEventListener {

    public SensorManager sensorManager;
    public TextView count;
    boolean activityRunning;
    public Button btnBitir;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adim_sayar_uygulama8);

        count = (TextView) findViewById(R.id.count);
        btnBitir =findViewById(R.id.btnBitir);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");

        btnBitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adim= (String) count.getText();
                Intent intent = new Intent(AdimSayarUygulama8.this,AdimSayarUygulama9.class);
                intent.putExtra("id",id);
                intent.putExtra("gorev4",adim);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        activityRunning = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        activityRunning = false;
        // if you unregister the last listener, the hardware will stop detecting step events
//        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (activityRunning) {
            count.setText(String.valueOf(event.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
