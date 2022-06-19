package com.example.game;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class adminactivity extends AppCompatActivity {

    Button LogOUT1,add1,add2,view1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminactivity);
        LogOUT1 = (Button)findViewById(R.id.ad);
        add1 = (Button)findViewById(R.id.cat);
        add2 = (Button)findViewById(R.id.qua);
        view1 = (Button)findViewById(R.id.view);
        Intent intent = getIntent();



        // Adding click listener to Log Out button.
        LogOUT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(adminactivity.this,"Log Out Successfull", Toast.LENGTH_LONG).show();

            }
        });
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                Intent i2 = new Intent(adminactivity.this, addcategory.class);
                startActivity(i2);
         }
        });


        add2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //Finishing current DashBoard activity on button click.
            Intent i2 = new Intent(adminactivity.this, addquastion.class);
            startActivity(i2);
        }
    });

}
}