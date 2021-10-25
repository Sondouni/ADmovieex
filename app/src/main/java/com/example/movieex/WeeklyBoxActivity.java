package com.example.movieex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movieex.connection.MyAdapter;
import com.example.movieex.connection.Network;
import com.google.android.material.snackbar.Snackbar;

public class WeeklyBoxActivity extends AppCompatActivity {
    private TextView cd1;
    private CalendarView clv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_box);
        cd1 = findViewById(R.id.cd1);
        clv1 = findViewById(R.id.clv1);
        clv1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month+=1;

//                String.format("%d년 %2d월 %d일",year,month,dayOfMonth);
                String date = String.format("%s%02d%02d", year, month, dayOfMonth);
                cd1.setText(date);
            }
        });
    }
}