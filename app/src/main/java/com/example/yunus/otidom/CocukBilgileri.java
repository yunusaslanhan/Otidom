package com.example.yunus.otidom;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class CocukBilgileri extends AppCompatActivity {

    TextView txtTarih;
    Button btnTarinSec,btnKaydet;
    EditText edtAd,edtSoyad;
    RadioButton rdErkek,rdKız,rdOtizm,rdDown;
    RadioGroup rgCinsiyet,rgRahatsızlık;
    String cinsiyet="";
    String rahatsızlık="";
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocuk_bilgileri);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");


        initComponents();

        btnTarinSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar takvim = Calendar.getInstance(); // Takvim objesini oluşturuyoruz.
                int year = takvim.get(Calendar.YEAR); //Güncel Yılı alıyoruz.
                int month = takvim.get(Calendar.MONTH); //Güncel Ayı alıyoruz.
                int day = takvim.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(CocukBilgileri.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int yil, int ay,
                                          int gun) {
                        // TODO Auto-generated method stub
                        ay +=1; // Aylar sıfırdan başladığı için ayı +1 ekliyoruz.
                        txtTarih.setText( gun + "/" + ay+ "/"+yil); //Ekrana tüm tarihi yazdırıyoruz

                    }
                },year,month,day); //Sırasıyla set edilecek değerleri yazıyoruz.
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "SEÇ", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İPTAL", datePicker);
                datePicker.show();


            }
        });


        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatabaseReference dbRef=FirebaseDatabase.getInstance().getReference().child("users").child(id).child("CocukBilgi");

                int secilenHangiRadio=rgCinsiyet.getCheckedRadioButtonId();

                switch(secilenHangiRadio)

                {
                    case R.id.rdErkek: {cinsiyet= rdErkek.getText().toString(); break; }
                    case R.id.rdKız: { cinsiyet=rdKız.getText().toString(); break;}
                }


                int secilenHangiRadio2=rgRahatsızlık.getCheckedRadioButtonId();
                switch(secilenHangiRadio2)
                {
                    case R.id.rdOtizm: { rahatsızlık=rdOtizm.getText().toString(); break; }
                    case R.id.rdDown: { rahatsızlık=rdDown.getText().toString(); break;}
                }

                dbRef.setValue(

                        new Cocuklar(
                                edtAd.getText().toString(),
                                edtSoyad.getText().toString(),
                                txtTarih.getText().toString(),
                                cinsiyet,
                                rahatsızlık

                        )


                );

                Toast.makeText(CocukBilgileri.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CocukBilgileri.this,AileAnasayfa.class);
                intent.putExtra("id",id);
                startActivity(intent);


            }
        });



    }




    private void initComponents() {

        txtTarih=findViewById(R.id.txtTarih);
        btnTarinSec=findViewById(R.id.btnTarihSec);
        edtAd=findViewById(R.id.txtAd);
        edtSoyad=findViewById(R.id.txtSoyad);
        rdErkek=findViewById(R.id.rdErkek);
        rdKız=findViewById(R.id.rdKız);
        rdOtizm=findViewById(R.id.rdOtizm);
        rdDown=findViewById(R.id.rdDown);
        rgCinsiyet=findViewById(R.id.rgCinsiyet);
        rgRahatsızlık=findViewById(R.id.rgRahatsızlık);
        btnKaydet=findViewById(R.id.btnCocukKaydet);


    }




}
