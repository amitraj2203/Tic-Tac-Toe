package com.example.cse225_ca1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ProgressBarActivity extends AppCompatActivity {
    private ProgressBar mProgressBar;
    private TextView mLoadingText;

    private Toolbar toolbar;

    Button next;

    Button notificationbutton;

    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();


    //custom toast
    private Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_bar);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //custom toast
        button = (Button) findViewById(R.id.toastbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast();
            }
        });

        //next button(rating bar)
        next = findViewById(R.id.nextbutton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgressBarActivity.this, RatingActivity.class);
                ProgressBarActivity.this.startActivity(intent);
            }
        });

        //This code is for notification if android version is 8 or above
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        //notification button
        notificationbutton = (Button) findViewById(R.id.notificationbutton);
        notificationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //notification code goes here
                NotificationCompat.Builder builder = new NotificationCompat.Builder(ProgressBarActivity.this,"My Notification");
                builder.setContentTitle("Tic-Tac-Toe");
                builder.setContentText("You are in the game Tic-Tac-Toe");
                builder.setSmallIcon(R.drawable.ic_notifications);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(ProgressBarActivity.this);
                managerCompat.notify(1, builder.build());
            }
        });


        //progress bar
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        mLoadingText = (TextView) findViewById(R.id.LoadingCompleteTextView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoadingText.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();
    }

    //custom toast method
    public void showToast(){
        LayoutInflater inflator = getLayoutInflater();
        View layout = inflator.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));

        TextView toastText = layout.findViewById(R.id.toast_text);
        ImageView toastImage = layout.findViewById(R.id.toast_image);

        toastText.setText("Thank You For Playing");
        toastImage.setImageResource(R.drawable.ic_toasticon);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();
    }
    }

