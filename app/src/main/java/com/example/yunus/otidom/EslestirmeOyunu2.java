package com.example.yunus.otidom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;

public class EslestirmeOyunu2 extends AppCompatActivity {

    private ImageView img;
    private ViewGroup rootLayout;
    private int _xDelta;
    private int _yDelta;
    private MediaPlayer armut;
    private MediaPlayer alkis;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eslestirme_oyunu2);
        rootLayout = (ViewGroup) findViewById(R.id.view_root2);
        img = (ImageView) rootLayout.findViewById(R.id.imageView2);

        final MediaPlayer armutuesle = MediaPlayer.create(this, R.raw.armutuesle);
        armut = MediaPlayer.create(this,R.raw.armut);
        alkis = MediaPlayer.create(this, R.raw.alkiss);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");

        armutuesle.start();

        AbsoluteLayout.LayoutParams layoutParams = ((AbsoluteLayout.LayoutParams) img.getLayoutParams());
        layoutParams.x=250;
        layoutParams.y=800;
        img.setLayoutParams(layoutParams);
        img.setOnTouchListener(new EslestirmeOyunu2.ChoiceTouchListener());
    }
    private final class ChoiceTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    AbsoluteLayout.LayoutParams lParams = (AbsoluteLayout.LayoutParams) view.getLayoutParams();
                    _xDelta = X - lParams.x;
                    _yDelta = Y - lParams.y;
                    break;
                case MotionEvent.ACTION_UP:
                    AbsoluteLayout.LayoutParams layoutParams2 = ((AbsoluteLayout.LayoutParams) img.getLayoutParams());
                    layoutParams2.x=250;
                    layoutParams2.y=800;
                    img.setLayoutParams(layoutParams2);
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:


                    break;
                case MotionEvent.ACTION_MOVE:
                    AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) view
                            .getLayoutParams();
                    layoutParams.x = X - _xDelta;
                    layoutParams.y = Y - _yDelta;
                    view.setLayoutParams(layoutParams);


                    if (layoutParams.x>250 && layoutParams.x<350 && layoutParams.y>180 && layoutParams.y<260){


                        alkis.start();
                        try {
                            Thread.sleep(Long.parseLong("2000"),10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        Intent intent2 = new Intent(EslestirmeOyunu2.this,EslestirmeOyunu3.class);
                        intent2.putExtra("id",id);
                        startActivity(intent2);
                    }

                    break;
            }
            rootLayout.invalidate();
            return true;
        }
    }
}
