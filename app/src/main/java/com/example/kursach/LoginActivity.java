package com.example.kursach;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.kursach.Users;
import com.example.kursach.Prevalent;



public class LoginActivity extends AppCompatActivity {

    private EditText logPhoneInput, logPasswInput;
    private EditText phoneInput, passwInput;
    private ProgressDialog loadingbar;
    private Button logBtn;

    private String parentDbName = "Users";
    private TextView AdminLink, NotAdminLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logBtn = (Button) findViewById(R.id.logbtn);
        phoneInput= (EditText) findViewById(R.id.editTextTel);
        passwInput= (EditText) findViewById(R.id.editTextPin);
        loadingbar= new ProgressDialog(this);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }

            private void loginUser() {
                String phone = phoneInput.getText().toString();
                String passw = passwInput.getText().toString();

                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(LoginActivity.this, "Введите номер", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(passw)) {
                    Toast.makeText(LoginActivity.this, "Введите пароль", Toast.LENGTH_SHORT).show();
                } else {
                    loadingbar.setTitle("Вход в приложение");
                    loadingbar.setMessage("Пожалуйста подождите");
                    loadingbar.setCanceledOnTouchOutside(false);
                    loadingbar.show();

                    validateUser(phone, passw);
                }
            }

            private void validateUser(String phone, String passw) {

                final DatabaseReference RootRef;
                RootRef = FirebaseDatabase.getInstance().getReference();

                RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.child(parentDbName).child(phone).exists()) {
                            Long value = snapshot.child(parentDbName).child(phone).getValue(Long.class);
                            if (value != null) {
                                String stringValue = String.valueOf(value);
                                Users userData = snapshot.child(parentDbName).child(phone).getValue(Users.class);
                                if (userData != null && userData.getPhone().equals(phone)) {
                                    if (userData.getPassw().equals(passw)) {
                                        loadingbar.dismiss();
                                        Toast.makeText(LoginActivity.this, "Успешный вход", Toast.LENGTH_SHORT).show();

                                        Intent homeIntent = new Intent(LoginActivity.this, ChooseTableActivity.class);
                                        startActivity(homeIntent);
                                    } else {
                                        loadingbar.dismiss();
                                        Toast.makeText(LoginActivity.this, "Неверный пароль", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        } else {
                            loadingbar.dismiss();
                            Toast.makeText(LoginActivity.this, "Аккаунта с номером" + phone + "не существует", Toast.LENGTH_SHORT).show();
                            Intent regIntent = new Intent(LoginActivity.this, LoginActivity.class);
                            startActivity(regIntent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        loadingbar.dismiss();
                        Toast.makeText(LoginActivity.this, "Ошибка: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}