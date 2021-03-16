package com.example.yunus.otidom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Video1 extends AppCompatActivity {
    private Button btn1;
    private VideoView video;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video1);


        final MediaPlayer hatirlaisim= MediaPlayer.create(this, R.raw.hatirlaisim);

        btn1=findViewById(R.id.btn1);
        video=findViewById(R.id.videoOynat);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");

        Uri yol=Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.pepe );
        video.setVideoURI(yol);
        video.start();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setEnabled(false);
                video.pause();
                hatirlaisim.start();
                try {
                    Thread.sleep(Long.parseLong("2000"),10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent1 = new Intent(Video1.this,IletisimOyunu2.class);
                intent1.putExtra("id",id);
                startActivity(intent1);
            }
        });
    }
}
