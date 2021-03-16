package com.example.yunus.otidom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OyunlarActivity extends AppCompatActivity {


    private Button btnEslestirme,btnGorev,btnRenkOgren,btnSayiSiralama,btnHayvanSes,btnIletisim;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyunlar);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");


        initComponents();
        registerEventHandlers();
    }

    private void registerEventHandlers() {

        btnEslestirme_OnClick();
        btnGorev_OnClick();
        btnRenkOgren_OnClick();
        btnSayiSiralama_OnClick();
        btnHayvanSes_onClick();
        btnIletisim_onClick();
    }

    private void btnIletisim_onClick() {

        btnIletisim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(OyunlarActivity.this,IletisimOyunu.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }

    private void btnHayvanSes_onClick() {

        btnHayvanSes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(OyunlarActivity.this,HayvanSesleriOyunu.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }

    private void btnSayiSiralama_OnClick() {

        btnSayiSiralama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(OyunlarActivity.this,SayiSiralamaOyunu.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }

    private void btnRenkOgren_OnClick() {

        btnRenkOgren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(OyunlarActivity.this,RenkOgrenOyunu.class);
                intent.putExtra("id",id);
                startActivity(intent);

            }
        });


    }

    private void btnGorev_OnClick() {

        btnGorev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(OyunlarActivity.this,AdimSayarUygulama.class);
                intent.putExtra("id",id);
                startActivity(intent);

            }
        });




    }

    private void btnEslestirme_OnClick() {

        btnEslestirme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(OyunlarActivity.this,EslestirmeOyunu.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });


    }


    private void initComponents() {

        btnEslestirme=findViewById(R.id.btnEslestirme);
        btnGorev=findViewById(R.id.btnGorev);
        btnRenkOgren=findViewById(R.id.btnRenkOgren);
        btnSayiSiralama=findViewById(R.id.btnSayiSiralama);
        btnHayvanSes=findViewById(R.id.btnHayvanSesleri);
        btnIletisim=findViewById(R.id.btnIletisimOyunu);


    }
}
