package com.example.olioharkkaty2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goToCreateLutemon(View view) {
        startActivity(new Intent(this, CreateLutemonActivity.class));
    }

    public void goToListLutemons(View view) {
        startActivity(new Intent(this, ListLutemonsActivity.class));
    }

    public void goToMoveLutemons(View view) {
        startActivity(new Intent(this, MoveLutemonsActivity.class));
    }

    public void goToBattle(View view) {
        startActivity(new Intent(this, BattleActivity.class));
    }
}
