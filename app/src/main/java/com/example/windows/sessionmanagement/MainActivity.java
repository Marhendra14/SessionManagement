package com.example.windows.sessionmanagement;

import android.content.Intent;
import android.media.MediaCas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SessionManagement sessionManagement;
    EditText edtEmail, edtPassword;
    Button buttonLogin;
    String email,passowrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.editEmail);
        edtPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        sessionManagement = new SessionManagement(this);

        if (sessionManagement.isLoggedIn()) {
            goToActivity();
        }

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edtEmail.getText().toString().trim();
                passowrd = edtPassword.getText().toString().trim();
                if((email.matches("")) || (passowrd.matches("")))
                {
                    Toast.makeText(MainActivity.this, "Email atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    sessionManagement.createLoginSession(edtEmail.getText().toString(), edtPassword.getText().toString());
                    goToActivity();
                }
            }
        });
    }

    private void goToActivity() {
        Intent mIntent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(mIntent);
    }
}
