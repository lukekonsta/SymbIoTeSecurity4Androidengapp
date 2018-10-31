package symbiote.h2020.eu.sampleapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Hzagreb extends AppCompatActivity {


    TextView setTitle;
    Button one,two,three;

    int totalpm25 = 0;
    int totalpm10 = 0;
    int totalnitrogen = 0;
    int totalozone = 0;
    int totalsulphur = 0;

    SharedPreferences sharedPrefs;
    Gson gson = new Gson();

    private BarChart chart;
    float barWidth;
    float barSpace;
    float groupSpace;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Hzagreb.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hzagreb);


        barWidth = 0.7f;
        barSpace = 0.8f;
        groupSpace = 0.8f;

        setTitle = (TextView)findViewById(R.id.showTitle);


        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
        SimpleDateFormat format1 = new SimpleDateFormat("dd");
        c.add(Calendar.DATE, -i - 7);
        Date start = c.getTime();
        String formatted = format1.format(start.getTime());

        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        c.add(Calendar.DATE, 6);
        Date end = c.getTime();
        String formatted2 = format2.format(end.getTime());
        System.out.println(formatted + " - " + formatted2);

        setTitle.setText("Σύγκριση Δεδομένων για: \n" +formatted + " - "+formatted2);


        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(Hzagreb.this);
        Type type = new TypeToken<List<String>>() {
        }.getType();


        String json12 = sharedPrefs.getString("array_zagreb_pm25", "");
        List<String> arrayList12 = gson.fromJson(json12, type);


        for(int counter = 0;counter<arrayList12.size();counter++){

            String value = arrayList12.get(counter);
            if(value.contains(",")){
                value = value.replace(",", ".");
            }
            float final_float = Float.valueOf(value);
            String val = String.format("%.2f", final_float);
            if(val.contains(",")){
                val = value.replace(",", ".");
            }
            float final_float_total = Float.valueOf(val);
            totalpm25+=final_float_total;

        }

        System.out.println("Length is: "+totalpm25);


        String json13 = sharedPrefs.getString("array_zagreb_pm10", "");
        List<String> arrayList13 = gson.fromJson(json13, type);

        for(int counter = 0;counter<arrayList13.size();counter++){

            String value = arrayList13.get(counter);
            if(value.contains(",")){
                value = value.replace(",", ".");
            }
            float final_float = Float.valueOf(value);
            String val = String.format("%.2f", final_float);
            if(val.contains(",")){
                val = value.replace(",", ".");
            }
            float final_float_total = Float.valueOf(val);
            totalpm10+=final_float_total;

        }


        String json14 = sharedPrefs.getString("array_zagreb_nitrogen", "");
        List<String> arrayList14 = gson.fromJson(json14, type);

        for(int counter = 0;counter<arrayList14.size();counter++){

            String value = arrayList14.get(counter);
            if(value.contains(",")){
                value = value.replace(",", ".");
            }
            float final_float = Float.valueOf(value);
            String val = String.format("%.2f", final_float);
            if(val.contains(",")){
                val = value.replace(",", ".");
            }
            float final_float_total = Float.valueOf(val);
            totalnitrogen+=final_float_total;

        }

        String json15 = sharedPrefs.getString("array_zagreb_ozone", "");
        List<String> arrayList15 = gson.fromJson(json15, type);

        for(int counter = 0;counter<arrayList15.size();counter++){

            String value = arrayList15.get(counter);
            if(value.contains(",")){
                value = value.replace(",", ".");
            }
            float final_float = Float.valueOf(value);
            String val = String.format("%.2f", final_float);
            if(val.contains(",")){
                val = value.replace(",", ".");
            }
            float final_float_total = Float.valueOf(val);
            totalozone+=final_float_total;

        }

        String json16 = sharedPrefs.getString("array_zagreb_sulphur", "");
        List<String> arrayList16 = gson.fromJson(json16, type);

        for(int counter = 0;counter<arrayList16.size();counter++){

            String value = arrayList16.get(counter);
            if(value.contains(",")){
                value = value.replace(",", ".");
            }
            float final_float = Float.valueOf(value);
            String val = String.format("%.2f", final_float);
            if(val.contains(",")){
                val = value.replace(",", ".");
            }
            float final_float_total = Float.valueOf(val);
            totalsulphur+=final_float_total;

        }


        float value1 = totalnitrogen/arrayList14.size();
        float value2 = totalpm10/arrayList13.size();
        float value3 = totalpm25/arrayList12.size();
        float value4 = totalozone/arrayList15.size();
        float value5 = totalsulphur/arrayList16.size();

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
        System.out.println(value4);
        System.out.println(value5);

        chart = (BarChart)findViewById(R.id.barChart);
        chart.setDescription(null);
        chart.setPinchZoom(true);
        chart.setScaleEnabled(true);
        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);

        int groupCount = 8;

        ArrayList xVals = new ArrayList();

        //xVals.add("Jan");

        ArrayList yVals1 = new ArrayList();
        ArrayList yVals2 = new ArrayList();
        ArrayList yVals3 = new ArrayList();
        ArrayList yVals4 = new ArrayList();
        ArrayList yVals5 = new ArrayList();

        yVals1.add(new BarEntry(1, value1));
        yVals2.add(new BarEntry(2, value2));
        yVals3.add(new BarEntry(3, value3));
        yVals4.add(new BarEntry(4, value4));
        yVals5.add(new BarEntry(5, value5));

        BarDataSet set1, set2, set3, set4, set5;
        set1 = new BarDataSet(yVals1, "NO2");
        set1.setColor(Color.RED);
        set1.setValueTextSize(12f);
        set2 = new BarDataSet(yVals2, "PM10");
        set2.setColor(Color.BLUE);
        set2.setValueTextSize(12f);
        set3 = new BarDataSet(yVals3, "PM2.5");
        set3.setColor(Color.GREEN);
        set3.setValueTextSize(12f);
        set4 = new BarDataSet(yVals4, "03");
        set4.setColor(Color.YELLOW);
        set4.setValueTextSize(12f);
        set5 = new BarDataSet(yVals5, "S02");
        set5.setColor(Color.MAGENTA);
        set5.setValueTextSize(12f);
        BarData data = new BarData(set1, set2, set3, set4, set5);
        //data.setValueFormatter(new LargeValueFormatter());
        chart.setData(data);
        chart.getBarData().setBarWidth(barWidth);
        chart.getXAxis().setAxisMinimum(0);
        chart.getXAxis().setAxisMaximum(0 + chart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount);
        chart.groupBars(0, groupSpace, barSpace);
        chart.getData().setHighlightEnabled(false);
        chart.invalidate();

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(true);
        l.setYOffset(20f);
        l.setXOffset(0f);
        l.setYEntrySpace(0f);
        l.setTextSize(11f);

        //X-axis
        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMaximum(8);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(11f);
        //xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));
//Y-axis
        chart.getAxisRight().setEnabled(false);
        YAxis leftAxis = chart.getAxisLeft();
        //leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(true);
        leftAxis.setSpaceTop(35f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setTextSize(11f);

        one = (Button)findViewById(R.id.pm25);
        two = (Button)findViewById(R.id.pm10);
        three = (Button)findViewById(R.id.no2);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hzagreb.this, Historical.class));
            }
        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hzagreb.this, HVienna.class));
            }
        });









    }
}
