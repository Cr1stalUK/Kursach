package com.example.kursach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.ViewHolder> {

    private String[] drinksArray;

    public DrinksAdapter(String[] drinksArray) {
        this.drinksArray = drinksArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Создаем новый элемент списка через макет
        View drinkView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        // Возвращаем созданный элемент в ViewHolder
        return new ViewHolder(drinkView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Получаем данные для этой позиции
        String drink = drinksArray[position];

        // Устанавливаем данные в элемент списка
        TextView textView = holder.textView;
        textView.setText(drink);
    }

    @Override
    public int getItemCount() {
        return drinksArray.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}

