package com.example.olioharkkaty2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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

        LinearLayout lutemonContainer = findViewById(R.id.svLutemonContainer);

        for (Map.Entry<Integer, Lutemon> entry : Storage.getInstance().getAllLutemons().entrySet()) {

            Lutemon lutemon = entry.getValue();

            TextView lutemonView = new TextView(this);


            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(

                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT


            );

            params.setMargins(0, 0, 0, 16);
            lutemonView.setLayoutParams(params);
            lutemonView.setBackgroundColor(Color.parseColor("#9370DB"));
            lutemonView.setPadding(16, 16, 16, 16);


            StringBuilder lutemonDetails = new StringBuilder();


            lutemonDetails.append(lutemon.getName())

                    .append(" (")
                    .append(lutemon.getColor())
                    .append(")\n")
                    .append("Hyökkäys: ")
                    .append(lutemon.getAttack())
                    .append("\n")
                    .append("Puolustus: ")
                    .append(lutemon.getDefense())
                    .append("\n")
                    .append("Elämä: ")
                    .append(lutemon.getHealth())
                    .append("/")
                    .append(lutemon.getMaxHealth())
                    .append("\n")
                    .append("Kokemus: ")
                    .append(lutemon.getExperience());

            lutemonView.setText(lutemonDetails.toString());


            lutemonView.setTextSize(16);
            lutemonView.setTextColor(Color.BLACK);


            lutemonContainer.addView(lutemonView);
        }


    }
}
