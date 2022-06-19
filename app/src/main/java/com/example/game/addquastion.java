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
import static com.example.game.SQLiteHelper.TABLE_quastions;
public class addquastion extends AppCompatActivity {
    EditText q1, o1, o2, o3, ans, cat;
    Button add;
    String q1Holder, o1Holder, o2Holder, o3Holder, ansHolder, catHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj2;
    String SQLiteDataBaseQueryHolder;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addquastion);

        add = (Button) findViewById(R.id.qua);

        q1 = (EditText) findViewById(R.id.editName);
        o1 = (EditText) findViewById(R.id.op1);
        o2 = (EditText) findViewById(R.id.op2);
        o3 = (EditText) findViewById(R.id.op3);
        ans = (EditText) findViewById(R.id.ans);
        cat = (EditText) findViewById(R.id.cat);

        sqLiteHelper = new SQLiteHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDataBaseBuild();
                SQLiteTableBuild();
                CheckEditTextStatus();
                InsertDataIntoSQLiteDatabase();



            }
        });

    }

    public void SQLiteDataBaseBuild() {

        sqLiteDatabaseObj2= openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild() {

        sqLiteDatabaseObj2.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_quastions + "(" + SQLiteHelper.Table_Column_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT , " + SQLiteHelper.Table_Column_2_QUESTION + " TEXT," + SQLiteHelper.Table_Column_3_OPTION1 + " TEXT," + SQLiteHelper.Table_Column_4_OPTION2 + " TEXT," + SQLiteHelper.Table_Column_5_OPTION3 + " TEXT," + SQLiteHelper.Table_Column_6_ANSWER_NR + " INTEGER, " + SQLiteHelper.Table_Column_7_COLUMN_CATEGORY_name + "Text);");
    }

    public void InsertDataIntoSQLiteDatabase() {

        if (EditTextEmptyHolder == true) {

            SQLiteDataBaseQueryHolder ="INSERT INTO "+TABLE_quastions+" (QUESTION,OPTION1,OPTION2,OPTION3,ANSWER_NR,COLUMN_CATEGORY_name) VALUES('"+q1Holder+"', '"+o1Holder+"', '"+o2Holder+"','"+o3Holder+"','"+ansHolder+"','"+catHolder+"');";

            sqLiteDatabaseObj2.execSQL(SQLiteDataBaseQueryHolder);

            sqLiteDatabaseObj2.close();

            Toast.makeText(addquastion.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
        }
        else {

            Toast.makeText(addquastion.this, "Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

        }

    }



    public void CheckEditTextStatus() {

        q1Holder = q1.getText().toString();
        o1Holder = o1.getText().toString();
        o2Holder = o2.getText().toString();
        o3Holder = o3.getText().toString();
        ansHolder = ans.getText().toString();
        catHolder = cat.getText().toString();

        if (TextUtils.isEmpty(q1Holder)|| TextUtils.isEmpty(o1Holder) || TextUtils.isEmpty(o2Holder) || TextUtils.isEmpty(o3Holder) || TextUtils.isEmpty(ansHolder) || TextUtils.isEmpty(catHolder)) {

            EditTextEmptyHolder = false;

        } else {

            EditTextEmptyHolder = true;
        }

    }

}








