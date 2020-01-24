package com.witi.androidexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.witi.androidexample.R;
import com.witi.androidexample.model.JsonTest;
import com.witi.androidexample.request.JsonTestRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonTestActivity extends AppCompatActivity {

    private TextView textView;
    private EditText et_user, et_name, et_pw;
    final static private String URL = "http://ec2-15-165-108-138.ap-northeast-2.compute.amazonaws.com:8080/test/jsonTest";
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    // 액티비티 시작시 처음으로 시행되는 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_test);

        textView = findViewById(R.id.textView);
        et_user = findViewById(R.id.et_user);
        et_name = findViewById(R.id.et_name);
        et_pw = findViewById(R.id.et_pw);
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

        Intent intent;

        switch (item.getItemId())
        {
            case R.id.stringMenu :
                intent = new Intent(JsonTestActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.jsonMenu :
                toast.setText("Select jsonMenu");
                toast.show();
                break;
            case R.id.popupMenu:
                intent = new Intent(JsonTestActivity.this, PopupTestActivity.class);
                startActivity(intent);
                break;
            case R.id.timerMenu:
                intent = new Intent(JsonTestActivity.this, TimerActivity.class);
                startActivity(intent);
                break;
            case R.id.timerThreadMenu:
                intent = new Intent(JsonTestActivity.this, TimerThreadActivity.class);
                startActivity(intent);
                break;
            case R.id.fragmentMenu:
                intent = new Intent(JsonTestActivity.this, FragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.scrollView:
                intent = new Intent(JsonTestActivity.this, ScrollViewActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void testBtn(View view) {
        switch (view.getId()) {
            case R.id.volleyBtn:

                Map<String,String> map = new HashMap<>();
                map.put("user", et_user.getText().toString());
                map.put("name", et_name.getText().toString());
                map.put("pw", et_pw.getText().toString());

                JSONObject parameters = new JSONObject(map);

                Response.Listener<JSONObject> responseListenner = new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JsonTest jsonTest = JsonTest.builder().user(response.getInt("user")).name(response.getString("name")).pw(response.getString("pw")).build();
                            Log.e("user : ", String.valueOf(response.getInt("user")));
                            Log.e("name : ", response.getString("name"));
                            Log.e("pw : ", response.getString("pw"));

                            String str = "user : " + jsonTest.getUser() + ", name : " + jsonTest.getName() + ", pw : " + jsonTest.getPw();
                            textView.setText(str);
                        } catch (JSONException e) {
                            Log.e("Error", e.getMessage());
                        }
                    }
                };

                JsonTestRequest jsonTestRequest = new JsonTestRequest(parameters, responseListenner);
                requestQueue = Volley.newRequestQueue(JsonTestActivity.this);
                requestQueue.add(jsonTestRequest);


                /*
                Map<String, String> parametros = new HashMap<>();
                parametros.put("user", et_user.getText().toString());
                parametros.put("name", et_name.getText().toString());
                parametros.put("pw", et_pw.getText().toString());
                requestQueue = Volley.newRequestQueue(JsonTestActivity.this);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, new JSONObject(parametros)
                        , new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
//                            Toast.makeText(getApplicationContext(), "user : " + response.optString("user"), Toast.LENGTH_LONG).show();
                            textView.setText("user : " + response.optString("user") + "name : " + response.optString("name"));
                            Log.e("user : " , response.optString("user"));
                            Log.e("name : " , response.optString("name"));
                            Log.e("pw : " , response.optString("pw"));
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        if(error != null)
                        {
                            Log.e("Error : ", error.getMessage());
                        }
                        else
                        {
                            Log.e("Error : ", "error == null");
                        }
                    }
                });

                requestQueue.add(jsonObjectRequest);
                */

                break;

            case R.id.backBtn:
                textView.setText("Hello world!");
                break;
        }
    }
}
