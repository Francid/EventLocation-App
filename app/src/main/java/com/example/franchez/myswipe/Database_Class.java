package com.example.franchez.myswipe;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.ArrayList;
import java.util.List;

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
    private static final String SAVED_TABLE = "Saved_Table";

    //Create categoryTable statments
    private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE " + CATEGORY_TABLE
            + " ( "
            + "CategoryID INTEGER PRIMARY KEY, "
            + "CategoryName TEXT "
            + " )";

    //Create LocationTable Statement
    private static final String CREATE_TABLE_LOCATION = "CREATE TABLE " + LOCATION_TABLE
            + " ( "
            + "LocationID    TEXT PRIMARY KEY, "
            + "LocationName  TEXT, "
            + "LocationAdd   TEXT, "
            + "LocationCity  TEXT, "
            + "Latitude      TEXT,"
            + "Longitude     TEXT "
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
            + "EventUrl     TEXT, "
            + "ImageUrl     TEXT, "
            + "CategoryID   INTEGER, "
            + "FOREIGN KEY(CategoryID) REFERENCES " + CATEGORY_TABLE + " (CategoryID), "
            + "FOREIGN KEY(EventLocation) REFERENCES " + LOCATION_TABLE + " (LocationID) "
            + " )";

    //Create placesTable statement
    private static final String CREATE_TABLE_PLACES = "CREATE TABLE " + PLACES_TABLE
            + " ( "
            + "PlaceID      TEXT PRIMARY KEY, "
            + "PLaceName    TEXT, "
            + "PlaceLocation TEXT, "
            + "PlaceDescription TEXT, "
            + "PlaceUrl         TEXT, "
            + "PlaceImageUrl    TEXT, "
            + "FOREIGN KEY(PlaceLocation) REFERENCES " + LOCATION_TABLE + " (LocationID) "
            + " )";

    private static final String CREATE_TABLE_SAVED = "CREATE TABLE " + SAVED_TABLE
            + " ( "
            + "SavedID      INTEGER PRIMARY KEY, "
            + "SavedName    TEXT, "
            + "SavedCategory TEXT, "
            + "FOREIGN KEY(SavedID) REFERENCES " + EVENT_TABLE + " (EventID) "
            + " )";

    public Database_Class(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_CATEGORY);
        db.execSQL(CREATE_TABLE_LOCATION);
        db.execSQL(CREATE_TABLE_EVENT);
        db.execSQL(CREATE_TABLE_PLACES);
        db.execSQL(CREATE_TABLE_SAVED);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*Insert Data into LocationTable*/
    protected void insertLocation(EventBrite_Venue_Class venue, GooglePLace_Details_Class.ResultEntity placesVenue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        if (venue != null) {
            EventBrite_Venue_Class.AddressEntity venuAdddr = venue.getAddress();

            values.put("LocationID", venue.getId());
            values.put("LocationName", venue.getName());
            values.put("LocationAdd", venuAdddr.getAddress_1());
            values.put("LocationCity", venuAdddr.getCity());
            values.put("Latitude", venuAdddr.getLatitude());
            values.put("Longitude", venuAdddr.getLongitude());
        }else {
            GooglePLace_Details_Class.ResultEntity.GeometryEntity.LocationEntity placeLoc = placesVenue.getGeometry().getLocation();
            List <GooglePLace_Details_Class.ResultEntity.AddressComponentsEntity> placeAddComp = placesVenue.getAddress_components();

            values.put("LocationID", placesVenue.getPlace_id());
            values.put("LocationName", placesVenue.getName());
            values.put("LocationAdd", placesVenue.getFormatted_address());
            values.put("LocationCity", placeAddComp.get(2).getShort_name());
            values.put("Latitude", placeLoc.getLat());
            values.put("Longitude", placeLoc.getLng());
        }


        db.insert(LOCATION_TABLE, null, values);
        db.close();
    }

    /*Insert Data into the CategoryTable*/
    protected void insertCategory(EventBrite_Category_Class.CategoriesEntity category) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("CategoryID", category.getId());
        values.put("CategoryName", category.getName());

        db.insert(CATEGORY_TABLE, null, values);
        db.close();
    }

    /*Insert Data into EventsTable*/
    protected void insertEvents(EventBrite_Class.EventsEntity events) {
        SQLiteDatabase db = this.getWritableDatabase();

        EventBrite_Class.EventsEntity.NameEntity name = events.getName();
        EventBrite_Class.EventsEntity.StartEntity startDate = events.getStart();
        EventBrite_Class.EventsEntity.EndEntity endDate = events.getEnd();
        EventBrite_Class.EventsEntity.LogoEntity logoEntity = events.getLogo();
        EventBrite_Class.EventsEntity.DescriptionEntity eventDes = events.getDescription();

        ContentValues values = new ContentValues();
        values.put("EventID", events.getId());
        values.put("EventName", name.getText());
        values.put("EventLocation", events.getVenue_id());
        values.put("EventDate", startDate.getLocal());
        values.put("EventEndDate", endDate.getLocal());
        values.put("EventDescription", eventDes.getText());
        values.put("EventUrl", events.getUrl());
        values.put("ImageUrl", logoEntity.getUrl());
        values.put("CategoryID", (String) events.getCategory_id());

        db.insert(EVENT_TABLE, null, values);
        db.close();
    }

    protected int getEventsCount() {
        String countQuery = "SELECT * FROM " + PLACES_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    ArrayList<String> eveUrl = new ArrayList<>();
    ArrayList<String> eveDate = new ArrayList<>();

    protected ArrayList<String> getEvents(String categoryName) {
        ArrayList<String> value = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT Events_Table.ImageUrl, Events_Table.EventName, Events_Table.EventDate FROM Events_Table INNER JOIN Category_Table " +
                "ON Events_Table.CategoryID = Category_Table.CategoryID " +
                "WHERE Category_Table.CategoryName LIKE ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(categoryName + "%")});
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    eveUrl.add(cursor.getString(0));
                    String d = cursor.getString(1);
                    if (d.contains(":")) {
                        d = d.substring(0, d.indexOf(":"));
                    }
                    value.add(d);
                    eveDate.add(cursor.getString(2));
                } while (cursor.moveToNext());
            }
        }
