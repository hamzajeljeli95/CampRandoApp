package com.wassi.camprandoapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Register_activity extends AppCompatActivity {
    String name_user, password_user, re_password_user, email_user, ntel_user;
    ImageView btn_sgn_in;
    private EditText name, password, re_password, email, ntel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);
        initViews();
    }

    private void initViews() {


        name = (EditText) findViewById(R.id.name_user);
        email = (EditText) findViewById(R.id.email_user);
        password = (EditText) findViewById(R.id.pwd_user);
        re_password = (EditText) findViewById(R.id.re_pwd_user);
        btn_sgn_in = (ImageView) findViewById(R.id.replussign);
        ntel = (EditText) findViewById(R.id.tel_user);


        btn_sgn_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verif_champs();
            }
        });

    }

    public void verif_champs() {
        String ntel_user = ntel.getText().toString();
        String name_user = name.getText().toString();
        String email_user = email.getText().toString();
        String password_user = password.getText().toString();
        String re_password_user = re_password.getText().toString();

        if (!name_user.isEmpty() && !email_user.isEmpty() && !password_user.isEmpty() && !re_password_user.isEmpty() && !ntel_user.isEmpty()) {
            if (password_user.equals(re_password_user)) {
                registerProcess(name_user, email_user, password_user, re_password_user, ntel_user);
            } else {
                Toast.makeText(this, "Enter the same password !", Toast.LENGTH_LONG).show();
            }
        } else {

            Toast.makeText(this, "Fields are empty !", Snackbar.LENGTH_LONG).show();
        }
    }

    public void registerProcess(String name_user, String email_user, String password_user, String re_password_user, String ntel_user) {

    }
}

