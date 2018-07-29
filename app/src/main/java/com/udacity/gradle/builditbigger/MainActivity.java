package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.popular.android.android_lib.JokeDetail;
import com.popular.android.java_lib.JokeGenerator;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.Callback  {
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

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        new EndpointsAsyncTask().execute(this);
    }

    @Override
    public void onJokeReceived(MyBean joke) {
        if(joke == null){
            Toast.makeText(this, "There is error", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, joke.getData(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, JokeDetail.class);
            intent.putExtra("JOKE", joke.getData());
            startActivity(intent);
        }
    }
}
