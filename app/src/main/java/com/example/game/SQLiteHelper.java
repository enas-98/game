
package com.example.game;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="UserDataBase";
    public static final String TABLE_CategoriesTable = "CATEGORIES_TABLE";
    public static final String TABLE_NAME="UserTable";
    public static final String  TABLE_quastions="QUESTIONS_TABLE";
    public static final String Table_Column_ID="id";

    public static final String Table_Column_1_Name="name";

    public static final String Table_Column_2_Email="email";

    public static final String Table_Column_3_Password="password";

    public static final String Table_Column_ID1="id";
    public static final String Table_Column_2_Name="name";

    public static final String Table_Column_ID2="id";
    public static final String  Table_Column_2_QUESTION="QUESTION";
    public static final String Table_Column_3_OPTION1="OPTION1";
    public static final String Table_Column_4_OPTION2="OPTION2";
    public static final String Table_Column_5_OPTION3="OPTION3";
    public static final String Table_Column_6_ANSWER_NR="ANSWER_NR";
    public static final String Table_Column_7_COLUMN_CATEGORY_name="CATEGORY_name";


    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + Table_Column_ID + " INTEGER PRIMARY KEY, " + Table_Column_1_Name + " VARCHAR, " + Table_Column_2_Email + " VARCHAR, " + Table_Column_3_Password + " VARCHAR)";
        database.execSQL(CREATE_TABLE);
        String CREATE_TABLE1 = "CREATE TABLE IF NOT EXISTS " + TABLE_CategoriesTable + " (" + Table_Column_ID1 + " INTEGER PRIMARY KEY , " + Table_Column_2_Name + " TEXT)";
        database.execSQL(CREATE_TABLE1);
        String CREATE_TABLE2 = "CREATE TABLE IF NOT EXISTS " + TABLE_quastions + " (" + Table_Column_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Table_Column_2_QUESTION + " TEXT," +  Table_Column_3_OPTION1 + " Text,"+  Table_Column_4_OPTION2 + " Text," +
                Table_Column_5_OPTION3  + " Text, " + Table_Column_6_ANSWER_NR + " INTEGER, "+Table_Column_7_COLUMN_CATEGORY_name + "Text)" ;
        database.execSQL(CREATE_TABLE2);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CategoriesTable);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_quastions);
        onCreate(db);
    }

}