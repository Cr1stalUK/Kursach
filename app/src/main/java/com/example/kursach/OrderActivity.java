package com.example.kursach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.kursach.dishes.Dish;
import com.example.kursach.dishes.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderActivity extends AppCompatActivity {

    private ImageView guestsIcon, tableIcon, waiterIcon;
    private TextView nameHeader, quantityHeader, priceHeader;
    private LinearLayout checkItemsLayout;
    private Button printButton;

    private TextView selectedTableTextView;
    private TextView numberOfGuestsTextView;

    private ScrollView checkScrollView;
    private Button hotButton, soupButton, childrenMenu, coldButton, pastaButton, desertsButton, salatButton, pizzaButton;
    private Map<String, Button> categoryButtons;
    private String selectedCategory;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        initViews();

        initCategoryButtons();

        setButtonListeners();

        Intent intent = getIntent();
        String stol = intent.getStringExtra("selectedTable");
        String cheloveki = intent.getStringExtra("numberOfGuests");
        selectedTableTextView.setText(stol);
        numberOfGuestsTextView.setText(cheloveki);
    }

    private void initViews() {
        selectedTableTextView = findViewById(R.id.stol);
        numberOfGuestsTextView = findViewById(R.id.cheloveki);
        guestsIcon = findViewById(R.id.guestsIcon);
        tableIcon = findViewById(R.id.tableIcon);
        waiterIcon = findViewById(R.id.waiterIcon);
        nameHeader = findViewById(R.id.nameHeader);
        quantityHeader = findViewById(R.id.quantityHeader);
        checkItemsLayout = findViewById(R.id.checkItemsLayout);
        printButton = findViewById(R.id.printButton);
        checkScrollView = findViewById(R.id.checkScrollView);
        printButton.setBackgroundResource(R.drawable.bluebtn);
        printButton.setTextColor(getResources().getColor(R.color.white));
    }

    private void initCategoryButtons() {
        hotButton = findViewById(R.id.hotButton);
        soupButton = findViewById(R.id.soupButton);
        childrenMenu = findViewById(R.id.childrenMenu);
        coldButton = findViewById(R.id.coldButton);
        pastaButton = findViewById(R.id.pastaButton);
        desertsButton = findViewById(R.id.desertsButton);
        salatButton = findViewById(R.id.salatButton);
        pizzaButton = findViewById(R.id.pizzaButton);

        categoryButtons = new HashMap<>();
        categoryButtons.put("Горячие закуски", hotButton);
        categoryButtons.put("Супы", soupButton);
        categoryButtons.put("Детское меню", childrenMenu);
        categoryButtons.put("Холодные закуски", coldButton);
        categoryButtons.put("Паста", pastaButton);
        categoryButtons.put("Десерты", desertsButton);
        categoryButtons.put("Салаты", salatButton);
        categoryButtons.put("Пицца", pizzaButton);
    }

    private void setButtonListeners() {
        for (final String category : categoryButtons.keySet()) {
            categoryButtons.get(category).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDishSelectionActivity(category);
                }
            });
        }
    }

    private void openDishSelectionActivity(String categoryName) {
        Intent intent = new Intent(OrderActivity.this, DishSelectionActivity.class);
        intent.putExtra("categoryName", categoryName);
        startActivity(intent);
    }

    private void addDishToCheckScrollView(Dish dish) {
        // Создаем новый TextView для отображения информации о блюде
        TextView textView = new TextView(this);
        textView.setText(dish.getName() + " - " + dish.getPrice());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(layoutParams);
        // Добавляем TextView в checkScrollView
        checkScrollView.addView(textView);
    }

    private void updateMenuForCategory(String category) {
        checkScrollView.removeAllViews();
        List<Dish> dishes = getMenuForCategory(category);
        for (Dish dish : dishes) {
            addDishToCheckScrollView(dish);
        }
    }

    private List<Dish> getMenuForCategory(String category) {
        List<Dish> dishes = new ArrayList<>();
        // Здесь должен быть ваш код для получения списка блюд по выбранной категории
        return dishes;
    }
    private void addToCheck(String itemName, int quantity, double price) {
        TextView itemTextView = new TextView(this);
        itemTextView.setText(itemName + " - " + quantity + " - " + price);
        checkItemsLayout.addView(itemTextView);
    }

    private void removeFromCheck(View view) {
        checkItemsLayout.removeView(view);
    }
    private void printCheck() {
        // Ваш код для печати чека
    }
}
