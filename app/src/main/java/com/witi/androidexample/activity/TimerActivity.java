package com.witi.androidexample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import com.witi.androidexample.R;

public class TimerActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private Button startBtn, resetBtn, pauseBtn;
    private long stopTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronometer = findViewById(R.id.chronometer);
        startBtn = findViewById(R.id.startBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        resetBtn = findViewById(R.id.resetBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime() + stopTime);
                chronometer.start();
                startBtn.setVisibility(View.GONE);
                pauseBtn.setVisibility(View.VISIBLE);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTime = chronometer.getBase() - SystemClock.elapsedRealtime();
                chronometer.stop();
                startBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.GONE);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                stopTime = 0;
                chronometer.stop();
                startBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.GONE);
            }
        });
    }

//  옵션 메뉴추가 start----------------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pagingmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
        Intent intent;

        switch (item.getItemId())
        {
            case R.id.stringMenu :
                intent = new Intent(TimerActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.jsonMenu :
                intent = new Intent(TimerActivity.this, JsonTestActivity.class);
                startActivity(intent);
                break;
            case R.id.popupMenu:
                intent = new Intent(TimerActivity.this, PopupTestActivity.class);
                startActivity(intent);
                break;
            case R.id.timerMenu:
                toast.setText("Select timerMenu");
                toast.show();
                break;
            case R.id.timerThreadMenu:
                intent = new Intent(TimerActivity.this, TimerThreadActivity.class);
                startActivity(intent);
                break;
            case R.id.fragmentMenu:
                intent = new Intent(TimerActivity.this, FragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.scrollView:
                intent = new Intent(TimerActivity.this, ScrollViewActivity.class);
                startActivity(intent);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
//  옵션 메뉴추가 stop----------------------------------------------------------------------------------------
}
