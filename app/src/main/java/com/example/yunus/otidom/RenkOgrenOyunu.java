package com.example.yunus.otidom;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RenkOgrenOyunu extends AppCompatActivity {

    private int puan=3;
    private Button btnMavi,btnKirmizi,btnYesil;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renk_ogren_oyunu);

        btnMavi=findViewById(R.id.btnMavi);
        btnKirmizi=findViewById(R.id.btnKirmizi);
        btnYesil=findViewById(R.id.btnYesil);

        final MediaPlayer maviyigoster = MediaPlayer.create(this, R.raw.maviyigoster);
        final MediaPlayer mavi = MediaPlayer.create(this, R.raw.mavi);
        maviyigoster.start();

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");

        btnMavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mavi.start();


                try {
                    Thread.sleep(Long.parseLong("2000"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(RenkOgrenOyunu.this,RenkOgrenLevel2.class);
                intent.putExtra("id",id);


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference dbRef=FirebaseDatabase.getInstance().getReference().child("users").child(id).child("RenkOyun").child("Level1");

                dbRef.setValue(puan+" puan");

                startActivity(intent);


            }
        });


        btnKirmizi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_UP:{

                        Button view =(Button)v;
                        view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        puan--;
                        btnKirmizi.setEnabled(false);
                        break;

                    }

                }

                return false;
            }
        });

        btnYesil.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_UP:{

                        Button view =(Button)v;
                        view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        puan--;
                        btnYesil.setEnabled(false);
                        break;

                    }

                }

                return false;
            }
        });

    }



    }
