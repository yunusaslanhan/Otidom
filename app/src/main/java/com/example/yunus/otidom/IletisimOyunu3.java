package com.example.yunus.otidom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IletisimOyunu3 extends AppCompatActivity {

    private Button btn1;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iletisim_oyunu3);

        final MediaPlayer cizgifilm= MediaPlayer.create(this, R.raw.cizgifilm);
        final MediaPlayer dondurma= MediaPlayer.create(this, R.raw.dondurma);
        final MediaPlayer yemek= MediaPlayer.create(this, R.raw.yemek);
        final MediaPlayer hatirladondurma= MediaPlayer.create(this, R.raw.hatirladondurma);
        final MediaPlayer videoizlet= MediaPlayer.create(this, R.raw.videoizlet);

        btn1=findViewById(R.id.btn1);

        Bundle extras2 = getIntent().getExtras();
        id= extras2.getString("id");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setEnabled(false);
                cizgifilm.start();
                try {
                    Thread.sleep(Long.parseLong("8000"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dondurma.start();
                try {
                    Thread.sleep(Long.parseLong("6500"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                yemek.start();
                try {
                    Thread.sleep(Long.parseLong("6500"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                videoizlet.start();
                try {
                    Thread.sleep(Long.parseLong("4500"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(IletisimOyunu3.this,Video2.class);
                intent.putExtra("id",id);
                startActivity(intent);



            }
        });


    }
}
