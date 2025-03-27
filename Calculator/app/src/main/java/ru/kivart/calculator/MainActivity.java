package ru.kivart.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        EditText editTextAnswer = findViewById(R.id.editTextAnswer);
        Button buttonAnswer = findViewById(R.id.buttonAnswer);
        TextView textViewCorrectAnswer = findViewById(R.id.textViewCorrectAnswer);
        TextView textViewIncorrectAnswer = findViewById(R.id.textViewIncorrectAnswer);
        TextView textViewExample = findViewById(R.id.textViewExample);

        textViewExample.setText("10 + 20 = ?");

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextAnswer.getText().toString();
                if (text.equals("30")) {
                    textViewCorrectAnswer.setVisibility(View.VISIBLE);
                    textViewIncorrectAnswer.setVisibility(View.GONE);
                } else {
                    textViewCorrectAnswer.setVisibility(View.GONE);
                    textViewIncorrectAnswer.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}