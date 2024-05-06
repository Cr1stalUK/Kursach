package com.example.kursach;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChooseTableActivity extends Activity {
    private EditText StolEditText;
    private EditText guestsEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_table);
        StolEditText = findViewById(R.id.stol);
        guestsEditText = findViewById(R.id.guestsEditText);
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedTable = StolEditText.getText().toString();
                String numberOfGuests = guestsEditText.getText().toString();

                Intent intent = new Intent(ChooseTableActivity.this, OrderActivity.class);
                intent.putExtra("selectedTable", selectedTable);
                intent.putExtra("numberOfGuests", numberOfGuests);
                startActivity(intent);
            }
        });

        Button tableButton100 = findViewById(R.id.tableButton100);
        Button tableButton101 = findViewById(R.id.tableButton101);
        Button tableButton102 = findViewById(R.id.tableButton102);
        Button tableButton103 = findViewById(R.id.tableButton103);
        Button tableButton104 = findViewById(R.id.tableButton104);
        Button tableButton105 = findViewById(R.id.tableButton105);
        Button tableButton106 = findViewById(R.id.tableButton106);
        Button tableButton107 = findViewById(R.id.tableButton107);

        tableButton100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {;
                StolEditText.setText("100");
            }
        });

        tableButton101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StolEditText.setText("101");
            }
        });

        tableButton102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StolEditText.setText("102");
            }
        });

        tableButton103.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StolEditText.setText("103");
            }
        });

        tableButton104.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StolEditText.setText("104");
            }
        });

        tableButton105.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StolEditText.setText("105");
            }
        });
        tableButton106.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StolEditText.setText("106");
            }
        });

        tableButton107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StolEditText.setText("107");
            }
        });

    }
}