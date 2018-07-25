package com.popular.android.android_lib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDetail extends AppCompatActivity {

    TextView textView;
    Intent intent;
    String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);

        textView = findViewById(R.id.text_view);

        intent = getIntent();

        joke = intent.getStringExtra("JOKE");

        textView.setText(joke);
    }
}
