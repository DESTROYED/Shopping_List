package com.lidchanin.crudindiploma.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.lidchanin.crudindiploma.database.Statistic;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STATISTIC".
*/
public class StatisticDao extends AbstractDao<Statistic, Long> {

    public static final String TABLENAME = "STATISTIC";

    /**
     * Properties of entity Statistic.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Quantity = new Property(2, double.class, "quantity", false, "QUANTITY");
        public final static Property TotalCost = new Property(3, double.class, "totalCost", false, "TOTAL_COST");
        public final static Property Unit = new Property(4, boolean.class, "unit", false, "UNIT");
        public final static Property Date = new Property(5, long.class, "date", false, "DATE");
    }


    public StatisticDao(DaoConfig config) {
        super(config);
    }
    
    public StatisticDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STATISTIC\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"QUANTITY\" REAL NOT NULL ," + // 2: quantity
                "\"TOTAL_COST\" REAL NOT NULL ," + // 3: totalCost
                "\"UNIT\" INTEGER NOT NULL ," + // 4: unit
                "\"DATE\" INTEGER NOT NULL );"); // 5: date
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STATISTIC\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Statistic entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindDouble(3, entity.getQuantity());
        stmt.bindDouble(4, entity.getTotalCost());
        stmt.bindLong(5, entity.getUnit() ? 1L: 0L);
        stmt.bindLong(6, entity.getDate());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Statistic entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindDouble(3, entity.getQuantity());
        stmt.bindDouble(4, entity.getTotalCost());
        stmt.bindLong(5, entity.getUnit() ? 1L: 0L);
        stmt.bindLong(6, entity.getDate());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Statistic readEntity(Cursor cursor, int offset) {
        Statistic entity = new Statistic( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.getDouble(offset + 2), // quantity
            cursor.getDouble(offset + 3), // totalCost
            cursor.getShort(offset + 4) != 0, // unit
            cursor.getLong(offset + 5) // date
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Statistic entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setQuantity(cursor.getDouble(offset + 2));
        entity.setTotalCost(cursor.getDouble(offset + 3));
        entity.setUnit(cursor.getShort(offset + 4) != 0);
        entity.setDate(cursor.getLong(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Statistic entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Statistic entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Statistic entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
