package com.example.phonebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;


public class MainWindow extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switcher;
    String nameAndSurname;
    public String NAME_AND_SURNAME="NAME_AND_SURNAME";
    String names[] = new String[10];
    ImageButton addUserIconDay,addUserIconNight,serchIconDay,serchIconNight;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        nameAndSurname = intent.getStringExtra(NAME_AND_SURNAME);
        super.onCreate(savedInstanceState);
        if(nameAndSurname == null)
        {

        }
        else{
            addContactToLayout(nameAndSurname);
        }

        setContentView(R.layout.activity_main_window);
        //Przypisanie
        switcher = findViewById(R.id.switcher);
        addUserIconDay= findViewById(R.id.addUserDay);
        addUserIconNight= findViewById(R.id.addUserNight);
        serchIconDay=findViewById(R.id.serchDay);
        serchIconNight=findViewById(R.id.serchNight);

        //zapis danych
        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        nightMode = sharedPreferences.getBoolean("night",false);

        if(nightMode)
        {
            switcher.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nightMode)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night",false);
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night",true);
                }
                editor.apply();
            }
        });
        addUserIconDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWindow.this, CreateUserActivity.class);
                startActivity(intent);
            }
        });
        addUserIconNight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWindow.this, CreateUserActivity.class);
                startActivity(intent);
            }
        });
//        serchIconDay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        serchIconNight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    public void addContactToLayout(String nameAndSurname) {
        LinearLayout contactsLayout = findViewById(R.id.contactsLayout);

        CardView cardView = new CardView(this);
        LinearLayout.LayoutParams cardLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        cardLayoutParams.setMargins(0, 20, 0, 0); // Margines górny
        cardView.setLayoutParams(cardLayoutParams);
        cardView.setRadius(50f);

        TextView contactTextView = new TextView(this);
        LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        contactTextView.setLayoutParams(textLayoutParams);
        contactTextView.setPadding(70, 40, 70, 40);
        contactTextView.setText(String.valueOf(nameAndSurname));

        cardView.addView(contactTextView);
        contactsLayout.addView(cardView);
    }
}