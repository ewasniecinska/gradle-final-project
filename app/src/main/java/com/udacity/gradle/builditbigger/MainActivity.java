package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.popular.android.android_lib.JokeDetail;
import com.popular.android.java_lib.JokeGenerator;


public class MainActivity extends AppCompatActivity {
    JokeGenerator jokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        jokes = new JokeGenerator();
        String joke = jokes.getJoke();

        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, ""));
        //Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, JokeDetail.class);
        intent.putExtra("JOKE", joke);
        startActivity(intent);
    }
}
