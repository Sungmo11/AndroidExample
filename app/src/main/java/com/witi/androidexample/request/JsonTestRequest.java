package com.witi.androidexample.request;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.lang.reflect.Method;

public class JsonTestRequest extends JsonObjectRequest {

    // 서버 URL 설정
    final static private String URL = "http://ec2-15-165-108-138.ap-northeast-2.compute.amazonaws.com:8080/test/jsonTest";

    public JsonTestRequest(@Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener)
    {
        super(Method.POST, URL, jsonRequest, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error : ", error.getMessage());
            }
        });
    }

}

