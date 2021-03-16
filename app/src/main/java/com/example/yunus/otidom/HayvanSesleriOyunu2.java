package com.example.yunus.otidom;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class HayvanSesleriOyunu2 extends AppCompatActivity {
    private Button btn1,btnn2,btn3;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayvan_sesleri_oyunu2);

        btn1=findViewById(R.id.btn1);
        btnn2=findViewById(R.id.btnn2);
        btn3=findViewById(R.id.btn3);

        final MediaPlayer alkis = MediaPlayer.create(this, R.raw.alkiss);
        final MediaPlayer civciv = MediaPlayer.create(this, R.raw.civciv);
        final MediaPlayer dinlenenses = MediaPlayer.create(this, R.raw.dinlenenses);
        final MediaPlayer civcivsesi = MediaPlayer.create(this, R.raw.civcivsesi);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");

        dinlenenses.start();

        try {
            Thread.sleep(Long.parseLong("3000"),10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        civcivsesi.start();


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                civciv.start();
                try {
                    Thread.sleep(Long.parseLong("800"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                alkis.start();

                try {
                    Thread.sleep(Long.parseLong("3000"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(HayvanSesleriOyunu2.this,HayvanSesleriOyunu3.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){

                    case MotionEvent.ACTION_UP:{

                        Button view =(Button)v;
                        view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;

                    }

                }

                return false;
            }
        });
        btnn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){

                    case MotionEvent.ACTION_UP:{

                        Button view =(Button)v;
                        view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;

                    }

                }

                return false;

            }
        });

    }
}
