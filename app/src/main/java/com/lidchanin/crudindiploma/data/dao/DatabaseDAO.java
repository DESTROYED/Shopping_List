package com.lidchanin.crudindiploma.data.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.lidchanin.crudindiploma.data.DatabaseHelper;

/**
 * The class <code>DatabaseDAO</code> parent class for work with database.
 *
 * @author Lidchanin
 */
abstract class DatabaseDAO {

    protected SQLiteDatabase database;
    private DatabaseHelper databaseHelper;
    private Context context;

    DatabaseDAO(Context context) {
        this.context = context;
        databaseHelper = DatabaseHelper.getHelper(context);
        open();
    }

    /**
     * The method <code>open</code> is used to get a writable database object.
     */
    public void open() {
        Log.i(DatabaseDAO.class.getSimpleName(), "Database is opened.");
        if (databaseHelper == null) {
            databaseHelper = DatabaseHelper.getHelper(context);
        }
        database = databaseHelper.getWritableDatabase();
    }

    /**
     * The method <code>close</code> is used to disconnecting a writable database object.
     */
    public void close() {
        Log.i(DatabaseDAO.class.getSimpleName(), "Database is closed.");
        databaseHelper.close();
        database.close();
    }
}
