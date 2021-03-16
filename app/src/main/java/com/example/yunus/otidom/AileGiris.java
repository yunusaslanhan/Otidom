package com.example.yunus.otidom;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AileGiris extends AppCompatActivity {


    Button btnSignin, btnSignup;
    EditText userMail, userPassword;
    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aile_giris);

        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

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
                                startActivity(new Intent(AileGiris.this, AileAnasayfa.class));
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
                final String inputEmail = userMail.getText().toString().trim();
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

                                String uId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                databaseReference = FirebaseDatabase.getInstance().getReference("users/"+uId);
                                User user = new User(inputEmail,uId);
                                databaseReference.setValue(user);
                                String id=user.getuId();
                                Toast.makeText(AileGiris.this, "Kayıt başarılı!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(AileGiris.this, CocukBilgileri.class);
                                intent.putExtra("id",id);
                                startActivity(intent);
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
