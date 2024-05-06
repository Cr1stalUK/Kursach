package com.example.kursach.dishes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable {
    private List<Category> categories;

    public Menu() {
        this.categories = new ArrayList<>();
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public List<Category> getCategories() {
        return categories;
    }

    // Метод для получения списка блюд по названию категории
    public List<Dish> getDishesByCategory(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                return category.getDishes();
            }
        }
        return null;
    }
}
