package com.example.yunus.otidom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AileAnasayfa extends AppCompatActivity {

    private Button btnAile;
    private Button btnCocuk;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aile_anasayfa);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");


        initComponents();
        registerEventHandlers();


    }

    private void registerEventHandlers() {

        btnAile_onClick();
        btnCocuk_onClick();

    }

    private void btnCocuk_onClick() {

        btnCocuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent= new Intent(AileAnasayfa.this,OyunlarActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);

            }
        });

    }

    private void btnAile_onClick() {

        btnAile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(AileAnasayfa.this,AileProfil.class);
                startActivity(intent);

            }
        });


    }

    private void initComponents() {

        btnAile=findViewById(R.id.btnAile);
        btnCocuk=findViewById(R.id.btnCocuk);

    }
}
