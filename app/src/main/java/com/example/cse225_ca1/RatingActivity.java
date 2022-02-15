package com.example.cse225_ca1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class RatingActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RatingBar ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        Button submitbutton = (Button) findViewById(R.id.submit_button);
        final TextView textviewtaingbar= (TextView) findViewById(R.id.ratingbar_display_textview);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textviewtaingbar.setText("Your rating is: "+ ratingBar.getRating());

            }
        });
    }
}
