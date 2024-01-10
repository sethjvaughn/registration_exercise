package com.example.registation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChooseActivity extends AppCompatActivity {

    TextView shop_btn,browse_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        init();
        clickEvent();
    }

    private void init(){
        shop_btn = findViewById(R.id.shopping_tv);
        browse_btn = findViewById(R.id.browsing_tv);
    }

    private void clickEvent(){
        shop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this,ShopActivity.class);
                startActivity(intent);
            }
        });

        browse_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this, BrowseActivity.class);
                startActivity(intent);
            }
        });
    }
}