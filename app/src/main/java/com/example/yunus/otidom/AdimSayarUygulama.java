package com.example.yunus.otidom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdimSayarUygulama extends AppCompatActivity {

    private Button btnBasla;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adim_sayar_uygulama);

        btnBasla=findViewById(R.id.btnBasla);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");


        btnBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdimSayarUygulama.this,AdimSayarUygulama2.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }
}
