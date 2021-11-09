package ru.geekbrains.activitystate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Counters counters;

    private TextView textCounter1;
    private TextView textCounter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counters = new Counters();
        initViews();
    }

    private void initViews() {
        textCounter1 = findViewById(R.id.textView1);
        textCounter2 = findViewById(R.id.textView2);
        initButton2ClickListener();
    }

    private void initButton2ClickListener() {
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counters.incrementCounter2();
                setTextCounter(textCounter2, counters.getCounter2());
            }
        });
    }

    public void button1_onClick(View view) {
        counters.incrementCounter1();
        setTextCounter(textCounter1, counters.getCounter1());
    }

    private void setTextCounter(TextView textCounter1, int counter1) {
        textCounter1.setText(String.format(Locale.getDefault(), "%d", counter1));
    }
}