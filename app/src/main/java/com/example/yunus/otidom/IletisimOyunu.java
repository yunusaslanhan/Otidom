package com.example.yunus.otidom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IletisimOyunu extends AppCompatActivity {

    private Button btn1;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iletisim_oyunu);

        final MediaPlayer merhaba= MediaPlayer.create(this, R.raw.merhaba);
        final MediaPlayer memnun= MediaPlayer.create(this, R.raw.memnun);
        final MediaPlayer yasvesinif= MediaPlayer.create(this, R.raw.yasvesinif);
        final MediaPlayer hatirlaisim= MediaPlayer.create(this, R.raw.hatirlaisim);
        final MediaPlayer isterim= MediaPlayer.create(this, R.raw.isterim);
        final MediaPlayer videoizlet= MediaPlayer.create(this, R.raw.videoizlet);
        btn1=findViewById(R.id.btn1);
        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");

        isterim.start();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setEnabled(false);
                merhaba.start();
                try {
                    Thread.sleep(Long.parseLong("6500"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                memnun.start();
                try {
                    Thread.sleep(Long.parseLong("4000"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                yasvesinif.start();
                try {
                    Thread.sleep(Long.parseLong("8000"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                videoizlet.start();
                try {
                    Thread.sleep(Long.parseLong("4500"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(IletisimOyunu.this,Video1.class);
                intent.putExtra("id",id);
                startActivity(intent);


            }
        });
    }
}
