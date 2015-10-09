package us.idinfor.smartcitizen.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import us.idinfor.smartcitizen.model.Context;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CONTEXT".
*/
public class ContextDao extends AbstractDao<Context, Long> {

    public static final String TABLENAME = "CONTEXT";

    /**
     * Properties of entity Context.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property User = new Property(1, String.class, "user", false, "USER");
        public final static Property DeviceId = new Property(2, String.class, "deviceId", false, "DEVICE_ID");
        public final static Property Activity = new Property(3, Integer.class, "activity", false, "ACTIVITY");
        public final static Property Latitude = new Property(4, Double.class, "latitude", false, "LATITUDE");
        public final static Property Longitude = new Property(5, Double.class, "longitude", false, "LONGITUDE");
        public final static Property Time = new Property(6, java.util.Date.class, "time", false, "TIME");
    };


    public ContextDao(DaoConfig config) {
        super(config);
    }
    
    public ContextDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CONTEXT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"USER\" TEXT," + // 1: user
                "\"DEVICE_ID\" TEXT," + // 2: deviceId
                "\"ACTIVITY\" INTEGER," + // 3: activity
                "\"LATITUDE\" REAL," + // 4: latitude
                "\"LONGITUDE\" REAL," + // 5: longitude
                "\"TIME\" INTEGER);"); // 6: time
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CONTEXT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Context entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String user = entity.getUser();
        if (user != null) {
            stmt.bindString(2, user);
        }
 
        String deviceId = entity.getDeviceId();
        if (deviceId != null) {
            stmt.bindString(3, deviceId);
        }
 
        Integer activity = entity.getActivity();
        if (activity != null) {
            stmt.bindLong(4, activity);
        }
 
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(5, latitude);
        }
 
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(6, longitude);
        }
 
        java.util.Date time = entity.getTime();
        if (time != null) {
            stmt.bindLong(7, time.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Context readEntity(Cursor cursor, int offset) {
        Context entity = new Context( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // user
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // deviceId
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // activity
            cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4), // latitude
            cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5), // longitude
            cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)) // time
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Context entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUser(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDeviceId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setActivity(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setLatitude(cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4));
        entity.setLongitude(cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5));
        entity.setTime(cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Context entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Context entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}