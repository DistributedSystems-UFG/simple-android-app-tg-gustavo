package com.example.my1stapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DaysBeforeBirthdayActivity extends AppCompatActivity {


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_before_birthday);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String text = calcularAniversario(intent.getStringExtra(DisplayMessageActivity.EXTRA_DATA_ANIVERSARIO));

        TextView textView = findViewById(R.id.tvTextoDiasParaAniversario);
        textView.setText(text);

    }

    private String calcularAniversario(String textDataAniversario){
        String[] arr = textDataAniversario.split("/");
        int dia = Integer.parseInt(arr[0]);
        int mes = Integer.parseInt(arr[1]);
        int ano = Integer.parseInt(arr[2]);
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(ano, mes, dia);

        LocalDate nextBDay = birthday.withYear(today.getYear());

        //If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);
        return "Faltam " + p.getMonths() + " meses, e " +
                p.getDays() + " dias até seu próximo aniversário. (" +
                p2 + " dias no total)";
    }

}
