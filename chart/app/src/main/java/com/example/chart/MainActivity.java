package com.example.chart;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PieChart pieChart = (PieChart) findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.setDrawHoleEnabled(false);

        /*
        *
        * List<PieEntry> entries = new ArrayList<>();
        * favourite_units = new favorite_units[]
        * map<String, init> M;
        * for (int i = 0; i < user.length; ++i) {
        *    favorite_units =  user[i].favorite_units;
        *    M[favorite_units] = M[favorite_units] + 1;
        * }
        *
        * for Iterator M.key() : Unit_Name {
        *    double proportion[i] = M[Unit_Name] / The_number_of_user_counts ;
        *    entries.add(new PieEntry(proportion, Unit_Name));
        * }
        * */
        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(18.5f, "FIT5183"));
        entries.add(new PieEntry(26.7f, "FIT5186"));
        entries.add(new PieEntry(24.0f, "FIT5187"));
        entries.add(new PieEntry(30.8f, "FIT5190"));
        PieDataSet set = new PieDataSet(entries, "Favorite Units");
        set.setValueTextSize(15f);
        pieChart.setEntryLabelTextSize(20f);
        pieChart.setEntryLabelColor(ColorTemplate.rgb("000000"));
        PieData data = new PieData(set);
        pieChart.setData(data);
        data.setValueFormatter(new PercentFormatter());
        Description description = new Description();
        description.setText("SEU-MONASH      ");
        pieChart.setDescription(description);
        pieChart.invalidate(); // refresh
        set.setColors(ColorTemplate.VORDIPLOM_COLORS);


        Intent i = new Intent();
        i.setClass(MainActivity.this,barChart.class);
        startActivity(i);
        Button button1 = (Button) findViewById(R.id.barChart);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"you clickd google maps button",
                        Toast.LENGTH_SHORT).show();
                Intent intent =  new Intent(MainActivity.this, barChart.class);
                startActivity(intent);
            }
        });
        handler = new Handler();

/*
*
*
*
*
* */
    }
}
