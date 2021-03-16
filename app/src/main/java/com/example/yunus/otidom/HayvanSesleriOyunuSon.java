package com.example.yunus.otidom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HayvanSesleriOyunuSon extends AppCompatActivity {

    private Button btnCik;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayvan_sesleri_oyunu_son);

        btnCik=findViewById(R.id.btnCik);

        Bundle extras2 = getIntent().getExtras();
        id= extras2.getString("id");

        final MediaPlayer tebrik = MediaPlayer.create(this, R.raw.tebrik);
        final MediaPlayer alkis = MediaPlayer.create(this, R.raw.alkis);

        tebrik.start();
        try {
            Thread.sleep(Long.parseLong("2600"),10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alkis.start();

        btnCik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HayvanSesleriOyunuSon.this,OyunlarActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
}
