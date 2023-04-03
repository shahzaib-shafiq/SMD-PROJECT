package com.example.bscs_sec_a_batch_20.SensorExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bscs_sec_a_batch_20.R;

public class CensorExampleOneMainActivity extends AppCompatActivity {


    TextView textView;
    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_censor_example_one_main);
        textView = findViewById(R.id.txtcensorvalue);

        sensorManager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (sensor == null) {
            textView.setText("No Sensor Value");
        } else {
            sensorManager.registerListener(proximitySensorEventListner, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    SensorEventListener proximitySensorEventListner = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            if (sensorEvent.values[0]==0) {
                textView.setText("Object Is Near");
            } else {
                textView.setText("Object Is away");
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

}



