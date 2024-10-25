package com.example.formvalidationapp;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextEmail;
    private EditText editTextNumertel;
    private EditText editTextHaslo;
    private EditText editTextPowtorzHaslo;
    private Button buttonSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextNumertel = findViewById(R.id.editTextNumertel);
        editTextHaslo = findViewById(R.id.editTextHaslo);
        editTextPowtorzHaslo = findViewById(R.id.editTextPowtorzHaslo);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String name = editTextName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String Numertel = editTextNumertel.getText().toString().trim();
                String Haslo = editTextHaslo.getText().toString().trim();
                String PowtorzHaslo = editTextPowtorzHaslo.getText().toString().trim();


                if(name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię", Toast.LENGTH_SHORT).show();
                }else if (surname.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();
                }
                else if (email.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić email", Toast.LENGTH_SHORT).show();
                }else if
                (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(MainActivity.this, "Niepoprawny adres email", Toast.LENGTH_SHORT).show();
                }else if (Numertel.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić numer telefonu", Toast.LENGTH_SHORT).show();
                }else if (Numertel.length()<9){
                    Toast.makeText(MainActivity.this, "Podany numer telefonu jest nieprawidłowy! (Musi zawierać 9 znaków)", Toast.LENGTH_SHORT).show();
                }
                else if (Haslo.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić haslo", Toast.LENGTH_SHORT).show();
                }else if (Haslo.length()<6){
                    Toast.makeText(MainActivity.this, "Haslo jest za krotkie! Musie mieć ono conajmniej 6 znakow", Toast.LENGTH_SHORT).show();
                }
                else if (PowtorzHaslo.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Powtorz haslo", Toast.LENGTH_SHORT).show();
                }else if (!Haslo.matches(PowtorzHaslo)){
                    Toast.makeText(MainActivity.this, "Zle powtorzone haslo!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Formularz przeslany poprawnie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}