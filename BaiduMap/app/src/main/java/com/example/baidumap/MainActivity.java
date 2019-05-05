package com.example.baidumap;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private MapView mMapView = null;

    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;
    private InfoWindow mInfoWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SDKInitializer.initialize(getApplicationContext());

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
//        SDKInitializer.setCoordType(CoordType.BD09LL);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();

        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        // 定位图层
        mBaiduMap.setMyLocationEnabled(true);

        // 定位初始化
        initLocation();
        mLocationClient.start();
        initMaker();
    }
    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理

    }
    @Override
    protected void onPause() {
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
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
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mMapView == null){
                return;
            }
            MyLocationConfiguration myLocationConfiguration = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING,
                    false,
                    BitmapDescriptorFactory.fromResource(R.drawable.icon_openmap_mark),
                    0xAAFFFFFF, 0xAA00FFFF
            );

            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationConfiguration(myLocationConfiguration);
            mBaiduMap.setMyLocationData(locData);
        }
    }

    public void initLocation(){

        //定位初始化
        mLocationClient = new LocationClient(this);

        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

        //设置locationClientOption
        mLocationClient.setLocOption(option);

        //注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);

        //开启地图定位图层


    }

    public void initMaker() {
        //定义Maker坐标点
        List<OverlayOptions> options = new ArrayList<OverlayOptions>();
/*
*   地图上展示对应的friends location
*   点击后，展示其对应简单的描述信息
* */
       /* for (int i = 0; i < friendlist.length; ++i) {
            String info = friendlist[i].info();
            final LatLng point = new LatLng(friendlist[i].lat, friendlist[i].log) ;
            OverlayOptions option = new MarkerOptions()
                    .position(point)
                    .icon(bitmap)
                    .title(info);
        }*/


        final LatLng point = new LatLng(31.2990, 120.5853);
        //构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.icon_openmap_focuse_mark);
        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap).title("test1");
        //在地图上添加Marker，并显示

        final LatLng point1 = new LatLng(35.000, 121.000);
        OverlayOptions option1 = new MarkerOptions()
                .position(point1)
                .icon(bitmap).title("test2");

        options.add(option);
        options.add(option1);
        mBaiduMap.addOverlays(options);

        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            //marker被点击时回调的方法
            //若响应点击事件，返回true，否则返回false
            //默认返回false
            @Override
            public boolean onMarkerClick(Marker marker) {
                //用来构造InfoWindow的Button
                Button button = new Button(getApplicationContext());
                button.setBackgroundResource(R.drawable.popup);
                button.setText(marker.getTitle());

                //构造InfoWindow
                //描述的位置点
                //-100 InfoWindow相对于point在y轴的偏移量
                mInfoWindow = new InfoWindow(button, marker.getPosition(), -120);

                //使InfoWindow生效
                mBaiduMap.showInfoWindow(mInfoWindow);
                return false;
            }
        });

    }


}