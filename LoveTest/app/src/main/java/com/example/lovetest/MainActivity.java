package com.example.lovetest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button start;
    private EditText boy_name, girl_name;
    private TextView percent, space;
    private ImageView img;
    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start);
        boy_name = (EditText) findViewById(R.id.boy_name);
        girl_name = (EditText) findViewById(R.id.girl_name);
        percent = (TextView) findViewById(R.id.percent);
        img = (ImageView) findViewById(R.id.img);
        space = (TextView) findViewById(R.id.space);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String girl = girl_name.getText().toString();
                String boy = boy_name.getText().toString();
                if (girl.matches("") && boy.matches("")) {
                    space.setVisibility(View.VISIBLE);
                    start.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.VISIBLE);
                    img.setImageResource(R.drawable.write);
                } else {
                    start.setVisibility(View.INVISIBLE);
                    Random r = new Random();
                    int r_num;
                    r_num = r.nextInt(100);
                    percent.setText(r_num + "%");
                    if(r_num >= 80){
                        img.setVisibility(View.VISIBLE);
                        img.setImageResource(R.drawable.eighty);
                    }else if(r_num >= 50){
                        img.setVisibility(View.VISIBLE);
                        img.setImageResource(R.drawable.fifty);
                    } else{
                        img.setVisibility(View.VISIBLE);
                        img.setImageResource(R.drawable.one);
                    }
                }
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setVisibility(View.VISIBLE);
                percent.setText("");
                img.setVisibility(View.INVISIBLE);
                space.setVisibility(View.INVISIBLE);
                girl_name.setText("");
                boy_name.setText("");
            }
        });
    }
}