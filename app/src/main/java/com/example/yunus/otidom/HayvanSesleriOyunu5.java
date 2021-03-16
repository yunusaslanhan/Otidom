package com.example.yunus.otidom;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class HayvanSesleriOyunu5 extends AppCompatActivity {
    private Button btn1,btn2,btn3;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayvan_sesleri_oyunu5);


        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);

        final MediaPlayer alkis = MediaPlayer.create(this, R.raw.alkiss);
        final MediaPlayer koyun = MediaPlayer.create(this, R.raw.koyun);
        final MediaPlayer dinlenenses = MediaPlayer.create(this, R.raw.dinlenenses);
        final MediaPlayer koyunsesi = MediaPlayer.create(this, R.raw.koyunsesi);

        Bundle extras2 = getIntent().getExtras();
        id= extras2.getString("id");

        dinlenenses.start();

        try {
            Thread.sleep(Long.parseLong("3000"),10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        koyunsesi.start();


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                koyun.start();
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
                Intent intent = new Intent(HayvanSesleriOyunu5.this,HayvanSesleriOyunuSon.class);
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
        btn2.setOnTouchListener(new View.OnTouchListener() {
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
