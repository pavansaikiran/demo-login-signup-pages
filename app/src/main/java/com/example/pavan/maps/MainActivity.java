package com.example.pavan.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread t=new Thread(){
            @Override
            public void run() {
                try{
                    sleep(1600);
                    startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                }catch (Exception e){;}
            }
        };
        t.start();

            }
        }



