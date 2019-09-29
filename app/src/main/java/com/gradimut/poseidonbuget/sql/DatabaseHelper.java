package com.gradimut.poseidonbuget.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.gradimut.poseidonbuget.model.Users;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, Database.DATABASE_NAME, null, Database.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Database.UserTable.CREATE_QUERY);
        sqLiteDatabase.execSQL(Database.Budget.CREATE_QUERY);
        sqLiteDatabase.execSQL(Database.Items.CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    //this handle the insertion in the databases
    public long Insert (String table, ContentValues values){

        return getWritableDatabase().insert(table, null, values);
    }

    //this methods handle the update
    public int update (String table, ContentValues values, String whereClause, String[] whereArgs){
        return getWritableDatabase().update(table, values, whereClause, whereArgs);
    }

    //this methods handle the reading form the databases
    public Cursor read(String table,String[] columns, String whereClause, String[] whereArgs,
                       String groupByColumns, String havingClause, String sortOrder){

        return getReadableDatabase().query(table,columns,whereClause,whereArgs,
                groupByColumns,havingClause,sortOrder);

    }

    //Delete methods
    public int delete(String table, String whereClause, String[] whereArgs){

        return getWritableDatabase().delete(table, whereClause, whereArgs);
    }



}
