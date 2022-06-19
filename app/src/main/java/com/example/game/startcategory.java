package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class startcategory extends AppCompatActivity {
    Button sc1,sc2,sc3,sc4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startcategory);

        sc1 = (Button) findViewById(R.id.cat);
        sc2 = (Button) findViewById(R.id.qua);
        sc3 = (Button) findViewById(R.id.view);
        sc4 = (Button) findViewById(R.id.ad);
        sc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(startcategory.this, QuizActivity.class);
                startActivity(i);

            }
        });

    }
}