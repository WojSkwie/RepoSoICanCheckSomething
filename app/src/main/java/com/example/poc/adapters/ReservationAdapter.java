package com.example.poc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.poc.R;
import com.example.poc.models.Reservation;

import java.util.ArrayList;

public class ReservationAdapter extends ArrayAdapter<Reservation> {
    public ReservationAdapter(Context context, ArrayList<Reservation> reservations) {
        super(context, 0, reservations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Reservation reservation = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_reservation, parent, false);
        }
        // Lookup view for data population
        TextView tvHotel = (TextView) convertView.findViewById(R.id.tvHotel);
        TextView tvRoom = (TextView) convertView.findViewById(R.id.tvRoom);
        // Populate the data into the template view using the data object
        tvHotel.setText(reservation.getRoom().getHotel().getName());
        tvRoom.setText(reservation.getRoom().getRoomNumber());
        // Return the completed view to render on screen
        return convertView;

    }
}
