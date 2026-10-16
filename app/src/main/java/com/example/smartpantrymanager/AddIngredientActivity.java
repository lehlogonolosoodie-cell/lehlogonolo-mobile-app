package com.example.smartpantrymanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.smartpantrymanager.database.DatabaseHelper;

public class AddIngredientActivity extends AppCompatActivity {

    private EditText editName, editQty, editUnit;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);

        dbHelper = new DatabaseHelper(this);

        editName = findViewById(R.id.editIngredientName);
        editQty = findViewById(R.id.editQuantity);
        editUnit = findViewById(R.id.editUnit);
        Button btnSave = findViewById(R.id.btnSaveIngredient);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveIngredient();
            }
        });
    }

    private void saveIngredient() {
        String name = editName.getText().toString().trim();
        String qtyStr = editQty.getText().toString().trim();
        String unit = editUnit.getText().toString().trim();

        if (name.isEmpty() || qtyStr.isEmpty() || unit.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double quantity = Double.parseDouble(qtyStr);
        boolean isInserted = dbHelper.addPantryItem(name, quantity, unit);

        if (isInserted) {
            Toast.makeText(this, "Ingredient added!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Failed to add ingredient", Toast.LENGTH_SHORT).show();
        }
    }
}