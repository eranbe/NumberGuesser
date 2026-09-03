package com.eranbe.numberguesser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnGuess;
    private EditText etGuess;

    private int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
    }

    private void init() {
        btnGuess = findViewById(R.id.btnGuess);
        etGuess = findViewById(R.id.etGuess);

        num = new Random().nextInt(100) + 1;

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guessStr = etGuess.getText().toString();
                int guessNum = Integer.parseInt(guessStr);

                if (guessNum == num) {
                    Toast.makeText(MainActivity.this, "Winner!", Toast.LENGTH_SHORT).show();
                } else if (guessNum < num) {
                    Toast.makeText(MainActivity.this, "Too low", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Too high", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}