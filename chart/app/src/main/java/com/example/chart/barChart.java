package com.example.chart;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class barChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barchart);

        BarChart barChart = (BarChart) findViewById(R.id.barchart);


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("2016");
        labels.add("2015");
        labels.add("2014");
        labels.add("2013");
        labels.add("2012");
        labels.add("2011");

        ArrayList<BarEntry> bargroup1 = new ArrayList<>();

        bargroup1.add(new BarEntry(1f, 0.0f));
        bargroup1.add(new BarEntry(2f, 0.1f));
        bargroup1.add(new BarEntry(3f, 0.4f));
        bargroup1.add(new BarEntry(4f, 0.3f));
        bargroup1.add(new BarEntry(5f, 0.2f));
        bargroup1.add(new BarEntry(6f, 0.5f));

        XAxis xl = barChart.getXAxis();
//        xl.setGranularity(1f);
        xl.setCenterAxisLabels(true);
//        barDataSet.setDrawValues(true);
        Description description = new Description();

        BarDataSet barDataSet1 = new BarDataSet(bargroup1,"");
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        BarData data = new BarData(dataSets) ;
        barChart.setData(data); // set the data and list of labels into chart
        description.setText("Student Location Frequency" +
                "\nSEU-Monash");
        barChart.setDescription(description);

    }
}
