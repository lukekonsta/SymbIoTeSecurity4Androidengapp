package symbiote.h2020.eu.sampleapp;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Limassol extends AppCompatActivity {

    ArrayList<Float> limassolData = new ArrayList<Float>();
    ArrayList<Float> limassolData2 = new ArrayList<Float>();//pm10
    ArrayList<Float> limassolData3 = new ArrayList<Float>();
    ArrayList<Float> limassolData4 = new ArrayList<Float>();
    ArrayList<Float> limassolData5 = new ArrayList<Float>();
    TextView txt, txt1, txt2, txt3, txt4, txt5;

    SharedPreferences sharedPrefs;
    Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limassol);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .6));


        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(Limassol.this);
        Type type = new TypeToken<List<String>>() {
        }.getType();


        /*//Nitrogen - Vienna
        String json = sharedPrefs.getString("array_vienna_nitrogen", "");
        List<String> arrayList = gson.fromJson(json, type);
        System.out.println("Length is: "+arrayList.size());

        for(int counter = 0;counter<arrayList.size();counter++){

            String value = arrayList.get(counter);
            if(value.contains(",")){
                value = value.replace(",", ".");
            }
            float final_float = Float.valueOf(value);
            String val = String.format("%.2f", final_float);
            if(val.contains(",")){
                val = value.replace(",", ".");
            }
            float final_float_total = Float.valueOf(val);
            nitrogenVienna.add(final_float_total);

        }*/


        /*//Nitrogen - Zagreb
        String json1 = sharedPrefs.getString("array_zagreb_nitrogen", "");
        List<String> arrayList1 = gson.fromJson(json1, type);
        System.out.println("Length is: "+arrayList1.size());

        for(int counter = 0;counter<arrayList1.size();counter++){

            String value = arrayList1.get(counter);
            if(value.contains(",")){
                value = value.replace(",", ".");
            }
            float final_float = Float.valueOf(value);
            String val = String.format("%.2f", final_float);
            if(val.contains(",")){
                val = value.replace(",", ".");
            }
            float final_float_total = Float.valueOf(val);
            nitrogenZagreb.add(final_float_total);

        }*/


        /*//Nitrogen - Limassol
        String json2 = sharedPrefs.getString("array_limassol_nitrogen", "");
        List<String> arrayList2 = gson.fromJson(json2, type);
        System.out.println("Length is: "+arrayList2.size());

        for(int counter = 0;counter<arrayList2.size();counter++){

            String value = arrayList2.get(counter);
            if(value.contains(",")){
                value = value.replace(",", ".");
            }
            float final_float = Float.valueOf(value);
            String val = String.format("%.2f", final_float);
            if(val.contains(",")){
                val = value.replace(",", ".");
            }
            float final_float_total = Float.valueOf(val);
            nitrogenLimassol.add(final_float_total);

        }*/





        /*//PM10 - Zagreb
        String json10 = sharedPrefs.getString("array_zagreb_pm10", "");
        List<String> arrayList10 = gson.fromJson(json10, type);

        for(int counter = 0;counter<arrayList10.size();counter++){

            String value = arrayList10.get(counter);
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

        System.out.println("Length is: "+pm10Zagreb.size());*/



        /*//PM25 - Vienna
        String json12 = sharedPrefs.getString("array_vienna_pm25", "");
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
            pm25Vienna.add(final_float_total);

        }

        System.out.println("Length is: "+pm25Vienna.size());*/


        //Limassol
        String json13 = sharedPrefs.getString("array_limassol_nitrogen", "");
        List<String> arrayList13 = gson.fromJson(json13, type);

        for (int counter = 0; counter < arrayList13.size(); counter++) {

            String value = arrayList13.get(counter);
            if (value.contains(",")) {
                value = value.replace(",", ".");
            }
            float final_float = Float.valueOf(value);
            String val = String.format("%.2f", final_float);
            if (val.contains(",")) {
                val = value.replace(",", ".");
            }
            float final_float_total = Float.valueOf(val);
            limassolData.add(final_float_total);

        }


        //Limassol
        String json14 = sharedPrefs.getString("array_limassol_pm10", "");
        List<String> arrayList14 = gson.fromJson(json14, type);

        for (int counter = 0; counter < arrayList14.size(); counter++) {

            String value = arrayList14.get(counter);
            if (value.contains(",")) {
                value = value.replace(",", ".");
            }
            float final_float = Float.valueOf(value);
            String val = String.format("%.2f", final_float);
            if (val.contains(",")) {
                val = value.replace(",", ".");
            }
            float final_float_total = Float.valueOf(val);
            limassolData2.add(final_float_total);

        }


        //Limassol
        String json15 = sharedPrefs.getString("array_limassol_pm25", "");
        List<String> arrayList15 = gson.fromJson(json15, type);

        for (int counter = 0; counter < arrayList15.size(); counter++) {

            String value = arrayList15.get(counter);
            if (value.contains(",")) {
                value = value.replace(",", ".");
            }
            float final_float = Float.valueOf(value);
            String val = String.format("%.2f", final_float);
            if (val.contains(",")) {
                val = value.replace(",", ".");
            }
            float final_float_total = Float.valueOf(val);
            limassolData3.add(final_float_total);

        }

        //Limassol
        String json16 = sharedPrefs.getString("array_limassol_sulphur", "");
        List<String> arrayList16 = gson.fromJson(json16, type);

        for (int counter = 0; counter < arrayList16.size(); counter++) {

            String value = arrayList16.get(counter);

            if(value.equals(null)){

                limassolData4.add(0f);

            }else{

                if (value.contains(",")) {
                    value = value.replace(",", ".");
                }
                float final_float = Float.valueOf(value);
                String val = String.format("%.2f", final_float);
                if (val.contains(",")) {
                    val = value.replace(",", ".");
                }
                float final_float_total = Float.valueOf(val);
                limassolData4.add(final_float_total);

            }

        }

        //Limassol
        String json17 = sharedPrefs.getString("array_limassol_ozone", "");
        List<String> arrayList17 = gson.fromJson(json17, type);

        for (int counter = 0; counter < arrayList17.size(); counter++) {

            String value = arrayList17.get(counter);

            if(value.equals(null)){

                limassolData5.add(0f);

            }else {


                if (value.contains(",")) {
                    value = value.replace(",", ".");
                }
                float final_float = Float.valueOf(value);
                String val = String.format("%.2f", final_float);
                if (val.contains(",")) {
                    val = value.replace(",", ".");
                }
                float final_float_total = Float.valueOf(val);
                limassolData5.add(final_float_total);
            }

        }




        txt = (TextView) findViewById(R.id.calendar);
        txt1 = (TextView) findViewById(R.id.pm1);
        txt2 = (TextView) findViewById(R.id.pm2);
        txt3 = (TextView) findViewById(R.id.azoto);
        txt4 = (TextView) findViewById(R.id.ozon);
        txt5 = (TextView) findViewById(R.id.theio);


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, 0);
        calendar.add(Calendar.MINUTE, -40);
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        String formatted = format1.format(calendar.getTime());
        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");
        String formatted2 = format2.format(calendar.getTime());
        String lastM = getResources().getString(R.string.lastM);
        txt.setText(formatted+ System.lineSeparator() +lastM +" "+formatted2);





        float var1 = limassolData.get(0);//nitrogen
        if(var1<=100){
            txt3.setBackgroundColor(Color.GREEN);
        }else if(var1>100&&var1<=150){
            txt3.setBackgroundColor(Color.YELLOW);
        }else if(var1>150&&var1<=200){
            txt3.setBackgroundColor(Color.RED);
        }else if(var1>200){
            txt3.setBackgroundColor(Color.MAGENTA);
        }
        String s1 = String.format("%.2f", var1);
        txt3.setText(s1+" μg/m3");




        float var2 = limassolData2.get(0);//pm10
        if(var2<=50){
            txt1.setBackgroundColor(Color.GREEN);
        }else if(var2>50&&var2<=100){
            txt1.setBackgroundColor(Color.YELLOW);
        }else if(var2>100&&var2<=200){
            txt1.setBackgroundColor(Color.RED);
        }else if(var2>200){
            txt1.setBackgroundColor(Color.MAGENTA);
        }
        String s2 = String.format("%.2f", var2);
        txt1.setText(s2+" μg/m3");




        float var3 = limassolData3.get(0);//pm25
        if(var3<=25){
            txt2.setBackgroundColor(Color.GREEN);
        }else if(var3>25&&var3<=50){
            txt2.setBackgroundColor(Color.YELLOW);
        }else if(var3>50&&var3<=100){
            txt2.setBackgroundColor(Color.RED);
        }else if(var3>100){
            txt2.setBackgroundColor(Color.MAGENTA);
        }
        String s3 = String.format("%.2f", var3);
        txt2.setText(s3+" μg/m3");




        float var4 = limassolData4.get(0);//so2
        if(var4<=150){
            txt5.setBackgroundColor(Color.GREEN);
        }else if(var4>150&&var4<=250){
            txt5.setBackgroundColor(Color.YELLOW);
        }else if(var4>250&&var4<=350){
            txt5.setBackgroundColor(Color.RED);
        }else if(var4>350){
            txt5.setBackgroundColor(Color.MAGENTA);
        }
        String s4 = String.format("%.2f", var4);
        txt5.setText(s4+" μg/m3");




        float var5 = limassolData5.get(0);//03
        if(var5<=100){
            txt4.setBackgroundColor(Color.GREEN);
        }else if(var5>100&&var5<=140){
            txt4.setBackgroundColor(Color.YELLOW);
        }else if(var5>140&&var5<=180){
            txt4.setBackgroundColor(Color.RED);
        }else if(var5>180){
            txt4.setBackgroundColor(Color.MAGENTA);
        }
        String s5 = String.format("%.2f", var5);
        txt4.setText(s5+" μg/m3");


    }
}
