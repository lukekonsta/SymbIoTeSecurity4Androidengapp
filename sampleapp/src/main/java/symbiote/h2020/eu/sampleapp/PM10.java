package symbiote.h2020.eu.sampleapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PM10 extends AppCompatActivity {

    Button one,two,three, four, five;
    TextView setTitle, description;

    ArrayList<Float> pm10Vienna = new ArrayList<Float>();
    ArrayList <Float> pm10Zagreb = new ArrayList<Float>();
    ArrayList <Float> pm10Limassol = new ArrayList<Float>();

    SharedPreferences sharedPrefs;
    Gson gson = new Gson();

    private BarChart chart;
    float barWidth;
    float barSpace;
    float groupSpace;

    float maxV =0;
    float minV =20;
    float maxZ =0;
    float minZ =20;
    float maxL =0;
    float minL =20;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(PM10.this, Charts.class));
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
                Intent i = new Intent(PM10.this,Colors.class);
                startActivity(i);
                return true;
            default:
                Intent ii = new Intent(PM10.this,Colors.class);
                startActivity(ii);
                return true;
            //return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm10);

        barWidth = 0.6f;
        barSpace = 0.5f;
        groupSpace = 0.4f;

        setTitle = (TextView)findViewById(R.id.showTitle);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, 0);
        calendar.add(Calendar.MINUTE, -40);
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        String formatted = format1.format(calendar.getTime());
        String dataComp = getResources().getString(R.string.dataComparisonfor);
        setTitle.setText(dataComp+"\n" +formatted);

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(PM10.this);
        Type type = new TypeToken<List<String>>() {
        }.getType();

        String json12 = sharedPrefs.getString("array_vienna_pm10", "");
        List<String> arrayList12 = gson.fromJson(json12, type);

        //for(int counter = 0;counter<arrayList12.size();counter++){
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
            pm10Vienna.add(final_float_total);

        }

        System.out.println("Length is: "+pm10Vienna.size());


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
            pm10Zagreb.add(final_float_total);

        }

        System.out.println("Length is: "+pm10Zagreb.size());



        String json14 = sharedPrefs.getString("array_limassol_pm10", "");
        List<String> arrayList14 = gson.fromJson(json14, type);


        System.out.println("Length is Limassol PM10: "+pm10Limassol.size());

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
            pm10Limassol.add(final_float_total);

        }

        System.out.println("Length is: "+pm10Limassol.size());




        float value2 = 0;
        float v=0;

        for(int c = 0;c<pm10Vienna.size();c++){

            v = pm10Vienna.get(c);
            if(v>maxV){
                maxV = v;
            }


        }
        value2 = maxV;




        float value3 = 0;
        float v3=0;

        for(int c = 0;c<pm10Zagreb.size();c++){

            v3 = pm10Zagreb.get(c);
            if(v3>maxZ){
                maxZ = v3;
            }


        }
        value3 = maxZ;



        float value4 = 0;
        float v4=0;

        for(int c = 0;c<pm10Vienna.size();c++){

            v4 = pm10Vienna.get(c);
            if(v4<minV){
                minV = v4;
            }


        }
        value4 = minV;


        float value5 = 0;
        float v5=0;

        for(int c = 0;c<pm10Zagreb.size();c++){

            v5 = pm10Zagreb.get(c);
            if(v5<minZ){
                minZ = v5;
            }


        }
        value5 = minZ;

        float value6 = 0;
        float v6=0;

        for(int c = 0;c<pm10Limassol.size();c++){

            v6 = pm10Limassol.get(c);
            if(v6>maxL){
                maxL = v6;
            }


        }
        value6 = maxL;



        float value7 = 0;
        float v7=0;

        for(int c = 0;c<pm10Limassol.size();c++){

            v7 = pm10Limassol.get(c);
            if(v7<minL){
                minL = v7;
            }


        }
        value7 = minL-1;






        System.out.println("Final Values");
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

        int groupCount = 7;

        ArrayList xVals = new ArrayList();

        //xVals.add("Jan");

        //ArrayList yVals1 = new ArrayList();
        ArrayList yVals2 = new ArrayList();
        ArrayList yVals3 = new ArrayList();
        ArrayList yVals4 = new ArrayList();
        ArrayList yVals5 = new ArrayList();
        ArrayList yVals6 = new ArrayList();
        ArrayList yVals7 = new ArrayList();

        //yVals1.add(new BarEntry(1, value1));
        yVals2.add(new BarEntry(1, value2));
        yVals3.add(new BarEntry(2, value4));
        yVals4.add(new BarEntry(3, value3));
        yVals5.add(new BarEntry(4, value5));
        yVals6.add(new BarEntry(5, value6));
        yVals7.add(new BarEntry(6, value7));

        BarDataSet set2, set3, set4, set5, set6, set7;
        /*set1 = new BarDataSet(yVals1, "Λεμεσός");
        set1.setColor(Color.RED);
        set1.setValueTextSize(12f);*/
        String Vienna = getResources().getString(R.string.Vienna);
        String Zagreb = getResources().getString(R.string.Zagreb);
        String Limassol = getResources().getString(R.string.Limassol);
        set2 = new BarDataSet(yVals2, Vienna);
        set2.setColor(Color.BLUE);
        set2.setValueTextSize(10f);
        set3 = new BarDataSet(yVals3, "");
        set3.setColor(Color.BLUE);
        set3.setValueTextSize(10f);
        set4 = new BarDataSet(yVals4, Zagreb);
        set4.setColor(Color.GREEN);
        set4.setValueTextSize(10f);
        set5 = new BarDataSet(yVals5, "");
        set5.setColor(Color.GREEN);
        set5.setValueTextSize(10f);
        set6 = new BarDataSet(yVals6, Limassol);
        set6.setColor(Color.MAGENTA);
        set6.setValueTextSize(10f);
        set7 = new BarDataSet(yVals7, "");
        set7.setColor(Color.MAGENTA);
        set7.setValueTextSize(10f);
        BarData data = new BarData(set2, set3, set4, set5, set6, set7);
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
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
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
        xAxisLabel.add(highV);
        xAxisLabel.add(lowwV);
        xAxisLabel.add(highV);
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
        leftAxis.setTextSize(8f);
        leftAxis.setSpaceTop(35f);
        leftAxis.setAxisMinimum(0f);




        one = (Button)findViewById(R.id.pm25);
        two = (Button)findViewById(R.id.pm10);
        three = (Button)findViewById(R.id.no2);
        four = (Button)findViewById(R.id.o3);
        five = (Button)findViewById(R.id.so2);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PM10.this, Comparison.class));
            }
        });


        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PM10.this, NO2.class));
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PM10.this, Ozone.class));
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PM10.this, Sulphur.class));
            }
        });

        description = (TextView)findViewById(R.id.desc);
        String txt = getResources().getString(R.string.highlow);
        description.setText((Html.fromHtml(txt)));



    }
}
