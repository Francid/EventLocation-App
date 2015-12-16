package com.example.franchez.myswipe;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Franchez on 2015-11-24.
 */
public class EventList_Adapter extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> eveName;
    private final ArrayList<String> eveURL;
    private final ArrayList<String> eveDate;

    public EventList_Adapter(Context context, ArrayList<String> eveName, ArrayList<String> eveURL, ArrayList<String> eveDate ) {
        super(context, -1, eveName);

        this.context = context;
        this.eveName = eveName;
        this.eveURL = eveURL;
        this.eveDate = eveDate;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.view_list_item, parent,false);

        ImageView eventImage = (ImageView)rowView.findViewById(R.id.eventImage_view);
        TextView eventView = (TextView)rowView.findViewById(R.id.eventName_view);
        TextView eventDate = (TextView)rowView.findViewById(R.id.eventDate_view);


        if (eveURL != null && eveURL.get(position) != null) {
            Picasso.with(context)
                    .load(eveURL.get(position))
                    .into(eventImage);
        }
        eventView.setText(eveName.get(position));

        if (eveDate!= null) {
            String disDate = eveDate.get(position);
            Date recDate = null;
            SimpleDateFormat orignalformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.CANADA);
            try {
                recDate = orignalformat.parse(disDate);
            }catch (ParseException e) {
                e.printStackTrace();
            }

            SimpleDateFormat displayFormat = new SimpleDateFormat("MMM dd");
            disDate = displayFormat.format(recDate);
            eventDate.setText(disDate);
        }
        return rowView;
    }
}
