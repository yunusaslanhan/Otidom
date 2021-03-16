package com.example.yunus.otidom;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DoktorGiris extends AppCompatActivity {

    Button btnSignin, btnSignup;
    EditText userMail, userPassword;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doktor_giris);

        auth = FirebaseAuth.getInstance();

        initComponents();
        registerEventHandlers();
    }


    private void registerEventHandlers() {

        btnSignin_onClick();
        btnSignup_onClick();

    }
    private void btnSignin_onClick() {

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputEmail = userMail.getText().toString().trim();
                String inputPassword = userPassword.getText().toString().trim();

                if (TextUtils.isEmpty(inputEmail)) {
                    Toast.makeText(getApplicationContext(), "Mail adresinizi giriniz!", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(inputPassword)) {
                    Toast.makeText(getApplicationContext(), "Şifrenizi giriniz!", Toast.LENGTH_LONG).show();
                } else if (inputPassword.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Şifreniz çok kısa!", Toast.LENGTH_LONG).show();
                } else {


                    //Sign in user
                    auth.signInWithEmailAndPassword(inputEmail, inputPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                startActivity(new Intent(DoktorGiris.this, DoktorAnasayfa.class));
                            } else {
                                Toast.makeText(getApplicationContext(), "Kimlik doğrulama başarısız!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });


    }

    private void btnSignup_onClick() {

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputEmail = userMail.getText().toString().trim();
                String inputPassword = userPassword.getText().toString().trim();

                if (TextUtils.isEmpty(inputEmail)) {
                    Toast.makeText(getApplicationContext(), "Mail adresinizi giriniz!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(inputPassword)) {
                    Toast.makeText(getApplicationContext(), "Şifrenizi giriniz!", Toast.LENGTH_SHORT).show();
                } else if (inputPassword.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Şifreniz çok kısa!", Toast.LENGTH_SHORT).show();
                } else {


                    //Create user
                    auth.createUserWithEmailAndPassword(inputEmail, inputPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(DoktorGiris.this, "Kayıt başarılı!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(DoktorGiris.this, DoktorAnasayfa.class));
                            } else {
                                Toast.makeText(getApplicationContext(), "Kayıt Başarısız!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });



    }


    private void initComponents() {

        userMail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);

        btnSignin = findViewById(R.id.btnSignin);
        btnSignup = findViewById(R.id.btnSignup);

    }


}
