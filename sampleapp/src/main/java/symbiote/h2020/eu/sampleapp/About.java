package symbiote.h2020.eu.sampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView txt, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        txt = (TextView) findViewById(R.id.txt);
        String nodata = "This application was designed and developed by the “Media, Cognition and Learning” Research group and the IoT Lab of the Department of Communication and Internet Studies of the Cyprus University of Technology under the European research project “IoT for Education: Presenting air quality matters\"." +
                "\n" +
                "The project was funded by the European Union's Research and Innovation Program Horizon 2020 under the Grant Agreement No. 688156.";

        //txt.setText(Html.fromHtml(nodata));

        String data2 = "The air quality data for the city of Limassol are provided by the Air Quality Division of the Department of Labor Inspection of the Ministry of Labor, Welfare and Social Insurance of Cyprus.";

        txt2 = (TextView) findViewById(R.id.txt2);
        //txt2.setText(data2);


    }
}
