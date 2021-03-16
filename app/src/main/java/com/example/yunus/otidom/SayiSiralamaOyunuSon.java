package com.example.yunus.otidom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SayiSiralamaOyunuSon extends AppCompatActivity {

    private Button btnCikis;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayi_siralama_oyunu_son);

        btnCikis=findViewById(R.id.btnCikis);

        final MediaPlayer tebrik = MediaPlayer.create(this, R.raw.tebrik);
        final MediaPlayer alkis = MediaPlayer.create(this, R.raw.alkis);
        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");


        tebrik.start();
        try {
            Thread.sleep(Long.parseLong("2600"),10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alkis.start();

        btnCikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SayiSiralamaOyunuSon.this,OyunlarActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }

}
