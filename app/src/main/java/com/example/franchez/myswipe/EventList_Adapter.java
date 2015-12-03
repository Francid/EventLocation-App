package com.example.franchez.myswipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Franchez on 2015-11-24.
 */
public class EventList_Adapter extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> nameList;

    public EventList_Adapter(Context context, ArrayList<String> nameList) {
        super(context, -1, nameList);

        this.context = context;
        this.nameList = nameList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.view_list_item, parent,false);

        TextView eventView = (TextView)rowView.findViewById(R.id.eventName_view);
        TextView eventDate = (TextView)rowView.findViewById(R.id.eventDate_view);

        eventView.setText(nameList.get(position).toString());
        eventDate.setText("Nov 30");
        return rowView;
    }
}
