package com.example.game;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button LogInButton, RegisterButton,adminButton;
    EditText Email, Password;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND";
    public static final String UserEmail = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) { ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogInButton = (Button) findViewById(R.id.cat);

        RegisterButton = (Button) findViewById(R.id.qua);

       adminButton = (Button) findViewById(R.id.admin);

        Email = (EditText) findViewById(R.id.editEmail);
        Password = (EditText) findViewById(R.id.editPassword);

        sqLiteHelper = new SQLiteHelper(this);

        //Adding click listener to log in button.
        LogInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                CheckEditTextStatus();
                LoginFunction();
                admin();
                // Calling EditText is empty or no method.


            }
        });
        adminButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i2 = new Intent(MainActivity.this, adminactivity.class);
                startActivity(i2);
                // Calling EditText is empty or no method.


            }
        });

        // Adding click listener to register button.
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Opening new user registration activity using intent on button click.
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);

            }
        });

    }

    // Login function starts from here.
    public void LoginFunction() {

        if (EditTextEmptyHolder) {

            // Opening SQLite database write permission.
            sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

            // Adding search email query to cursor.
            cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);

            while (cursor.moveToNext()) {

                if (cursor.isFirst()) {

                    cursor.moveToFirst();

                    // Storing Password associated with entered email.
                    TempPassword = cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_3_Password));

                    // Closing cursor.
                    cursor.close();
                }
            }

            // Calling method to check final result ..
            CheckFinalResult();

        } else {

            //If any of login EditText empty then this block will be executed.
            Toast.makeText(MainActivity.this, "Please Enter UserName or Password.", Toast.LENGTH_LONG).show();

        }

    }

    // Checking EditText is empty or not.
    public void CheckEditTextStatus() {

        // Getting value from All EditText and storing into String Variables.
        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();


        // Checking EditText is empty or no using TextUtils.
        if (TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)) {

            EditTextEmptyHolder = false;

        } else {

            EditTextEmptyHolder = true;
        }
    }

    // Checking entered password from SQLite database email associated password.
    public void CheckFinalResult() {
            if (TempPassword.equalsIgnoreCase(PasswordHolder)) {

                Toast.makeText(MainActivity.this, "Login Successfully user", Toast.LENGTH_LONG).show();
                // Going to Dashboard activity after login success message.
                Intent intent = new Intent(MainActivity.this, com.example.game.startcategory.class);

                // Sending Email to Dashboard Activity using intent.
                intent.putExtra(UserEmail, EmailHolder);

                startActivity(intent);


                    } else {

            Toast.makeText(MainActivity.this, "UserName or Password is Wrong, Please Try Again.", Toast.LENGTH_LONG).show();

        }
        TempPassword = "NOT_FOUND";

    }
    public void admin() {
        if (EmailHolder == "r99" || PasswordHolder == "r99") {
                Toast.makeText(MainActivity.this, "Login Successfully admin", Toast.LENGTH_LONG).show();
                // Going to Dashboard activity after login success message.
                Intent intent = new Intent(MainActivity.this, com.example.game.DashboardActivity.class);

                // Sending Email to Dashboard Activity using intent.
                intent.putExtra(UserEmail, EmailHolder);

                startActivity(intent);

        }
        else {

            EditTextEmptyHolder = true;
        }
    }


}

