package com.app.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{

    public DBHelper(Context context) {
        super(context,"demo",null,1);

    }

    public void insertData(String name, String contact)
    {
        String qry = "insert into contactbook (name, contact) values ('" + name + "','" + contact + "')";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(qry);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry = "create table contactbook (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,contact TEXT)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
    public Cursor viewData() {

        SQLiteDatabase db = getReadableDatabase();

        String qry = "select * from contactbook";

        Cursor cursor = db.rawQuery(qry, null);

        return cursor;
    }
    public void deleteData(int id) {

        String qry = "delete from contactbook where id = '" + id + "'";

        SQLiteDatabase db = getWritableDatabase();

        db.execSQL(qry);
    }
    public void updateData(int id, String name, String contact) {

        String qry = "update Contact_Book set name = '"+name+"',contact='"+contact+"' where id = '"+id+"'";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(qry);

    }

}
