package com.example.students;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int second = 0;
    private Boolean isRunning = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
        if(savedInstanceState != null){
            second = savedInstanceState.getInt("second");
        }
    }
    public void onBtnClick(View view){
        Spinner spinner = (Spinner) findViewById(R.id.spinner5);
        String author = (String) spinner.getSelectedItem();
        Intent intent = new Intent(this, BooksListActivity.class);
        intent.putExtra(BooksListActivity.AUTHOR, author);
        startActivity(intent);
    }
    public void onBtnGenreClick(View view){
        Spinner spinner = (Spinner) findViewById(R.id.spinner5);
        String author = (String)spinner.getSelectedItem();
        Intent intent = new Intent(this,genreBooksActivity.class);
        intent.putExtra(BooksListActivity.AUTHOR, author);
        startActivity(intent);

    }
    private void runTimer(){
        final TextView timeView  = (TextView)findViewById(R.id.textView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = second/3600;
                int minutes = (second%3600)/60;
                int secs = second%60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if(isRunning) {
                    second++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("second", second);
    }

    @Override
    protected void onStart() {
        super.onStart();
        isRunning = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isRunning = false;
    }
}