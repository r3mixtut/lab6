package com.example.students;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import  android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class BooksListActivity extends AppCompatActivity {
    public static final String AUTHOR = "author";
    private float textSize = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        Intent intent = getIntent();
        String author = intent.getStringExtra(AUTHOR);
        String txtBooks = "";
        for(Book b: Book.getBooks(author)){
           txtBooks+=b.getNameBook() + "\n";
        }
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(txtBooks);
        textSize = textView.getTextSize();
        if(savedInstanceState != null){
            textSize = savedInstanceState.getFloat("textSize");
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        }
    }

    public void onSendBtnClick(View view){
        TextView textView = (TextView) findViewById(R.id.text);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, "Список Книг");
        startActivity(intent);
    }
    public  void onBtnPlusClick(View view){
        textSize *= 1.1f;
        TextView textView =findViewById(R.id.text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }
    public  void onBtnMinusClick(View view){
        textSize /= 1.1f;
        TextView textView = findViewById(R.id.text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat("textSize", textSize);
    }
}