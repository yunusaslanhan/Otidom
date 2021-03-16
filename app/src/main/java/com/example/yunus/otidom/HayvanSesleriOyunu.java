package com.example.yunus.otidom;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class HayvanSesleriOyunu extends AppCompatActivity {
    private Button btn1,btn2,btn3;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayvan_sesleri_oyunu);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);


        final MediaPlayer alkis = MediaPlayer.create(this, R.raw.alkiss);
        final MediaPlayer kopek = MediaPlayer.create(this, R.raw.kopek);
        final MediaPlayer dinlenenses = MediaPlayer.create(this, R.raw.dinlenenses);
        final MediaPlayer kopeksesi = MediaPlayer.create(this, R.raw.kopeksesi);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");

        dinlenenses.start();

        try {
            Thread.sleep(Long.parseLong("3000"),10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        kopeksesi.start();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kopek.start();
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
                Intent intent = new Intent(HayvanSesleriOyunu.this,HayvanSesleriOyunu2.class);
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
