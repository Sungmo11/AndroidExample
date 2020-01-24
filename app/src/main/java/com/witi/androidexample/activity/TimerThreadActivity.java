package com.witi.androidexample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.witi.androidexample.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimerThreadActivity extends AppCompatActivity {

    private TextView textView;
    private Button startBtn, resetBtn, pauseBtn, lapBtn;
    private long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L;
    Handler handler;
    int Hours, Seconds, Minutes, MilliSeconds;
    ListView listView;
    String[] ListElements = new String[]{};
    List<String> ListElementsArrayList;
    ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_thread);

        textView = findViewById(R.id.textView);
        startBtn = findViewById(R.id.startBtn);
        resetBtn = findViewById(R.id.resetBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        lapBtn = findViewById(R.id.saveLapBtn);
        listView = findViewById(R.id.listView);

        handler = new Handler();

        ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListElementsArrayList);

        listView.setAdapter(adapter);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);

                resetBtn.setEnabled(false);
                startBtn.setVisibility(View.GONE);
                pauseBtn.setVisibility(View.VISIBLE);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeBuff += MillisecondTime;
                handler.removeCallbacks(runnable);
                resetBtn.setEnabled(true);
                startBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.GONE);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MillisecondTime = 0L;
                StartTime = 0L;
                TimeBuff = 0L;
                UpdateTime = 0L;
                Hours = 0;
                Seconds = 0;
                Minutes = 0;
                MilliSeconds = 0;

                textView.setText("00:00:00:00");
                ListElementsArrayList.clear();
                adapter.notifyDataSetChanged();
            }
        });

        lapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListElementsArrayList.add(textView.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            MillisecondTime = SystemClock.uptimeMillis() - StartTime;
            UpdateTime = ((TimeBuff + MillisecondTime) * 1000);
//            Seconds = (int) (UpdateTime / 1000);
//            Minutes = (int) (UpdateTime / 60000);
            Hours = (int) ((UpdateTime / 1000) / 3600);
            Minutes = (int) ((UpdateTime / 60000) % 60);
            Seconds = (int) ((UpdateTime / 1000) % 60);
            MilliSeconds = (int) (UpdateTime % 1000);

            Log.e("UpdateTime : ", String.valueOf(UpdateTime));
//            Log.e("TimeBuff : ", String.valueOf(TimeBuff));
            textView.setText("" + String.format("%02d", Hours) + ":" + String.format("%02d", Minutes) + ":" + String.format("%02d", Seconds) + ":" + String.format("%03d", MilliSeconds));
            handler.postDelayed(this,0);
        }
    };

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
                intent = new Intent(TimerThreadActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.jsonMenu :
                intent = new Intent(TimerThreadActivity.this, JsonTestActivity.class);
                startActivity(intent);
                break;
            case R.id.popupMenu:
                intent = new Intent(TimerThreadActivity.this, PopupTestActivity.class);
                startActivity(intent);
                break;
            case R.id.timerMenu:
                intent = new Intent(TimerThreadActivity.this, TimerActivity.class);
                startActivity(intent);
                break;
            case R.id.timerThreadMenu:
                toast.setText("Select timerThreadMenu");
                toast.show();
                break;
            case R.id.fragmentMenu:
                intent = new Intent(TimerThreadActivity.this, FragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.scrollView:
                intent = new Intent(TimerThreadActivity.this, ScrollViewActivity.class);
                startActivity(intent);
                break;
        }

        handler.removeCallbacks(runnable);

        return super.onOptionsItemSelected(item);
    }
//  옵션 메뉴추가 stop----------------------------------------------------------------------------------------


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause : ", "돌입!!");
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop : ", "돌입!!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy : ", "돌입!!");
    }
}
