package com.monashfriendfinder.baiduMap;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.monashfriendfinder.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapActivity extends Activity {
    private MapView mMapView = null;
    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;
    private InfoWindow mInfoWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SDKInitializer.initialize(getApplicationContext());

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_map);
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mBaiduMap.setMyLocationEnabled(true);
        initLocation();
        mLocationClient.start();
        initMaker();
    }
    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();
    }
    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();

    }
    @Override
    protected void onDestroy() {
        mLocationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location == null || mMapView == null){
                return;
            }
            MyLocationConfiguration myLocationConfiguration = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.COMPASS,
                    false,
                    BitmapDescriptorFactory.fromResource(R.drawable.icon_openmap_mark),
                    0xAAFFFFFF, 0xAA00FFFF
            );

            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationConfiguration(myLocationConfiguration);
            mBaiduMap.setMyLocationData(locData);
        }
    }

    public void initLocation(){
        mLocationClient = new LocationClient(this);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        mLocationClient.setLocOption(option);
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
    }

    public void initMaker() {
        Intent intent = getIntent();
        String nameString = intent.getStringExtra("request");

        if (nameString.equals("friendlist")){
            List<OverlayOptions> options = new ArrayList<OverlayOptions>();
            final LatLng point = new LatLng(31.2990, 120.5853);
            BitmapDescriptor bitmap = BitmapDescriptorFactory
                    .fromResource(R.drawable.icon_openmap_focuse_mark);
            OverlayOptions option = new MarkerOptions()
                    .position(point)
                    .icon(bitmap).title("Name: Mike Steven Email: Mike@email");

            final LatLng point2 = new LatLng(30.2990, 120.5853);
            OverlayOptions option2 = new MarkerOptions()
                    .position(point2)
                    .icon(bitmap).title("Name: Mike Steven Email: Mike@email");

            final LatLng point1 = new LatLng(31.000, 120.200);
            OverlayOptions option1 = new MarkerOptions()
                    .position(point1)
                    .icon(bitmap).title("Name: Jarry Fisher Email: test@email");
            options.add(option);
            options.add(option1);
            options.add(option2);
            mBaiduMap.addOverlays(options);
        }
        else if (nameString.equals("match_friends_list")) {
            List<OverlayOptions> options = new ArrayList<OverlayOptions>();
            final LatLng point = new LatLng(30.2990, 120.5853);
            BitmapDescriptor bitmap = BitmapDescriptorFactory
                    .fromResource(R.drawable.icon_openmap_focuse_mark);
            OverlayOptions option = new MarkerOptions()
                    .position(point)
                    .icon(bitmap).title("Name: JJ Steven Email: Mike@email");

            final LatLng point2 = new LatLng(30.2990, 120.5853);
            OverlayOptions option2 = new MarkerOptions()
                    .position(point2)
                    .icon(bitmap).title("Name: GG Steven Email: Mike@email");

            final LatLng point1 = new LatLng(31.000, 120.200);
            OverlayOptions option1 = new MarkerOptions()
                    .position(point1)
                    .icon(bitmap).title("Name: EE Fisher Email: test@email");
            options.add(option);
            options.add(option1);
            options.add(option2);
            mBaiduMap.addOverlays(options);
        }

//        List<OverlayOptions> options = new ArrayList<OverlayOptions>();
//        final LatLng point = new LatLng(31.2990, 120.5853);
//        BitmapDescriptor bitmap = BitmapDescriptorFactory
//                .fromResource(R.drawable.icon_openmap_focuse_mark);
//        OverlayOptions option = new MarkerOptions()
//                .position(point)
//                .icon(bitmap).title("Name: Mike Steven Email: Mike@email");
//
//        final LatLng point2 = new LatLng(30.2990, 120.5853);
//        OverlayOptions option2 = new MarkerOptions()
//                .position(point2)
//                .icon(bitmap).title("Name: Mike Steven Email: Mike@email");
//
//        final LatLng point1 = new LatLng(31.000, 120.200);
//        OverlayOptions option1 = new MarkerOptions()
//                .position(point1)
//                .icon(bitmap).title("Name: Jarry Fisher Email: test@email");
//        options.add(option);
//        options.add(option1);
//        options.add(option2);
//        mBaiduMap.addOverlays(options);
        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            //marker被点击时回调的方法
            //若响应点击事件，返回true，否则返回false
            //默认返回false
            @Override
            public boolean onMarkerClick(Marker marker) {
                Button button = new Button(getApplicationContext());
                button.setBackgroundResource(R.drawable.popup);
                button.setText(marker.getTitle());
                mInfoWindow = new InfoWindow(button, marker.getPosition(), -120);
                mBaiduMap.showInfoWindow(mInfoWindow);
                return false;
            }
        });

    }


}