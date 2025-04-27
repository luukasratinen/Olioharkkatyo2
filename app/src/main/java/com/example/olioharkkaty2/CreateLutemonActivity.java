package com.example.olioharkkaty2;


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
        setContentView(R.layout.activity_create_lutemon);

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

        int attack = 0, defense = 0, health = 0;
        switch (color) {


            case "Valkoinen":

                attack = 5;
                defense = 4;;
                health = 20;
                break;

            case "Vihreä":
                attack = 6;
                defense = 3;
                health = 19;
                break;
            case "Pinkki":
                attack = 7;
                defense = 2;

                health = 18;
                break;
            case "Oranssi":
                attack = 8;
                defense = 1;
                health = 17;
                break;

            case "Musta":
                attack = 9;

                defense = 0;
                health = 16;
                break;


            default:
                return;
        }

        Lutemon newLutemon = new Lutemon(Storage.getInstance().generateId(), name, color, attack, defense, health);
        Storage.getInstance().addLutemon(newLutemon);

        Toast.makeText(this, "Lutemon luotu!", Toast.LENGTH_SHORT).show();
        finish();


    }



}
