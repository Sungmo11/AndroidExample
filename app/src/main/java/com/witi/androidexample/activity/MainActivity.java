package com.witi.androidexample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.witi.androidexample.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String url ="http://ec2-15-165-108-138.ap-northeast-2.compute.amazonaws.com:8080/test/string";
    // Instantiate the RequestQueue.
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

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

        switch (item.getItemId())
        {
            case R.id.stringMenu :
                toast.setText("Select stringMenu");
                toast.show();
                break;
            case R.id.jsonMenu :
                Intent intent = new Intent(MainActivity.this, JsonTestActivity.class);
                startActivity(intent);
                break;
            case R.id.popupMenu:
                intent = new Intent(MainActivity.this, PopupTestActivity.class);
                startActivity(intent);
                break;
            case R.id.timerMenu:
                intent = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(intent);
                break;
            case R.id.timerThreadMenu:
                intent = new Intent(MainActivity.this, TimerThreadActivity.class);
                startActivity(intent);
                break;
            case R.id.fragmentMenu:
                intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.scrollView:
                intent = new Intent(MainActivity.this, ScrollViewActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void testBtn(View view) {
        switch (view.getId())
        {
            case R.id.volleyBtn:
                queue = Volley.newRequestQueue(MainActivity.this);
                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                textView.setText(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("That didn't work!");
                    }
                });

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
                break;

            case R.id.backBtn:
                textView.setText("Hello world!");
                break;
        }
    }
}
