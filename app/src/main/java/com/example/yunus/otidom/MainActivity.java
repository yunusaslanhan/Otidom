package com.example.yunus.otidom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button btnAile;
    private Button btnDoktor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        registerEventHandlers();

    }

    private void registerEventHandlers() {

        btnAile_onClick();
        btnDoktor_onClick();

    }

    private void btnDoktor_onClick() {

        btnDoktor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(MainActivity.this,DoktorGiris.class);
                startActivity(intent);
            }
        });

    }

    private void btnAile_onClick() {
        btnAile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(MainActivity.this,AileGiris.class);
                startActivity(intent);

            }
        });

    }

    private void initComponents() {

        btnAile=findViewById(R.id.btnAile);
        btnDoktor=findViewById(R.id.btnDoktor);

    }
}
