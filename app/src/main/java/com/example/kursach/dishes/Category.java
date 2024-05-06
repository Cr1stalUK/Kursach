package com.example.kursach.dishes;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Dish> dishes;

    public Category(String name) {
        this.name = name;
        this.dishes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
