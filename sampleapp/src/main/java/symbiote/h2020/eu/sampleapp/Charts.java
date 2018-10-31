package symbiote.h2020.eu.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Charts extends AppCompatActivity {

    Button btn;
    LinearLayout lima, ven, zeg, compa;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Charts.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);
        System.out.println("WELCOME");


        lima = (LinearLayout) findViewById(R.id.btn);
        lima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Charts.this, Map_Second.class));
            }
        });

        ven = (LinearLayout) findViewById(R.id.btn2);
        ven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Charts.this, Map_First.class));
            }
        });

        zeg = (LinearLayout) findViewById(R.id.btn3);
        zeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Charts.this, Map_Third.class));
            }
        });


        compa = (LinearLayout) findViewById(R.id.btn4);
        compa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Charts.this, Comparison.class));
            }
        });

    }//end of onCreate


}
