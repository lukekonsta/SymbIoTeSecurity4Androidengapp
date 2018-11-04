package symbiote.h2020.eu.sampleapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class PM102 extends AppCompatActivity {

    Button one,two,three, five;
    private BarChart chart;
    float barWidth;
    float barSpace;
    float groupSpace;
    TextView setTitle, description;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(PM102.this, Weeks.class));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.icon_frame:
                Intent i = new Intent(PM102.this,Colors.class);
                startActivity(i);
                return true;
            default:
                Intent ii = new Intent(PM102.this,Colors.class);
                startActivity(ii);
                return true;
            //return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm102);


        barWidth = 0.5f;
        barSpace = 0.5f;
        groupSpace = 0.8f;


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
        ArrayList yVals6 = new ArrayList();

        yVals1.add(new BarEntry(1, 23));
        yVals2.add(new BarEntry(2, 12));
        yVals3.add(new BarEntry(3, 19));
        yVals4.add(new BarEntry(4, 10));
        yVals5.add(new BarEntry(5, 22));
        yVals6.add(new BarEntry(6, 10));

        String vienna = getResources().getString(R.string.Vienna);
        String zagreb = getResources().getString(R.string.Zagreb);
        String limassol = getResources().getString(R.string.Limassol);

        BarDataSet set1, set2, set3, set4, set5, set6;
        set1 = new BarDataSet(yVals1, vienna);
        set1.setColor(Color.BLUE);
        set1.setValueTextSize(12f);
        set2 = new BarDataSet(yVals2, "");
        set2.setColor(Color.BLUE);
        set2.setValueTextSize(12f);
        set3 = new BarDataSet(yVals3, zagreb);
        set3.setColor(Color.GREEN);
        set3.setValueTextSize(12f);
        set4 = new BarDataSet(yVals4, "");
        set4.setColor(Color.GREEN);
        set4.setValueTextSize(12f);
        set5 = new BarDataSet(yVals5, limassol);
        set5.setColor(Color.MAGENTA);
        set5.setValueTextSize(12f);
        set6 = new BarDataSet(yVals6, "");
        set6.setColor(Color.MAGENTA);
        set6.setValueTextSize(12f);
        BarData data = new BarData(set1, set2, set3, set4, set5, set6);
        data.setValueFormatter(new IntValueFormatter());
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
        final ArrayList<String> xAxisLabel = new ArrayList<>();
        String highV = getResources().getString(R.string.highV);
        String lowwV = getResources().getString(R.string.lowV);
        xAxisLabel.add(highV);
        xAxisLabel.add(lowwV);
        //xAxisLabel.add("");
        xAxisLabel.add(highV);
        //xAxisLabel.add("");
        xAxisLabel.add(lowwV);
        //xAxisLabel.add("");
        xAxisLabel.add(highV);
        //xAxisLabel.add("");
        xAxisLabel.add(lowwV);
        //XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if(value>=0){
                    if (value <= xAxisLabel.size() - 1){
                        return (String) xAxisLabel.get((int) value);
                    }return "";
                }return "";
            }
        });
//Y-axis
        chart.getAxisRight().setEnabled(false);
        YAxis leftAxis = chart.getAxisLeft();
        //leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(true);
        leftAxis.setSpaceTop(35f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setTextSize(11f);



        one = (Button)findViewById(R.id.pm25);
        two = (Button)findViewById(R.id.no2);
        three = (Button)findViewById(R.id.o3);
        five = (Button)findViewById(R.id.so2);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PM102.this, PM252.class));
            }
        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PM102.this, NO22.class));
            }
        });


        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PM102.this, Sulphur2.class));
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PM102.this, O32.class));
            }
        });

        description = (TextView)findViewById(R.id.desc);
        String txt = getResources().getString(R.string.highlow);
        description.setText((Html.fromHtml(txt)));






    }
}
