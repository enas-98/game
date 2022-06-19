package com.example.game;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class score extends AppCompatActivity {


    TextView Email;
    Button LogOUT ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        Email = (TextView)findViewById(R.id.textView1);
        LogOUT = (Button)findViewById(R.id.button1);

        Email.setText("Your score is  "+QuizActivity.mScore);

        // Adding click listener to Log Out button.
        LogOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(score.this,"Log Out Successfull", Toast.LENGTH_LONG).show();

            }
        });

    }
}
