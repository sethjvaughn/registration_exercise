package com.example.registation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText nameET, emailET, passwordET;
    private CheckBox singing, dancing, reading;
    private String name, email, password, gender,hobbies;
    private Button submit;
    private RadioGroup radioGroup;
     RadioButton maleRB, femaleRB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Edit Text
        nameET = findViewById(R.id.name_et);
        emailET = findViewById(R.id.email_et);
        passwordET = findViewById(R.id.password_et);

        //Submit Button
        submit = findViewById(R.id.submit_btn);
        submit.setOnClickListener(this);

        //RadioGroup
        radioGroup = findViewById(R.id.radio_group);
        maleRB = findViewById(R.id.rb_male);
        femaleRB = findViewById(R.id.rb_female);



        //Hobbies
        singing = findViewById(R.id.cb_sing);
        dancing = findViewById(R.id.cb_dance);
        reading = findViewById(R.id.cb_read);

        singing.setOnCheckedChangeListener(this);
        dancing.setOnCheckedChangeListener(this);
        reading.setOnCheckedChangeListener(this);


        hobbies = new String();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId){
                   case R.id.rb_male:
                       gender = "Male";
                       break;
                   case R.id.rb_female:
                       gender = "Female";
                       break;
               }
            }
        });
    }

    private void getData() {
         name = nameET.getText().toString().trim();
         email = emailET.getText().toString().trim();
         password = passwordET.getText().toString().trim();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_btn:
                getData();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(MainActivity.this, "Please input a name", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(email)) {
                    Toast.makeText(MainActivity.this, "Please input an email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Please input an password", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(gender)) {
                    Toast.makeText(MainActivity.this, "Please select gender", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(hobbies)) {
                    Toast.makeText(MainActivity.this, "Please select hobby", Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.i("MainActivity", "information for registration" + "Name:" + name + "Email:" + email+ "Password" + password + "Gender" + gender
                    +"Hobbies:" +hobbies);
                    sendData();

                    Toast.makeText(MainActivity.this, "Registration Complete!", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }


    private void sendData(){
        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("gender", gender);
        intent.putExtra("hobbies", hobbies);
        startActivity(intent);
    }



    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String motion = buttonView.getText().toString();

        if(isChecked){
            if(!hobbies.contains(motion)){
                hobbies = hobbies +  " " + motion;
            }
        }
        else {
            if(hobbies.contains(motion)){
                hobbies = hobbies.replace(motion,"");
            }
        }
    }
}