package com.example.yunus.otidom;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RenkOgrenLevel2 extends AppCompatActivity {

    private int puan=3;
    private Button btnPembe,btnSari,btnKirmizi;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renk_ogren_level2);

        btnPembe=findViewById(R.id.btnPembe);
        btnSari=findViewById(R.id.btnSari);
        btnKirmizi=findViewById(R.id.btnKirmizi);


        final MediaPlayer kirmiziyigoster = MediaPlayer.create(this, R.raw.kirmiziyigoster);
        final MediaPlayer kirmizi = MediaPlayer.create(this, R.raw.kirmizi);


        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");


        kirmiziyigoster.start();

        btnKirmizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kirmizi.start();


                try {
                    Thread.sleep(Long.parseLong("2000"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(RenkOgrenLevel2.this,RenkOgrenLevel3.class);
                intent.putExtra("id",id);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference dbRef=FirebaseDatabase.getInstance().getReference().child("users").child(id).child("RenkOyun").child("Level2");

                dbRef.setValue(puan+" puan");

                startActivity(intent);



            }
        });


        btnSari.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_UP:{

                        Button view =(Button)v;
                        view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        puan--;
                        btnSari.setEnabled(false);
                        break;

                    }

                }

                return false;
            }
        });

        btnPembe.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_UP:{

                        Button view =(Button)v;
                        view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        puan--;
                        btnPembe.setEnabled(false);
                        break;

                    }

                }

                return false;
            }
        });


    }
}
