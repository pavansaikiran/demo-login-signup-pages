package com.example.pavan.maps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;

/**
 * Created by pavan on 13/6/18.
 */

public class database extends SQLiteOpenHelper implements BaseColumns {


    private static final String Database_name="details.db";
    private static final int Database_version=1;
    private static final String column_id=BaseColumns._ID;
    private static final String table_name="users";
    private static final String column_name="name";
    private static final String column_address="address";
    private static final String column_email="email";
    private static final String column_password="password";
    private static final String column_number="number";




    public database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Database_name, factory, Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query="CREATE TABLE "+table_name+"("+column_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                column_name+" TEXT,"+column_address+" TEXT,"+column_email+" TEXT,"+
                column_password+" TEXT,"+column_number+" INTEGER);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(sqLiteDatabase);
    }
    public void adduser(details user)
    {
        ContentValues values=new ContentValues();
        values.put(column_name,user.getName());
        values.put(column_address,user.getAddress());
        values.put(column_email,user.getEmail());
        values.put(column_number,user.getNumber());
        values.put(column_password,user.getPassword());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(table_name,null,values);
        db.close();
    }
    public void getdatabase()
    {
        Main2Activity.users=new ArrayList<details>();
        SQLiteDatabase db=getReadableDatabase();
        String query=" SELECT * FROM "+table_name;
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            int id=c.getInt(c.getColumnIndex(column_id));
            String name=c.getString(c.getColumnIndex(column_name));
            String address=c.getString(c.getColumnIndex(column_address));
            String email=c.getString(c.getColumnIndex(column_email));
            int number=c.getInt(c.getColumnIndex(column_number));
            String pass=c.getString(c.getColumnIndex(column_password));
            Main2Activity.users.add(new details(id,name,address,email,pass,number));
            c.moveToNext();
        }

    }
}
