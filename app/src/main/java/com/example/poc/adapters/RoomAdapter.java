package com.example.poc.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.poc.R;
import com.example.poc.models.Room;

import java.util.ArrayList;

public class RoomAdapter extends ArrayAdapter<Room> {

    private ArrayList<Room> rooms;

    public RoomAdapter(Context context, ArrayList<Room> rooms) {
        super(context, 0, rooms);
        this.rooms = rooms;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Room room = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_room, parent, false);
        }

        Button buttonRemove = (Button) convertView.findViewById(R.id.btnRemoveRoom);
        buttonRemove.setOnClickListener((view) -> {
            rooms.remove(position);
            notifyDataSetChanged();
        });

        TextView tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
        TextView tvNumber = (TextView) convertView.findViewById(R.id.tvNumber);
        TextView tvBeds = (TextView) convertView.findViewById(R.id.tvBeds);
        TextView tvHotel = (TextView) convertView.findViewById(R.id.tvHotel);

        tvPrice.setText(String.format("Price: %.2f", room.getPrice()));
        tvNumber.setText(String.format("No. %d", room.getRoomNumber()));
        tvBeds.setText(String.format("No. beds: %d",room.getBeds()));
        tvHotel.setText(String.format("Hotel: %s", room.getHotel().getName()));

        return convertView;
    }

}
