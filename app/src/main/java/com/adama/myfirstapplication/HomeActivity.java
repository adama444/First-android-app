package com.adama.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView tv_email;
    private Button btn_sign_out;
    private SharedPreferences.Editor my_pref_editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv_email = findViewById(R.id.tv_email);
        btn_sign_out = findViewById(R.id.btn_sign_out);

        SharedPreferences my_preferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        my_pref_editor = my_preferences.edit();
        tv_email.setText(my_preferences.getString(getString(R.string.email), ""));

        btn_sign_out.setOnClickListener(view -> {
            my_pref_editor.putBoolean(getString(R.string.sign_out), true);
            my_pref_editor.apply();
            this.finish();
        });
    }
}