package com.monashfriendfinder.movie;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.monashfriendfinder.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Response;

public class favoriteMovie extends AppCompatActivity {

    private static final String TAG = "favoriteMovie";
    private ImageView image_view;
    private Handler handler;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_movie);
        image_view = (ImageView) findViewById(R.id.image_view);
        textView = (TextView) findViewById(R.id.movie_txt);
        button = (Button) findViewById(R.id.send_request);
        handler = new Handler();
        Intent intent = getIntent();

        String nameString = intent.getStringExtra("movieName");
        String google_custom_url = "https://www.googleapis.com/customsearch/v1?cx=012911562221266154636:cebsvzwde8e&key=AIzaSyAWUKt76C3y-hIbQePbAX1OqsdjYTnR8FI&q=" ;
        google_custom_url = google_custom_url + nameString;
        Log.d(TAG,nameString+"bacda") ;

        HttpUtil.sendOkHttpRequest(google_custom_url , new okhttp3.Callback() {
            @Override
            public void onResponse (Call call , Response response) throws IOException {
                String responseData = response.body().string();
                Log.d(TAG,responseData);
                parseJsonWithGson(responseData);
            }
            public void onFailure(Call call , IOException e){
                e.printStackTrace();
            }
        });
    }

    private void parseJsonWithGson(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            String items = jsonObject.getString("items") ;
            JSONArray jsonArray = new JSONArray(items);
            String link = jsonArray.getJSONObject(0).getString("link") ;
            Log.d(TAG, link);
            Pattern pattern =  Pattern.compile("[0-9]+");
            Matcher m = pattern.matcher(link);
            m.find();
            String Id = m.group(0);
            if(m.find()){
                Log.d(TAG, m.group(0)) ;
            }
            String _movie_url = "https://api.douban.com/v2/movie/subject/" ;
            String movie_url = _movie_url + Id ;
            descriptionParseJson(movie_url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void descriptionParseJson(String url) {
        HttpUtil.sendOkHttpRequest(url , new okhttp3.Callback() {
            @Override
            public void onResponse (Call call , Response response) throws IOException {
                String responseData = response.body().string();
                Log.d(TAG,responseData);
                try {
                    JSONObject jsonObject = new JSONObject(responseData);
                    final String items = jsonObject.getString("summary");
                    Log.d(TAG, items) ;
                    handler.post(new Runnable() {//主线程更新UI
                        @Override
                        public void run() {
                            textView.setText(items);
                            button.setText("The Shawshank Redemption");
                        }
                    });

                    JSONObject jsonArray = jsonObject.getJSONObject("images") ;
                    String small_images_url = jsonArray.getString("small");
                    Log.d(TAG, small_images_url);
                    getImage(small_images_url, "movie_name");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            public void onFailure(Call call , IOException e){
                e.printStackTrace();
            }
        });
    }
    private void getImage(String url, final String title) {
        HttpUtil.sendOkHttpRequest(url , new okhttp3.Callback() {
            @Override
            public void onResponse (Call call , Response response) throws IOException {
                byte[] bytes = response.body().bytes();
                final Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0 , bytes.length);
                handler.post(new Runnable() {//主线程更新UI
                    @Override
                    public void run() {
                        image_view.setImageBitmap(bitmap);
                    }
                });
            }
            public void onFailure(Call call , IOException e){
                e.printStackTrace();
            }
        });
    }
}
