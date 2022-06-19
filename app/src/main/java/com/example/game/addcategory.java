package com.example.game;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.game.SQLiteHelper.TABLE_CategoriesTable;

public class addcategory extends AppCompatActivity {

    EditText category;
    Button add;
    String categoryHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj1;
    String SQLiteDataBaseQueryHolder;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcategory);

        add = (Button) findViewById(R.id.qua);

        category = (EditText) findViewById(R.id.editcategoty);

        sqLiteHelper = new SQLiteHelper(this);
        // Adding click listener to register button.
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creating SQLite database if dose n't exists
                SQLiteDataBaseBuild();

                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();

                // Checking EditText is empty or Not.
                CheckEditTextStatus();

                // Method to check Email is already exists or not.
                CheckingEmailAlreadyExistsOrNot();

                // Empty EditText After done inserting process.
                EmptyEditTextAfterDataInsert();



            }
        });

    }
    public void SQLiteDataBaseBuild(){

        sqLiteDatabaseObj1 = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }
    public void SQLiteTableBuild() {

        sqLiteDatabaseObj1.execSQL(
                "CREATE TABLE IF NOT EXISTS " + TABLE_CategoriesTable + "(" + SQLiteHelper.Table_Column_ID1 + " INTEGER PRIMARY KEY, " + SQLiteHelper.Table_Column_2_Name + " TEXT);");
    }
    public void InsertDataIntoSQLiteDatabase() {

        // If editText is not empty then this block will executed.
        if (EditTextEmptyHolder == true) {

            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder ="INSERT INTO " + TABLE_CategoriesTable + " (name) VALUES('" + categoryHolder + "');";

            // Executing query.
            sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);

            // Closing SQLite database object.
            sqLiteDatabaseObj1.close();
        }
        // This block will execute if any of the registration EditText is empty.
        else {

            // Printing toast message if any of EditText is empty.
            Toast.makeText(addcategory.this, "Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

        }
    }
        public void EmptyEditTextAfterDataInsert(){

            category.getText().clear();


        }
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        categoryHolder = category.getText().toString() ;

        if(TextUtils.isEmpty(categoryHolder)){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }
        // Checking Email is already exists or not.
        public void CheckingEmailAlreadyExistsOrNot(){

            // Opening SQLite database write permission.
            sqLiteDatabaseObj1 = sqLiteHelper.getWritableDatabase();

            // Adding search email query to cursor.
            cursor = sqLiteDatabaseObj1.query(TABLE_CategoriesTable, null, " " + SQLiteHelper.Table_Column_1_Name + "=?", new String[]{categoryHolder}, null, null, null);

            while (cursor.moveToNext()) {

                if (cursor.isFirst()) {

                    cursor.moveToFirst();

                    // If Email is already exists then Result variable value set as Email Found.
                    F_Result = "category Found";

                    // Closing cursor.
                    cursor.close();
                }
            }

            // Calling method to check final result and insert data into SQLite database.
            CheckFinalResult();

        }


        // Checking result
        public void CheckFinalResult(){

            // Checking whether email is already exists or not.
            if(F_Result.equalsIgnoreCase("category Found"))
            {

                // If email is exists then toast msg will display.
                Toast.makeText(addcategory.this,"category Already Exists",Toast.LENGTH_LONG).show();

            }
            else {

                // If email already dose n't exists then user registration details will entered to SQLite database.
                InsertDataIntoSQLiteDatabase();

            }

            F_Result = "Not_Found" ;

        }


    }




