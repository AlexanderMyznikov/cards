package rest;

import android.graphics.Bitmap;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import application.AppController;

/**
 * Created by Admin on 22.03.2015.
 */
public class CadsApi {



    public static void requestJsonObject(String _url , String _tag , final RestCallback callback){
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET , _url , null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                callback.onSuccess(response);
            }
        }
                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });

        AppController.getInstance().addToRequestQueue(mJsonObjectRequest,_tag);
    }

    public static void requesetJsonArray (String _url , String _tag , final RestCallback callback){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                _url,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                callback.onSuccess(response);
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        }
        );
        AppController.getInstance().addToRequestQueue(jsonArrayRequest,_tag);
    }

    public static void requestJsonObjectWithParams(String _url , String _tag , final HashMap<String,String> params,  final RestCallback callback){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST , _url,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };



        AppController.getInstance().addToRequestQueue(jsonObjectRequest,_tag);
    }

    public static void requestBitmap (String _url , final BitmapLoadListener callback){
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();

        imageLoader.get(_url , new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                Bitmap bitmap = response.getBitmap();
                callback.onSuccess(bitmap);

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
    }
}
