package com.example.assofandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import interfaces.heweather.com.interfacesmodule.bean.Code;
import interfaces.heweather.com.interfacesmodule.bean.Lang;
import interfaces.heweather.com.interfacesmodule.bean.Unit;
import interfaces.heweather.com.interfacesmodule.bean.basic.Basic;
import interfaces.heweather.com.interfacesmodule.bean.basic.Update;
import interfaces.heweather.com.interfacesmodule.bean.weather.now.Now;
import interfaces.heweather.com.interfacesmodule.bean.weather.now.NowBase;
import interfaces.heweather.com.interfacesmodule.view.HeConfig;
import interfaces.heweather.com.interfacesmodule.view.HeWeather;
import okhttp3.Call;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ImageView image_view;
    private Handler handler;

    String google_custom_url = "https://www.googleapis.com/customsearch/v1?cx=012911562221266154636:cebsvzwde8e&key=AIzaSyAWUKt76C3y-hIbQePbAX1OqsdjYTnR8FI&q=肖申克的救赎O" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_view = (ImageView) findViewById(R.id.image_view);
        handler = new Handler();
//        image_view.setImageResource(R.drawable.ic_launcher_foreground);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


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


    String Gcustom = "https://www.googleapis.com/customsearch/v1?cx=012911562221266154636:cebsvzwde8e&key=AIzaSyAWUKt76C3y-hIbQePbAX1OqsdjYTnR8FI&q=肖申克的救赎";

    String key = "AIzaSyAWUKt76C3y-hIbQePbAX1OqsdjYTnR8FI" ;

    String Id = "012911562221266154636:cebsvzwde8e" ;

/*
    weather api
 */
        HeConfig.init("HE1905011734111984", "24184d452c4f41afba17ade3c6d1dfe3");
        HeConfig.switchToFreeServerNode();


/**
 * 实况天气
 * 实况天气即为当前时间点的天气状况以及温湿风压等气象指数，具体包含的数据：体感温度、
 * 实测温度、天气状况、风力、风速、风向、相对湿度、大气压强、降水量、能见度等。
 *
 * @param context  上下文
 * @param location 地址详解
 * @param lang     多语言，默认为简体中文
 * @param unit     单位选择，公制（m）或英制（i），默认为公制单位
 * @param listener 网络访问回调接口
 *                 付费用户才能访问外国节点。。。
 */

        String stu_location = "auto_ip" ;
        HeWeather.getWeatherNow(MainActivity.this, stu_location , Lang.CHINESE_SIMPLIFIED , Unit.METRIC , new HeWeather.OnResultWeatherNowBeanListener() {
            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "Weather Now onError: ", e);
            }

            @Override
            public void onSuccess(Now dataObject) {
                Log.i(TAG, " Weather Now onSuccess: " + new Gson().toJson(dataObject));
                //先JJ判断返回的status是否正确，当status正确时获取数据，若status不正确，可查看status对应的Code值找到原因
                if ( Code.OK.getCode().equalsIgnoreCase(dataObject.getStatus()) ){
                    //此时返回数据
                    NowBase now = dataObject.getNow();
                    Basic basic = dataObject.getBasic();
                    Update update = dataObject.getUpdate();
//                    城市名：
                    String city_name = basic.getLocation();
//                    时间：
                    String loc = update.getLoc();
//                    气温：
                    String tmp = now.getTmp();
//                    相对湿度： 摄氏度
                    String Hum = now.getHum();
//                    云量：
                    String Cloud = now.getCloud();
//                    风速
                    String Wind_spd = now.getWind_spd();
//                    风向
                    String Wind_dir = now.getWind_dir();
//                    风力
                    String Wind_sc = now.getWind_sc();
//                    能见度
                    String vis = now.getVis();
//                    大气压强
                    String pres = now.getPres();
//                    降水量
                    String pcpn = now.getPcpn();
//                   打印logcat
                    Log.d(TAG, city_name+" "+ loc + " " + tmp);

                } else {
                    //在此查看返回数据失败的原因
                    String status = dataObject.getStatus();
                    Code code = Code.toEnum(status);
                    Log.i(TAG, "failed code: " + code);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

            Log.d(TAG, "ID: " + Id +  movie_url) ;

            descriptionParseJson(movie_url);
//            JSONObject jsonObject1  toString()) ;
//            String link = jsonObject1.getString("link") ;
//
//            Log.d(TAG, link);

//            String items = jsonArray.getJSONObject(0).getString("items");
//            Log.d(TAG, items) ;

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
//                parseJsonWithGson(responseData);
                try {
                    JSONObject jsonObject = new JSONObject(responseData);
                    String items = jsonObject.getString("summary");
                    Log.d(TAG, items) ;
                    JSONObject jsonArray = jsonObject.getJSONObject("images") ;
                    String small_images_url = jsonArray.getString("small");
                    Log.d(TAG, small_images_url);
                    getImage(small_images_url, "movie_name");
//                    jsonArray.getJSONObject()
//                    JSONArray jsonArray = new JSONArray(items);
//                    String link = jsonArray.getJSONObject(0).getString("link");
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

//                    String file_name = "/movies/";
//                    file_name = file_name + title;
//                    file_name = file_name + ".jpg" ;
//                    File file = new File(file_name) ;
//                    FileOutputStream out = new FileOutputStream(file);
//                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,out);
//                    out.flush();
//                    out.close();

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
