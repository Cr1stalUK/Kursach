package com.example.kursach;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DrinksListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_list);

        // Получаем категорию из интента
        String category = getIntent().getStringExtra("category");

        // Получаем массив напитков для выбранной категории
        String[] drinksArray = getDrinksArrayByCategory(category);

        // Находим RecyclerView в макете
        RecyclerView drinksRecyclerView = findViewById(R.id.drinksRecyclerView);

        // Создаем и устанавливаем адаптер
        DrinksAdapter adapter = new DrinksAdapter(drinksArray);
        drinksRecyclerView.setAdapter(adapter);

        // Устанавливаем менеджер компоновки
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        drinksRecyclerView.setLayoutManager(layoutManager);
    }

    private String[] getDrinksArrayByCategory(String category) {
        // Здесь вы можете реализовать логику получения массива напитков для выбранной категории
        // Например, из ресурсов или базы данных
        // В этом примере я просто верну пустой массив
        return new String[0];
    }
}



