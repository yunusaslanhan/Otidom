package com.example.yunus.otidom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IletisimOyunu7 extends AppCompatActivity {


    private Button btnCikis;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iletisim_oyunu7);

        btnCikis=findViewById(R.id.btnCikis);

        final MediaPlayer baloncuk= MediaPlayer.create(this, R.raw.baloncuk);

        Bundle extras2 = getIntent().getExtras();
        id= extras2.getString("id");

        try {
            Thread.sleep(Long.parseLong("2600"),10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        baloncuk.start();

        btnCikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(IletisimOyunu7.this,OyunlarActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }
}
