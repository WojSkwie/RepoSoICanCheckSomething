package com.example.poc.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.poc.R;
import com.example.poc.models.Hotel;
import com.example.poc.models.Reservation;
import com.example.poc.models.Room;

import java.util.ArrayList;

public class SpinnerHotelsAdapter extends ArrayAdapter<Hotel> implements SpinnerAdapter {

    public SpinnerHotelsAdapter(Context context, ArrayList<Hotel> hotels){
        super(context,0, hotels);
    }


    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hotel hotel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_hotel_room_list, parent, false);
        }

        TextView tvHotelName = (TextView) convertView.findViewById(R.id.tvHotelName);

        tvHotelName.setText(String.format("Hotel: %s", hotel.getName()));

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        Hotel hotel = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_hotel_room_list, parent, false);
        }

        TextView tvHotelName = (TextView) convertView.findViewById(R.id.tvHotelName);

        tvHotelName.setText(String.format("Hotel: %s", hotel.getName()));

        return convertView;
        /*View view;
        view =  View.inflate(this.getContext(), R.layout.item_hotel_room_list, null);
        final TextView textView = (TextView) view.findViewById(R.id.dropdown);
        textView.setText(company[position]);



        return view;*/
    }


}
