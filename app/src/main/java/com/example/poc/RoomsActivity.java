package com.example.poc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.poc.adapters.RoomAdapter;
import com.example.poc.models.Hotel;
import com.example.poc.models.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomsActivity extends AppCompatActivity {

    private ArrayList<Room> rooms; //= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        /*ArrayList<Room> arrayOfRooms = new ArrayList<Room>();

        Hotel hotel = new Hotel(0,"Tutaj", 1, new ArrayList<Room>(), "Tfuj stary pijany");
        arrayOfRooms.add(new Room(0,1.2, 201, 1, false,false, hotel));
        arrayOfRooms.add(new Room(0,1.2, 201, 1, false,false, hotel));*/

        ArrayList<Room> rooms = (ArrayList<Room>)( this.getIntent().getBundleExtra("roomsBundle").getSerializable("rooms"));


        RoomAdapter adapter = new RoomAdapter(this, rooms);

        ListView listView = (ListView) findViewById(R.id.lvRooms);
        listView.setAdapter(adapter);
    }

}