//        getEventURL();
        return value;
    }

    protected ArrayList<String> getEventURL(){
        return eveUrl;
    }

    protected ArrayList<String> getEventDate(){
        return eveDate;
    }

    protected ArrayList<String> getEvents() {
        ArrayList<String> value = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + EVENT_TABLE;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String d = cursor.getString(1);
                    if (d.contains(":")) {
                        d = d.substring(0, d.indexOf(":"));
                    }
                    value.add(d);
                } while (cursor.moveToNext());
            }
        }
        return value;
    }

    /* Query the DB for using the Item name selected**/
    protected ArrayList<String> setSavedEvents(String eName) {

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT EventID, EventName FROM Events_Table " +
                "WHERE Events_Table.EventName Like ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(eName + "%")});

        ArrayList<String> value = new ArrayList<String>();
        if (cursor != null) {
            cursor.moveToFirst();
            int columncount = cursor.getColumnCount();

            for (int a = 0; a < columncount; a++) {
                value.add(cursor.getString(a));
            }
        }
        insertSavedItem(value);
        return value;
    }

    /*Insert Data into Places Table*/
    protected void insertPlaces(GooglePLace_Details_Class.ResultEntity place, List<GooglePlace_Search_Class.ResultsEntity.PhotosEntity> placePhoto ) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String photoUrl = null;
        if(placePhoto != null){
            photoUrl = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=100&maxheight=50&photoreference=" + placePhoto.get(0).getPhoto_reference() + "&key=AIzaSyA7M_tHKRaRgXjtsc6CnlyW6-X9BYkFQ1U";
        }
        values.put("PlaceID",place.getId());
        values.put("PLaceName", place.getName());
        values.put("PlaceLocation", place.getPlace_id());
        values.put("PlaceDescription", "null");
        values.put("PlaceUrl",place.getUrl());
        values.put("PlaceImageUrl", photoUrl);

        db.insert(PLACES_TABLE, null, values);
        db.close();
    }

    /*Insert the events or places saved by user*/
    protected void insertSavedItem(ArrayList<String> savedItem) {

        SQLiteDatabase db = this.getWritableDatabase();
        String[] colums = {"SavedID", "SavedName"};
        ContentValues contentValues = new ContentValues();
        for (int a = 0; a < colums.length; a++) {
            contentValues.put(colums[a], savedItem.get(a));
        }
        contentValues.put("SavedCategory", "Music");

        db.insert(SAVED_TABLE, null, contentValues);
        db.close();
    }

    protected ArrayList<String> getSavedEvent() {
        ArrayList<String> value = new ArrayList<>();
        String query = "SELECT s.SavedName, e.ImageUrl, e.EventDate FROM  Saved_Table As s, Events_Table As e " +
                "WHERE e.EventID = s.SavedID";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    value.add(cursor.getString(0));
                    eveUrl.add(cursor.getString(1));
                    eveDate.add(cursor.getString(2));
                } while (cursor.moveToNext());
            }
        }
        return value;
    }

    protected void deleteSavedEvent(String eventName) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SAVED_TABLE, "SavedName Like ?", new String[]{String.valueOf(eventName+"%")});
    }

    /*Query for the Detail fragment*/
    protected ArrayList<String> getDetails(String name, String clickName) {
        String query = null;
        ArrayList<String> value = new ArrayList<>();

        switch (clickName){
            case "SAVED":
                 query = "SELECT e.EventName, e.EventDate, c.CategoryName, e.EventUrl, e.EventDescription, " +
                        "l.LocationAdd, l.LocationCity, l.Latitude, l.Longitude " +
                        "FROM Events_Table AS e, Location_Table AS l, Saved_Table AS s, Category_Table AS c " +
                        "WHERE e.EventID = s.SavedID " +
                        "AND e.EventLocation = l.LocationID " +
                        "AND e.CategoryID = c.CategoryID " +
                        "AND s.SavedName LIKE ?";
                break;
            case "EVENTS":
                query = "SELECT e.EventName, e.EventDate, c.CategoryName, e.EventUrl, e.EventDescription, " +
                        "l.LocationAdd, l.LocationCity, l.Latitude, l.Longitude " +
                        "FROM Events_Table AS e, Location_Table AS l, Category_Table AS c " +
                        "WHERE e.EventLocation = l.LocationID " +
                        "AND e.CategoryID = c.CategoryID " +
                        "AND e.EventName LIKE ?";
                break;
            default:
                break;
        }

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(name + "%")});

        if (cursor != null) {
            cursor.moveToFirst();
            int columncount = cursor.getColumnCount();

            for (int a = 0; a < columncount; a++) {
                value.add(cursor.getString(a));
            }
        }
        return value;
    }

    /*Get PLaces*/
    protected ArrayList<String> getPlaces(){
        ArrayList<String> value = new ArrayList<>();
        String query="SELECT PLaceName, PlaceImageUrl FROM Places_Table ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor != null){
            if(cursor.moveToFirst()){
                do {
                    value.add(cursor.getString(0));
                    eveUrl.add(cursor.getString(1));
                }while (cursor.moveToNext());
            }
        }
        return value;
    }
}
