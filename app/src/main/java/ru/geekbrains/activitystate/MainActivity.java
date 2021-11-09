package ru.geekbrains.activitystate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int counter1 = 0;
    private TextView textCounter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCounter1 = findViewById(R.id.textView1);
    }

    public void button1_onClick(View view) {
        counter1++;
        textCounter1.setText(String.format(Locale.getDefault(), "%d", counter1));
    }
}