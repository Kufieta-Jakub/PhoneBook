package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CreateUserActivity extends AppCompatActivity {
    private Button button;
    public String NAME_AND_SURNAME="NAME_AND_SURNAME";
    private EditText nameE,surnameE,cityE,number1E,number2E,number3E;
    private String name,surname,city,number1,number2,number3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        button=findViewById(R.id.button);

        //przypisania
        nameE=findViewById(R.id.editTextText4);
        surnameE=findViewById(R.id.editTextText5);
        cityE=findViewById(R.id.editTextText6);
        number1E=findViewById(R.id.editTextNumber2);
        number2E=findViewById(R.id.editTextNumber5);
        number3E=findViewById(R.id.editTextNumber6);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = String.valueOf(nameE.getText());
                surname = String.valueOf(surnameE.getText());
                city = String.valueOf(cityE.getText());
                number1 = String.valueOf(number1E.getText());
                number2 = String.valueOf(number2E.getText());
                number3 = String.valueOf(number3E.getText());
                String nameAndSurname = name + " " + surname;
                // Wywołanie metody addContact z MainActivity
                Toast.makeText(CreateUserActivity.this, nameAndSurname, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CreateUserActivity.this,MainWindow.class);
                intent.putExtra(NAME_AND_SURNAME,nameAndSurname);
                startActivity(intent);


            }
        });
    }

}