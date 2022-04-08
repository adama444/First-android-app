package com.adama.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_email;
    private EditText et_password;
    private String email, password;
    private SharedPreferences.Editor my_pref_editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences my_preferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        my_pref_editor = my_preferences.edit();
        boolean is_signed_out = my_preferences.getBoolean(getString(R.string.sign_out), true);
        if (!is_signed_out) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            this.finish();
        }

        Button btn_sign_in = findViewById(R.id.btn_sign_in);
        Button btn_sign_up = findViewById(R.id.btn_sign_up);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);


        email = my_preferences.getString(getString(R.string.email), "");
        password = my_preferences.getString(getString(R.string.password), "");

        btn_sign_in.setOnClickListener(view -> {
            if (et_email.getText().toString().equals(email) && et_password.getText().toString().equals(password)) {
                Toast.makeText(this, "You're signed in", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                my_pref_editor.putBoolean(getString(R.string.sign_out), false);
                my_pref_editor.apply();
                this.finish();
            }

        });

        btn_sign_up.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        });
    }
}