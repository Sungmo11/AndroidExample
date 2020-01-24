package com.witi.androidexample.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.witi.androidexample.R;

public class PopupTestActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button popupBtn1, popupBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_test);

        linearLayout = findViewById(R.id.activity_popup);

        popupBtn1 = findViewById(R.id.popupBtn1);
        popupBtn2 = findViewById(R.id.popupBtn2);

        // 컨텍스트메뉴를 등록한다.
        registerForContextMenu(popupBtn1);

//      버튼2(짧게누름) start--------------------------------------------------------------------------------------
        popupBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                PopupMenu popup = new PopupMenu(getApplicationContext(), v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.popupmenu, popup.getMenu());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    popup.setGravity(Gravity.RIGHT);
                }
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
                        switch (item.getItemId())
                        {
                            case R.id.menu1 :
                                toast.setText("하나");
                                break;
                            case R.id.menu2 :
                                toast.setText("둘");
                                break;
                            case R.id.menu3 :
                                toast.setText("셋");
                                break;
                        }
                        toast.show();
                        return true;
                    }
                });
            }
        });
//      버튼2(짧게누름) stop--------------------------------------------------------------------------------------
    }

//  옵션메뉴 start--------------------------------------------------------------------------------------
    // 메뉴를 선택하면 나타나는 메뉴를 옵션 메뉴하고 메서드 두개를 오버라이딩 하면된다
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // 메뉴를 만든다.
        getMenuInflater().inflate(R.menu.popupmenu, menu);
        menu.add(0, 4, 100, "메뉴 4");
        return super.onCreateOptionsMenu(menu);
    }

    // onPrepareOptionsMenu()는 선택적으로 만든다. 메뉴가 나타나기 전에 선행처리 할 내용을 적는다.
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        menu.getItem(1).setEnabled(false);  // 메뉴 클릭을 막는다.
//        return super.onPrepareOptionsMenu(menu);
//    }

    // 메뉴 선택시 처리 내용
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
        switch (item.getItemId())
        {
            case R.id.menu1 :
                toast.setText("첫 번째 메뉴 선택");
                break;
            case R.id.menu2 :
                toast.setText("두 번째 메뉴 선택");
                break;
            case R.id.menu3 :
                toast.setText("세 번째 메뉴 선택");
                break;
            case 4 :
                toast.setText("네 번째 메뉴 선택");
                break;
        }
        toast.show();
        return super.onOptionsItemSelected(item);
    }
//  옵션메뉴 stop--------------------------------------------------------------------------------------

//  버튼1(길게누름) start--------------------------------------------------------------------------------------
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.popupmenu, menu);
        menu.setHeaderTitle("타이틀");
        menu.add(0, 1, 100, "빨강");
        menu.add(0, 2, 100, "녹생");
        menu.add(0, 3, 100, "파랑");

        // Menu에 SubMenu 추가
        SubMenu subMenu = menu.addSubMenu("하우스과일");
        subMenu.add(1, 4, Menu.NONE, "방울토마토");
        subMenu.add(1, 5, Menu.NONE, "하우스딸기");
        subMenu.add(1, 6, Menu.NONE, "애호박");
    }

    // onCreateContextMenu()에 만든 메뉴들에 작업을 추가해준다.
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
        switch (item.getItemId())
        {
            case 1 :
                linearLayout.setBackgroundColor(Color.RED);
                break;
            case 2 :
                linearLayout.setBackgroundColor(Color.GREEN);
                break;
            case 3 :
                linearLayout.setBackgroundColor(Color.BLUE);
                break;
            case 4 :
                toast.setText("방울토마토");
                break;
            case 5 :
                toast.setText("하우스딸기");
                break;
            case 6 :
                toast.setText("애호박");
                break;
        }
        toast.show();
        return super.onContextItemSelected(item);
    }
//  버튼1(길게누름) stop--------------------------------------------------------------------------------------
}
