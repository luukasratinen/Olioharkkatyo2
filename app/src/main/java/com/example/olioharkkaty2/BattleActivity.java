package com.example.olioharkkaty2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Map;

public class BattleActivity extends AppCompatActivity {

    private ListView listViewLutemons;
    private TextView tvBattleLog;
    private ArrayList<String> lutemonNames = new ArrayList<>();
    private ArrayList<Integer> lutemonIds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        listViewLutemons = findViewById(R.id.listViewBattleLutemons);
        tvBattleLog = findViewById(R.id.tvBattleLog);
        loadLutemons();
    }

    private void loadLutemons() {
        lutemonNames.clear();
        lutemonIds.clear();

        for (Map.Entry<Integer, Lutemon> entry : Storage.getInstance().getAllLutemons().entrySet()) {
            Lutemon lutemon = entry.getValue();
            lutemonNames.add(lutemon.getName() + " (" + lutemon.getColor() + ")");
            lutemonIds.add(lutemon.getId());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice,
                lutemonNames);
        listViewLutemons.setAdapter(adapter);
    }

    public void startBattle(View view) {
        ArrayList<Lutemon> selectedLutemons = new ArrayList<>();
        for (int i = 0; i < listViewLutemons.getCount(); i++) {
            if (listViewLutemons.isItemChecked(i)) {
                selectedLutemons.add(Storage.getInstance().getLutemon(lutemonIds.get(i)));
            }
        }

        if (selectedLutemons.size() != 2) {
            Toast.makeText(this, "Valitse tasan kaksi Lutemonia", Toast.LENGTH_SHORT).show();
            return;
        }

        Lutemon lutemon1 = selectedLutemons.get(0);
        Lutemon lutemon2 = selectedLutemons.get(1);

        BattleField battleField = new BattleField();
        String log = battleField.fight(lutemon1, lutemon2);

        tvBattleLog.setText(log);
        loadLutemons();
    }
}
