package com.example.poc.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.poc.R;
import com.example.poc.adapters.RoomAdapter;
import com.example.poc.adapters.SpinnerHotelsAdapter;
import com.example.poc.constants.Constants;
import com.example.poc.models.Hotel;
import com.example.poc.models.Room;

import java.util.ArrayList;

public class RoomsActivity extends AppCompatActivity {

    private ArrayList<Room> rooms; //= new ArrayList<>();
    private ArrayList<Hotel> hotels;
    private View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this::onFloatingButtonClick);
        deserializeAndSetRoomList();

    }

    private void onFloatingButtonClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder((this));
        LayoutInflater inflater = this.getLayoutInflater();

        dialogView = inflater.inflate(R.layout.add_room_layout, null);

        builder.setView(dialogView)
                .setPositiveButton("OK", this::onAddNewRoomConfirmed)
                .setNegativeButton("Cancel", this::onAddNewRoomCanceled);

        AlertDialog dialog = builder.create();


        SpinnerHotelsAdapter spinnerAdapter = new SpinnerHotelsAdapter(this, hotels);
        Spinner spinner = (Spinner) dialogView.findViewById(R.id.spHotels);
        spinner.setAdapter(spinnerAdapter);

        dialog.show();
    }

    private void onAddNewRoomCanceled(DialogInterface dialogInterface, int id) {
        dialogInterface.cancel();
    }

    private void onAddNewRoomConfirmed(DialogInterface dialog, int id){
        double price = Double.parseDouble(((EditText)(dialogView.findViewById(R.id.etPrice))).getText().toString());
        int roomNumber = Integer.parseInt(((EditText)(dialogView.findViewById(R.id.etNumber))).getText().toString());
        int beds = Integer.parseInt(((EditText)(dialogView.findViewById(R.id.etBeds))).getText().toString());
        boolean separateBathroom = ((Switch)(dialogView.findViewById(R.id.sBathroom))).isChecked();
        boolean smoking = ((Switch)(dialogView.findViewById(R.id.sSmoking))).isChecked();
        Hotel hotel = (Hotel) ((Spinner)(dialogView.findViewById(R.id.spHotels))).getSelectedItem();

        Room room = new Room(price, roomNumber, beds, separateBathroom, smoking, hotel);
        rooms.add(room);

        ListView listView = (ListView) findViewById(R.id.lvRooms);
        ((ArrayAdapter)listView.getAdapter()).notifyDataSetChanged();


    }

    private void deserializeAndSetRoomList(){
        rooms = (ArrayList<Room>)( this.getIntent().getBundleExtra(Constants.ROOM_ACTIVITY_BUNDLE).getSerializable(Constants.ROOM_BUNDLE_ROOMS));
        hotels = (ArrayList<Hotel>)(this.getIntent().getBundleExtra(Constants.ROOM_ACTIVITY_BUNDLE).getSerializable(Constants.ROOM_BUNDLE_HOTELS));

        RoomAdapter adapter = new RoomAdapter(this, rooms);
        ListView listView = (ListView) findViewById(R.id.lvRooms);
        listView.setAdapter(adapter);


    }


    public void onExitClick(View view) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.ROOM_BUNDLE_ROOMS,rooms);
        intent.putExtra(Constants.ROOM_ACTIVITY_BUNDLE, bundle);
        setResult(1, intent);
        finish();
    }

    public void onRoomDeleteClick(View view) {

        //view.get
    }
}
