package com.example.franchez.myswipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Franchez on 2015-11-28.
 */
public class Database_Class extends SQLiteOpenHelper {

    //Database version and name respectively
    private static final int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "lopventDatabase";

    //Table Names
    private static final String CATEGORY_TABLE = "Category_Table";
    private static final String EVENT_TABLE = "Events_Table";
    private static final String PLACES_TABLE = "Places_Table";
    private static final String LOCATION_TABLE = "Location_Table";

    //Create categoryTable statments
    private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE " + CATEGORY_TABLE
            + " ( "
            + "CategoryID INTEGER PRIMARY KEY, "
            + "CategoryName TEXT "
            + " )";

    //Create LocationTable Statement
    private static final String CREATE_TABLE_LOCATION ="CREATE TABLE " + LOCATION_TABLE
            + " ( "
            + "LocationID    INTEGER PRIMARY KEY, "
            + "LocationName  TEXT, "
            + "LocationAdd   TEXT, "
            + "LocationCity  TEXT "
            + " )";

    //Create eventTable statement
    private static final String CREATE_TABLE_EVENT = "CREATE TABLE " + EVENT_TABLE
            + " ( "
            + "EventID      INTEGER PRIMARY KEY, "
            + "EventName    TEXT, "
            + "EventLocation TEXT, "
            + "EventDate    TEXT, "
            + "EventEndDate TEXT, "
            + "EventDescription TEXT, "
            + "EventRating  TEXT, "
            + "EventUrl     TEXT, "
            + "ImageUrl     TEXT, "
            + "CategoryID   INTEGER, "
            + "FOREIGN KEY(CategoryID) REFERENCES " + CATEGORY_TABLE + " (CategoryID), "
            + "FOREIGN KEY(EventLocation) REFERENCES " + LOCATION_TABLE + " (LocationID) "
            + " )";

    //Create placesTable statement
    private static final String CREATE_TABLE_PLACES = "CREATE TABLE " + PLACES_TABLE
            +" ( "
            + "PlaceID      INTEGER PRIMARY KEY, "
            + "PLaceName    TEXT, "
            + "PlaceLocation TEXT, "
            + "PlaceDescription TEXT, "
            + "PlaceUrl         TEXT, "
            + "PlaceImageUrl    TEXT, "
            + "PlaceRating  NUMERIC, "
            + "FOREIGN KEY(PlaceLocation) REFERENCES " + LOCATION_TABLE + " (LocationID) "
            +" )";

    public Database_Class(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_CATEGORY);
        db.execSQL(CREATE_TABLE_LOCATION);
        db.execSQL(CREATE_TABLE_EVENT);
        db.execSQL(CREATE_TABLE_PLACES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*Insert Data into LocationTable*/
    protected void insertLocation(EventBrite_Venue_Class venue){
        SQLiteDatabase db = this.getWritableDatabase();

        EventBrite_Venue_Class.AddressEntity venuAdddr = venue.getAddress();

        ContentValues values = new ContentValues();
        values.put("LocationID",venue.getId());
        values.put("LocationName",venue.getName());
        values.put("LocationAdd",venuAdddr.getAddress_1());
        values.put("LocationCity",venuAdddr.getCity());

        db.insert(LOCATION_TABLE, null, values);
        db.close();
    }

    /*Insert Data into the CategoryTable*/
    protected void  insertCategory(EventBrite_Category_Class.CategoriesEntity category){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("CategoryID",category.getId());
        values.put("CategoryName",category.getName());

        db.insert(CATEGORY_TABLE,null,values);
        db.close();
    }

    /*Insert Data into EventsTable*/
    protected void insertEvents(EventBrite_Class.EventsEntity events){
        SQLiteDatabase db = this.getWritableDatabase();

        EventBrite_Class.EventsEntity.NameEntity name = events.getName();
        EventBrite_Class.EventsEntity.StartEntity startDate = events.getStart();
        EventBrite_Class.EventsEntity.EndEntity endDate = events.getEnd();
        EventBrite_Class.EventsEntity.DescriptionEntity eventDes = events.getDescription();

        ContentValues values = new ContentValues();
        values.put("EventID",events.getId());
        values.put("EventName",name.getText());
        values.put("EventLocation",events.getVenue_id());
        values.put("EventDate",startDate.getLocal());
        values.put("EventEndDate",endDate.getLocal());
        values.put("EventDescription",eventDes.getText());
        values.put("EventRating", "TBD");
        values.put("EventUrl",events.getUrl());
        values.put("ImageUrl", (String)events.getLogo_id());
        values.put("CategoryID",(String)events.getCategory_id());

        db.insert(EVENT_TABLE,null,values);
        db.close();
    }

    protected int getEventsCount(){
        String countQuery = "SELECT * FROM " + CATEGORY_TABLE ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    /*Insert Data into Places Table*/
    protected void insertPlaces(){
    }
}
