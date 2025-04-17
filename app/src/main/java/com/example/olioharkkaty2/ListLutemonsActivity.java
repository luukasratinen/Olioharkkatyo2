package com.example.olioharkkaty2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Map;

public class ListLutemonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_lutemons);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvLutemonList = findViewById(R.id.tvLutemonList);
        StringBuilder lutemonList = new StringBuilder();

        for (Map.Entry<Integer, Lutemon> entry : Storage.getInstance().getAllLutemons().entrySet()) {
            Lutemon lutemon = entry.getValue();
            lutemonList.append(lutemon.getName())
                    .append(" (")
                    .append(lutemon.getColor())
                    .append(") - Hyökkäys: ")
                    .append(lutemon.getAttack())
                    .append(", Puolustus: ")
                    .append(lutemon.getDefense())
                    .append(", Kokemus: ")
                    .append(lutemon.getExperience())
                    .append(", Elämäpisteet: ")
                    .append(lutemon.getHealth())
                    .append("/")
                    .append(lutemon.getMaxHealth())
                    .append("\n");
        }

        tvLutemonList.setText(lutemonList.toString());
    }
}
