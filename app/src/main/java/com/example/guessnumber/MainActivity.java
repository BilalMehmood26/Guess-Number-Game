package com.example.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText enterNumber;
    int guessNumber;
    Button guessBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessBtn = findViewById(R.id.Guess_Button);

        Random randomNumber = new Random();
        guessNumber = randomNumber.nextInt(20) + 1;

        guessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess();
            }
        });

    }

    public void guess() {


        enterNumber = findViewById(R.id.editText_enter_Number);
        int guessInt = Integer.parseInt(enterNumber.getText().toString());

        if (guessInt > guessNumber) {
            makingToast("Your Guess is Grater!");

        } else if (guessInt < guessNumber) {
            makingToast("Your Guess is Lower!");
        }else{
            makingToast("Wooohooo That's Right!  Wanna Try Again?");
            Random randomNumber = new Random();
            guessNumber = randomNumber.nextInt(10) + 1;

        }


    }

    public void makingToast(String string) {

        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
