package com.example.olioharkkaty2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateLutemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_lutemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void createLutemon(View view) {
        EditText etName = findViewById(R.id.etLutemonName);
        RadioGroup rgColors = findViewById(R.id.rgColors);

        String name = etName.getText().toString();
        int selectedColorId = rgColors.getCheckedRadioButtonId();
        RadioButton selectedColor = findViewById(selectedColorId);

        if (name.isEmpty() || selectedColor == null) {
            Toast.makeText(this, "Anna nimi ja valitse väri", Toast.LENGTH_SHORT).show();
            return;
        }

        String color = selectedColor.getText().toString();
        int attack = 10 + "Valkoinen Vihreä Pinkki Oranssi Musta".indexOf(color) / 8;
        int defense = attack; // Oletetaan sama puolustus.
        int health = attack;

        Lutemon newLutemon = new Lutemon(Storage.getInstance().generateId(), name, color, attack, defense, health);
        Storage.getInstance().addLutemon(newLutemon);
        Toast.makeText(this, "Lutemon luotu!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
