package com.example.poc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.poc.adapters.ReservationAdapter;
import com.example.poc.models.Reservation;

import java.util.ArrayList;

public class ReservationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ArrayList<Reservation> arrayOfUsers = new ArrayList<Reservation>();
        ReservationAdapter adapter = new ReservationAdapter(this, arrayOfUsers);
        ListView listView = (ListView) findViewById(R.id.lvReservations);
        listView.setAdapter(adapter);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);
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
    }

}
