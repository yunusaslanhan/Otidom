package com.example.yunus.otidom;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class SayiSiralamaOyunu extends AppCompatActivity {

    private Button btn1,btn2,btn3;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayi_siralama_oyunu);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);

        final MediaPlayer siradaki = MediaPlayer.create(this, R.raw.siradakisayi);
        final MediaPlayer dort = MediaPlayer.create(this,R.raw.dort);
        final MediaPlayer alkis = MediaPlayer.create(this, R.raw.alkiss);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");

        siradaki.start();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dort.start();
                try {
                    Thread.sleep(Long.parseLong("800"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                alkis.start();
                try {
                    Thread.sleep(Long.parseLong("2000"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(SayiSiralamaOyunu.this,SayiSiralamaOyunuLevel2.class);
                intent.putExtra("id",id);
                startActivity(intent);
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


    }
}
