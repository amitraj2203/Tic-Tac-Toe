package com.example.cse225_ca1;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutGame extends AppCompatActivity {
    Button btnBack;
    private Toolbar toolbar;
    //private ProgressBar spinner;


    Button continuebutton;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_aboutgame);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        continuebutton =findViewById(R.id.continuebutton);
        continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutGame.this, ProgressBarActivity.class);
                AboutGame.this.startActivity(intent);
            }
        });
        //spinner = (ProgressBar)findViewById(R.id.progressBar1);

        //spinner.setVisibility(View.GONE);
        //spinner.setVisibility(View.VISIBLE);

        //btnBack=findViewById(R.id.btnBack);

//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onBackPressed();
//            }
//        });
    }
}


