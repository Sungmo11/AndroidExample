package com.witi.androidexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.witi.androidexample.R;
import com.witi.androidexample.fragment.Fragment1;
import com.witi.androidexample.fragment.Fragment2;
import com.witi.androidexample.fragment.Fragment3;
import com.witi.androidexample.fragment.Fragment4;

public class FragmentActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.frame, fragment1);
                transaction.commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.frame, fragment2);
                transaction.commit();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment3 fragment3 = new Fragment3();
                transaction.replace(R.id.frame, fragment3);
                transaction.commit();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment4 fragment4 = new Fragment4();
                transaction.replace(R.id.frame, fragment4);
                transaction.commit();
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
                intent = new Intent(FragmentActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.jsonMenu :
                intent = new Intent(FragmentActivity.this, JsonTestActivity.class);
                startActivity(intent);
                break;
            case R.id.popupMenu:
                intent = new Intent(FragmentActivity.this, PopupTestActivity.class);
                startActivity(intent);
                break;
            case R.id.timerMenu:
                intent = new Intent(FragmentActivity.this, TimerActivity.class);
                startActivity(intent);
                break;
            case R.id.timerThreadMenu:
                intent = new Intent(FragmentActivity.this, TimerThreadActivity.class);
                startActivity(intent);
                break;
            case R.id.fragmentMenu:
                toast.setText("Select fragmentMenu");
                toast.show();
                break;
            case R.id.scrollView:
                intent = new Intent(FragmentActivity.this, ScrollViewActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
//  옵션 메뉴추가 stop----------------------------------------------------------------------------------------

}
