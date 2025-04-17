package com.example.olioharkkaty2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Map;

public class MoveLutemonsActivity extends AppCompatActivity {

    private Spinner spinnerLocation;
    private ListView listViewLutemons;
    private ArrayList<String> lutemonNames = new ArrayList<>();
    private ArrayList<Integer> lutemonIds = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lutemons);

        spinnerLocation = findViewById(R.id.spinnerLocation);
        listViewLutemons = findViewById(R.id.listViewLutemons);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.locations, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocation.setAdapter(spinnerAdapter);

        loadLutemons();
    }

    private void loadLutemons() {
        lutemonNames.clear();
        lutemonIds.clear();

        for (Map.Entry<Integer, Lutemon> entry : Storage.getInstance().getAllLutemons().entrySet()) {
            Lutemon lutemon = entry.getValue();
            String location = Storage.getInstance().getLutemonLocation(lutemon.getId()); // Hae sijainti
            lutemonNames.add(lutemon.getName() + " (" + lutemon.getColor() + ") - " + location); // Näytä sijainti
            lutemonIds.add(lutemon.getId());
        }

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice,
                lutemonNames);
        listViewLutemons.setAdapter(adapter);
    }

    public void moveLutemons(View view) {
        String selectedLocation = spinnerLocation.getSelectedItem().toString();

        for (int i = 0; i < listViewLutemons.getCount(); i++) {
            if (listViewLutemons.isItemChecked(i)) {
                int lutemonId = lutemonIds.get(i);
                Lutemon lutemon = Storage.getInstance().getLutemon(lutemonId);

                Storage.getInstance().removeLutemonFromCurrentLocation(lutemonId);

                if (selectedLocation.equals("Koti")) {
                    Storage.getInstance().moveToHome(lutemon);
                } else if (selectedLocation.equals("Treeni")) {
                    Storage.getInstance().moveToTrainingArea(lutemon); // Oikea metodi
                } else if (selectedLocation.equals("Areena")) {
                    Storage.getInstance().moveToBattleField(lutemon);
                }

                Toast.makeText(this, lutemon.getName() + " siirretty: " + selectedLocation, Toast.LENGTH_SHORT).show();
            }
        }

        loadLutemons();

    }
}
