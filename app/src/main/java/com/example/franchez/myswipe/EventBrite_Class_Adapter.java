package com.example.franchez.myswipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Franchez on 2015-11-26.
 */
public class EventBrite_Class_Adapter extends BaseAdapter {

    private Context context;
    private List<EventBrite_Class.EventsEntity> cEvent;

    public EventBrite_Class_Adapter(Context context, List<EventBrite_Class.EventsEntity> cEvent) {
        this.context = context;
        this.cEvent = cEvent;
    }

    @Override
    public int getCount() {
        return cEvent.size();
    }

    @Override
    public Object getItem(int position) {
        return cEvent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String eventName = null;
        String eventVenueID = null;
        return null;
    }
}
