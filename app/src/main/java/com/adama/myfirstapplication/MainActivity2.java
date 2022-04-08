package com.adama.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private EditText et_email;
    private EditText et_password;
    private SharedPreferences.Editor my_pref_editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn_sign_up = findViewById(R.id.btn_sign_up_2);
        et_email = findViewById(R.id.et_email_2);
        et_password = findViewById(R.id.et_password_2);
        SharedPreferences my_preferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        my_pref_editor = my_preferences.edit();

        btn_sign_up.setOnClickListener(view -> {
            my_pref_editor.putString(getString(R.string.email), et_email.getText().toString());
            my_pref_editor.putString(getString(R.string.password), et_password.getText().toString());
            my_pref_editor.apply();
            this.finish();
        });
    }
}