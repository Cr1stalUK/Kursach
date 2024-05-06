package com.example.kursach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button hotButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hotButton = findViewById(R.id.hotButton);

        hotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDishSelectionActivity("Горячие закуски");
            }
        });
    }

    private void openDishSelectionActivity(String categoryName) {
        Intent intent = new Intent(MainActivity.this, DishSelectionActivity.class);
        intent.putExtra("selectedCategory", categoryName);
        startActivity(intent);
    }
}
