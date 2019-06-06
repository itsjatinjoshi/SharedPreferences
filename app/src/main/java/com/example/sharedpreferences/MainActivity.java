package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tvWelcome;
    EditText etName;
    Button btnSubmit;

    public static final String MY_PROFILE="com.example.sharedpreferences.Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.tvWelcome);
        etName= findViewById(R.id.etName);
        btnSubmit= findViewById(R.id.btnSubmit);

        SharedPreferences pref= getSharedPreferences(MY_PROFILE, MODE_PRIVATE);
        String user = ((SharedPreferences) pref).getString("user", "");
        tvWelcome.setText("Wecome to my App " + user+ "!");


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= etName.getText().toString().trim();
                tvWelcome.setText("Wecome to my App " + name+ "!");

                SharedPreferences.Editor editor= getSharedPreferences(MY_PROFILE, MODE_PRIVATE).edit();
                editor.putString("user", name);
                editor.commit();
            }
        });

    }
}
