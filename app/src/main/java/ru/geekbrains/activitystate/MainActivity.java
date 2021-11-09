package ru.geekbrains.activitystate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Counters counters;

    private TextView textCounter1;
    private TextView textCounter2;
    private TextView textCounter3;
    private TextView textCounter4;

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
        textCounter3 = findViewById(R.id.textView3);
        textCounter4 = findViewById(R.id.textView4);
        initButton2ClickListener();
        initButton3ClickListener();
        initButton4ClickListener();
    }

    private void initButton2ClickListener() {
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(view -> {
            counters.incrementCounter2();
            setTextCounter(textCounter2, counters.getCounter2());
        });
    }

    private void initButton3ClickListener(){
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    private void initButton4ClickListener(){
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(button4ClickListener);
    }

    public void button1_onClick(View view) {
        counters.incrementCounter1();
        setTextCounter(textCounter1, counters.getCounter1());
    }

    private void setTextCounter(TextView textCounter1, int counter1) {
        textCounter1.setText(String.format(Locale.getDefault(), "%d", counter1));
    }

    @Override
    public void onClick(View view) {
        counters.incrementCounter3();
        setTextCounter(textCounter3, counters.getCounter3());
    }

    private final View.OnClickListener button4ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            counters.incrementCounter4();
            setTextCounter(textCounter4, counters.getCounter4());
        }
    };
}