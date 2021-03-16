package com.example.yunus.otidom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IletisimOyunu5 extends AppCompatActivity {

    private Button btn1;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iletisim_oyunu5);

        final MediaPlayer kardes= MediaPlayer.create(this, R.raw.kardes);
        final MediaPlayer anne= MediaPlayer.create(this, R.raw.anne);
        final MediaPlayer saklambac= MediaPlayer.create(this, R.raw.saklambac);
        final MediaPlayer hatirlasaklambac= MediaPlayer.create(this, R.raw.hatirlasaklambac);
        final MediaPlayer videoizlet= MediaPlayer.create(this, R.raw.videoizlet);

        btn1=findViewById(R.id.btn1);

        Bundle extras2 = getIntent().getExtras();
        id= extras2.getString("id");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setEnabled(false);

                anne.start();
                try {
                    Thread.sleep(Long.parseLong("8000"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                kardes.start();
                try {
                    Thread.sleep(Long.parseLong("8000"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                saklambac.start();
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

                Intent intent = new Intent(IletisimOyunu5.this,Video3.class);
                intent.putExtra("id",id);
                startActivity(intent);





            }
        });
    }
}
