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

public class RenkOgrenLevel5 extends AppCompatActivity {

    private int puan=3;
    private Button btnMor,btnMavi,btnKirmizi;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renk_ogren_level5);

        btnMor=findViewById(R.id.btnMor);
        btnMavi=findViewById(R.id.btnMavi);
        btnKirmizi=findViewById(R.id.btnKirmizi);


        final MediaPlayer morugoster = MediaPlayer.create(this, R.raw.morugoster);
        final MediaPlayer mor = MediaPlayer.create(this, R.raw.mor);
        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");

        morugoster.start();

        btnMor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mor.start();


                try {
                    Thread.sleep(Long.parseLong("2000"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(RenkOgrenLevel5.this,RenkOgrenLevelSon.class);
                intent.putExtra("id",id);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference dbRef=FirebaseDatabase.getInstance().getReference().child("users").child(id).child("RenkOyun").child("Level5");

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

        btnMavi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_UP:{

                        Button view =(Button)v;
                        view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        puan--;
                        btnMavi.setEnabled(false);
                        break;

                    }

                }

                return false;
            }
        });

    }
}
