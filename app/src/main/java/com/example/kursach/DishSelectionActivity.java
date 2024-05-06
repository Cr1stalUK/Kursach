package com.example.kursach;

import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kursach.dishes.Category;
import com.example.kursach.dishes.Dish;
import com.example.kursach.dishes.Menu;

import java.util.List;

public class DishSelectionActivity extends AppCompatActivity {

    private Menu menu;
    private String selectedCategoryName;
    private ArrayList<Dish> selectedDishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_selection);

        selectedDishes = new ArrayList<>();

        Intent intent = getIntent();
        selectedCategoryName = intent.getStringExtra("selectedCategory");

        initializeMenu();

        List<Category> categories = menu.getCategories();

        String[] categoryNames = new String[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            categoryNames[i] = categories.get(i).getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoryNames);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category selectedCategory = categories.get(position);

                // Переход к OrderActivity и передача выбранной категории и меню
                Intent intent = new Intent(DishSelectionActivity.this, OrderActivity.class);
                intent.putExtra("selectedCategory", selectedCategory.getName());
                intent.putExtra("menu", menu);
                startActivity(intent);
            }
        });
    }

    public void initializeMenu() {
        menu = new Menu();

        Category coldAppetizersCategory = new Category("Холодные закуски");
        Category saladsCategory = new Category("Салаты");
        Category hotAppetizersCategory = new Category("Горячие закуски");
        Category soupsCategory = new Category("Супы");
        Category pastaCategory = new Category("Паста");
        Category pizzaCategory = new Category("Пицца");
        Category dessertsCategory = new Category("Десерты");
        Category childrenMenuCategory = new Category("Детское меню");

        // Добавление категорий в меню
        menu.addCategory(coldAppetizersCategory);
        menu.addCategory(saladsCategory);
        menu.addCategory(hotAppetizersCategory);
        menu.addCategory(soupsCategory);
        menu.addCategory(pastaCategory);
        menu.addCategory(pizzaCategory);
        menu.addCategory(dessertsCategory);
        menu.addCategory(childrenMenuCategory);

        // Добавление блюд в категории
        coldAppetizersCategory.addDish(new Dish("Карпаччо из говядины", 735.0));
        coldAppetizersCategory.addDish(new Dish("Строганина из пеламиды", 595.0));
        coldAppetizersCategory.addDish(new Dish("Боул с кальмаром", 575.0));
        coldAppetizersCategory.addDish(new Dish("Боул с семгой", 615.0));
        coldAppetizersCategory.addDish(new Dish("Сырное плато", 955.0));
        coldAppetizersCategory.addDish(new Dish("Мясное плато", 1100.0));

        saladsCategory.addDish(new Dish("Оливье", 395.0));
        saladsCategory.addDish(new Dish("Цезарь с креветками", 635.0));
        saladsCategory.addDish(new Dish("Цезарь с курицей", 515.0));
        saladsCategory.addDish(new Dish("Греческий салат", 495.0));
        saladsCategory.addDish(new Dish("Салат с уткой", 555.0));

        hotAppetizersCategory.addDish(new Dish("Кальмары в кляре", 515.0));
        hotAppetizersCategory.addDish(new Dish("Сырные палочки", 395.0));
        hotAppetizersCategory.addDish(new Dish("Креветки в сухарях панко", 555.0));
        hotAppetizersCategory.addDish(new Dish("Цыпленок в сухарях панко", 375.0));
        hotAppetizersCategory.addDish(new Dish("Гренки с чесноком и сыром", 295.0));

        soupsCategory.addDish(new Dish("Холодный борщ", 435.0));
        soupsCategory.addDish(new Dish("Куриный суп", 315.0));
        soupsCategory.addDish(new Dish("Уха Балтийская", 555.0));
        soupsCategory.addDish(new Dish("Харчо из баранины", 595.0));
        soupsCategory.addDish(new Dish("Крем-суп из белых грибов", 455.0));
        soupsCategory.addDish(new Dish("Борщ традиционный", 595.0));
        soupsCategory.addDish(new Dish("Том – Ям", 595.0));

        pastaCategory.addDish(new Dish("Паста с морепродуктами", 755.0));
        pastaCategory.addDish(new Dish("Паста с говядиной", 795.0));
        pastaCategory.addDish(new Dish("Паста с курицей и грибами", 595.0));
        pastaCategory.addDish(new Dish("Паста карбонара", 595.0));

        pizzaCategory.addDish(new Dish("Маргарита", 455.0));
        pizzaCategory.addDish(new Dish("Пепперони", 595.0));
        pizzaCategory.addDish(new Dish("Пицца Прошутто Фунги", 575.0));
        pizzaCategory.addDish(new Dish("Четыре сыра", 655.0));
        pizzaCategory.addDish(new Dish("Цезарь", 595.0));
        pizzaCategory.addDish(new Dish("Мясная", 655.0));
        pizzaCategory.addDish(new Dish("Мексикана", 615.0));

        dessertsCategory.addDish(new Dish("Клубничный чизкейк", 415.0));
        dessertsCategory.addDish(new Dish("Бабушкин медовик", 355.0));
        dessertsCategory.addDish(new Dish("Мороженное «Райский остров»", 455.0));
        dessertsCategory.addDish(new Dish("Мороженное «Сникерс»", 455.0));
        dessertsCategory.addDish(new Dish("Мороженное Love is…", 455.0));
        dessertsCategory.addDish(new Dish("Наполеон", 355.0));
        dessertsCategory.addDish(new Dish("Венский штрудель", 415.0));

        childrenMenuCategory.addDish(new Dish("Пицца «Колобок» с ветчиной и сыром", 495.0));
        childrenMenuCategory.addDish(new Dish("Омлетик «Мышонок»", 255.0));
        childrenMenuCategory.addDish(new Dish("Куриные наггетсы", 375.0));
        childrenMenuCategory.addDish(new Dish("Куриная котлетка «Золотая рыбка»", 355.0));
        childrenMenuCategory.addDish(new Dish("Овощной салат «Бабочка»", 295.0));
        childrenMenuCategory.addDish(new Dish("Медовый тортик «Танк»", 255.0));
        childrenMenuCategory.addDish(new Dish("Мороженое «Панда»", 215.0));
    }
    private void addToOrder(Dish dish) {
        selectedDishes.add(dish);
        // Вы также можете выполнить другие действия при добавлении блюда, например, обновить интерфейс
    }
}
