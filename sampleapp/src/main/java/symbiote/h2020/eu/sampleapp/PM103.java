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

public class PM103 extends AppCompatActivity {

    Button one,two,three, five;
    private BarChart chart;
    float barWidth;
    float barSpace;
    float groupSpace;
    TextView setTitle, description;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(PM103.this, Weeks.class));
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
                Intent i = new Intent(PM103.this,Colors.class);
                startActivity(i);
                return true;
            default:
                Intent ii = new Intent(PM103.this,Colors.class);
                startActivity(ii);
                return true;
            //return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm103);


        barWidth = 0.7f;
        barSpace = 0.8f;
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

        yVals1.add(new BarEntry(1, 22));
        yVals2.add(new BarEntry(2, 9));
        yVals3.add(new BarEntry(3, 23));
        yVals4.add(new BarEntry(4, 6));

        BarDataSet set1, set2, set3, set4, set5;
        set1 = new BarDataSet(yVals1, "Βιέννη");
        set1.setColor(Color.BLUE);
        set1.setValueTextSize(12f);
        set2 = new BarDataSet(yVals2, "");
        set2.setColor(Color.BLUE);
        set2.setValueTextSize(12f);
        set3 = new BarDataSet(yVals3, "Ζάγκρεμπ");
        set3.setColor(Color.GREEN);
        set3.setValueTextSize(12f);
        set4 = new BarDataSet(yVals4, "");
        set4.setColor(Color.GREEN);
        set4.setValueTextSize(12f);
        BarData data = new BarData(set1, set2, set3, set4);
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
        xAxisLabel.add("Υ");
        xAxisLabel.add("");
        xAxisLabel.add("Χ");
        xAxisLabel.add("");
        xAxisLabel.add("Υ");
        xAxisLabel.add("");
        xAxisLabel.add("Χ");
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
                startActivity(new Intent(PM103.this, PM253.class));
            }
        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PM103.this, NO23.class));
            }
        });


        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PM103.this, Sulphur3.class));
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PM103.this, O33.class));
            }
        });

        description = (TextView)findViewById(R.id.desc);
        String txt = "&#8226;Υ: Υψηλότερη Τιμή<br>&#8226;Χ: Χαμηλότερη Τιμή";
        description.setText((Html.fromHtml(txt)));


    }
}
