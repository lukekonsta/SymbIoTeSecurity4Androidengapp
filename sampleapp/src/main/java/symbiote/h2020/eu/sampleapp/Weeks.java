package symbiote.h2020.eu.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class Weeks extends AppCompatActivity {

    LinearLayout o31, o32, o33, o34;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Weeks.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weeks);

        o31 = (LinearLayout) findViewById(R.id.btn);
        o31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Weeks.this, O31.class));
            }
        });

        o32 = (LinearLayout) findViewById(R.id.btn2);
        o32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Weeks.this, O32.class));
            }
        });

        o33 = (LinearLayout) findViewById(R.id.btn3);
        o33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Weeks.this, O33.class));
            }
        });


        o34 = (LinearLayout) findViewById(R.id.btn4);
        o34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Weeks.this, O34.class));
            }
        });


    }
}
