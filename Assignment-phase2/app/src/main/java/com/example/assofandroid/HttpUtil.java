package com.example.assofandroid;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
/*    建议使用第二种调用方式
        HttpUtil.sendOkHttpRequest("http://www.badiu.com", new okhttp3.Callback(){

        @Override
            public void onResponse ( Call call , Response response) throws IOException {
                String responseData = response.body().string();
            }
            public void onFailure(Call call , IOException e){

            //
            }
         });

 */
public class HttpUtil {

    public static void sendHttpRequest(final String address , final HttpCallbackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder() ;
                    String line;
                    while ((line = reader.readLine()) != null ){
                        response.append(line);
                    }
                    if (listener != null){
                        listener.onFinish(response.toString());
                    }
                }catch (Exception e){
                    if (listener != null) {
                        listener.onError(e);
                    }
                }finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }

            }
        }).start();
    }

    public interface HttpCallbackListener {
        void onFinish(String response);
        void onError(Exception e);
    }

    public static void sendOkHttpRequest(String address , okhttp3.Callback callback ) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
