package com.example.my1stapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    public static final String EXTRA_DATA_ANIVERSARIO = "com.example.my1stapplication.DATA_ANIVERSARIO";
    EditText data1;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        data1 = findViewById(R.id.data1);
        calcular = findViewById(R.id.btCalcular);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        String textWelcoming = "Olá " + message + ", informe sua data de nascimento:";
        textView.setText(textWelcoming);

    }

    public void calcularAniversario(View view){

        Intent intent = new Intent(this, DaysBeforeBirthdayActivity.class);
        String dataAniversario = data1.getText().toString();
        intent.putExtra(EXTRA_DATA_ANIVERSARIO, dataAniversario);
        startActivity(intent);

    }

}