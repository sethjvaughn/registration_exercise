package com.example.registation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    private Button return_btn, next_btn;
    private TextView welcome_tv, name_tv, email_tv, gender_tv, hobby_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
        clickEvent();
    }

    private void init(){

    welcome_tv = findViewById(R.id.welcomeTV);

    name_tv = findViewById(R.id.name);

    email_tv = findViewById(R.id.email);

    gender_tv = findViewById(R.id.gender);

    hobby_tv = findViewById(R.id.hobbies);

    return_btn = findViewById(R.id.return_btn);

    next_btn = findViewById(R.id.next_btn);

    String name = getIntent().getStringExtra("name");
    String email = getIntent().getStringExtra("email");
    String gender = getIntent().getStringExtra("gender");
    String hobbies= getIntent().getStringExtra("hobbies");

    welcome_tv.setText("Welcome, " + " " + name + "!");
    name_tv.setText(name);
    email_tv.setText(email);
    gender_tv.setText(gender);
    hobby_tv.setText(hobbies);
}
    private void clickEvent(){
        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, ChooseActivity.class);
                startActivity(intent);
            }
        });
    }


}
