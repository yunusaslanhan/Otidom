package com.example.yunus.otidom;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class HayvanSesleriOyunu4 extends AppCompatActivity {
    private Button btn1,btn2,btn3;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayvan_sesleri_oyunu4);


        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);

        final MediaPlayer alkis = MediaPlayer.create(this, R.raw.alkiss);
        final MediaPlayer kedi = MediaPlayer.create(this, R.raw.kedi);
        final MediaPlayer dinlenenses = MediaPlayer.create(this, R.raw.dinlenenses);
        final MediaPlayer kedisesi = MediaPlayer.create(this, R.raw.kedisesi);


        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");

        dinlenenses.start();

        try {
            Thread.sleep(Long.parseLong("3000"),10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        kedisesi.start();


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kedi.start();
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
                Intent intent = new Intent(HayvanSesleriOyunu4.this,HayvanSesleriOyunu5.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn3.setOnTouchListener(new View.OnTouchListener() {
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


    }
}
