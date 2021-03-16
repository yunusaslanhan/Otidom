package com.example.yunus.otidom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdimSayarUygulamaSon extends AppCompatActivity {


    private Button btnCik;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adim_sayar_uygulama_son);


        btnCik=findViewById(R.id.btnCik);

        Bundle extras = getIntent().getExtras();
        String adimsayi = extras.getString("gorev5");

        Bundle extras2 = getIntent().getExtras();
        id= extras2.getString("id");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef=FirebaseDatabase.getInstance().getReference().child("users").child(id).child("AdimSayar").child("Gorev5");

        dbRef.setValue(adimsayi+" adım");


        btnCik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(AdimSayarUygulamaSon.this,OyunlarActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
}
