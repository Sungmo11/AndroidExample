package com.witi.androidexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.witi.androidexample.R;

public class ScrollViewActivity extends AppCompatActivity {

    TextView tv_hori, tv_scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        tv_hori = findViewById(R.id.tv_hori);
        tv_scroll = findViewById(R.id.tv_scroll);
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
                intent = new Intent(ScrollViewActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.jsonMenu :
                intent = new Intent(ScrollViewActivity.this, JsonTestActivity.class);
                startActivity(intent);
                break;
            case R.id.popupMenu:
                intent = new Intent(ScrollViewActivity.this, PopupTestActivity.class);
                startActivity(intent);
                break;
            case R.id.timerMenu:
                intent = new Intent(ScrollViewActivity.this, TimerActivity.class);
                startActivity(intent);
                break;
            case R.id.timerThreadMenu:
                intent = new Intent(ScrollViewActivity.this, TimerThreadActivity.class);
                startActivity(intent);
                break;
            case R.id.fragmentMenu:
                intent = new Intent(ScrollViewActivity.this, FragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.scrollView:
                toast.setText("Select timerMenu");
                toast.show();
                break;

        }


        return super.onOptionsItemSelected(item);
    }

    // ScrollView Test
    public void testScroll(View view) {
        switch (view.getId()){
            case R.id.btn_scroll1:
                tv_scroll.setText("scroll1");
                break;
            case R.id.btn_scroll2:
                tv_scroll.setText("scroll2");
                break;
            case R.id.btn_scroll3:
                tv_scroll.setText("scroll3");
                break;
            case R.id.btn_scroll4:
                tv_scroll.setText("scroll4");
                break;
            case R.id.btn_scroll5:
                tv_scroll.setText("scroll5");
                break;
            case R.id.btn_scroll6:
                tv_scroll.setText("scroll6");
                break;
            case R.id.btn_scroll7:
                tv_scroll.setText("scroll7");
                break;
            case R.id.btn_scroll8:
                tv_scroll.setText("scroll8");
                break;
            case R.id.btn_scroll9:
                tv_scroll.setText("scroll9");
                break;
            case R.id.btn_scroll10:
                tv_scroll.setText("scroll10");
                break;
        }
    }

    // HorizontalScrollView Test
    public void testHori(View view) {
        switch (view.getId()){
            case R.id.btn_horiscroll1:
                tv_hori.setText("hori1");
                break;
            case R.id.btn_horiscroll2:
                tv_hori.setText("hori2");
                break;
            case R.id.btn_horiscroll3:
                tv_hori.setText("hori3");
                break;
            case R.id.btn_horiscroll4:
                tv_hori.setText("hori4");
                break;
            case R.id.btn_horiscroll5:
                tv_hori.setText("hori5");
                break;
            case R.id.btn_horiscroll6:
                tv_hori.setText("hori6");
                break;
            case R.id.btn_horiscroll7:
                tv_hori.setText("hori7");
                break;
            case R.id.btn_horiscroll8:
                tv_hori.setText("hori8");
                break;
            case R.id.btn_horiscroll9:
                tv_hori.setText("hori9");
                break;
            case R.id.btn_horiscroll10:
                tv_hori.setText("hori10");
                break;
        }
    }
//  옵션 메뉴추가 stop----------------------------------------------------------------------------------------

}
