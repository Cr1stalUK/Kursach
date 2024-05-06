package com.example.kursach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class BarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        // Находим кнопки по их идентификаторам
        Button coffeeButton = findViewById(R.id.coffeeButton);
        Button teaButton = findViewById(R.id.teaButton);
        Button waterButton = findViewById(R.id.waterButton);
        Button sodaButton = findViewById(R.id.sodaButton);
        Button juicesButton = findViewById(R.id.juicesButton);
        Button milkshakesButton = findViewById(R.id.milkshakesButton);

        // Устанавливаем обработчики событий для кнопок
        coffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь будет логика для отображения списка напитков в категории "Кофе"
                showDrinksList("Кофе");
            }
        });

        teaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь будет логика для отображения списка напитков в категории "Чай"
                showDrinksList("Чай");
            }
        });
        waterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDrinksList("Вода");
            }
        });

        sodaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDrinksList("Газированные напитки");
            }
        });

        juicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDrinksList("Соки");
            }
        });

        milkshakesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDrinksList("Коктейли молочные");
            }
        });


        // Добавьте обработчики для остальных кнопок
    }

    // Метод для отображения списка напитков в выбранной категории
    private void showDrinksList(String category) {
        Intent intent = new Intent(BarActivity.this, DrinksListActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }

}

