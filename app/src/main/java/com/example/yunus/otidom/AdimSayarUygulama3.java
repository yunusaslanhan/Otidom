package com.example.yunus.otidom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdimSayarUygulama3 extends AppCompatActivity {

    private Button btnBasla;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adim_sayar_uygulama3);

        btnBasla=findViewById(R.id.btnBasla);

        Bundle extras = getIntent().getExtras();
        String adimsayi = extras.getString("gorev1");

        Bundle extras2 = getIntent().getExtras();
         id= extras.getString("id");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef=FirebaseDatabase.getInstance().getReference().child("users").child(id).child("AdimSayar").child("Gorev1");

        dbRef.setValue(adimsayi+" adım");

        btnBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdimSayarUygulama3.this,AdimSayarUygulama4.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });



    }
}
