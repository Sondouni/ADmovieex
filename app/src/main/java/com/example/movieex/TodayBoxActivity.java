package com.example.movieex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movieex.connection.MyAdapter;
import com.example.movieex.connection.Network;
import com.google.android.material.snackbar.Snackbar;

public class TodayBoxActivity extends AppCompatActivity {
    private EditText ed_Year,ed_Month,ed_Day;
    private Button btnS;
    private MyAdapter ma;
    private RecyclerView rvlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_box);
        ed_Year = findViewById(R.id.ed_Year);
        ed_Month = findViewById(R.id.ed_Month);
        ed_Day = findViewById(R.id.ed_Day);
        btnS = findViewById(R.id.btnS);

        ma = new MyAdapter();
        //ma.setLayout(레이아웃 번호);
        rvlist = findViewById(R.id.rvT);
        rvlist.setAdapter(ma);
    }
    public void searchClick(View v0){
        String targetDt =
                ed_Year.getText().toString()+
                        ed_Month.getText().toString()+
                        ed_Day.getText().toString(); //하나하나 확인하기 귀찮네,,,
        if(targetDt.length()==8
                && (Integer.parseInt(ed_Year.getText().toString()))>0
                && (Integer.parseInt(ed_Year.getText().toString()))<=2021
                && (Integer.parseInt(ed_Month.getText().toString()))>0
                && (Integer.parseInt(ed_Month.getText().toString()))<=12
                && (Integer.parseInt(ed_Day.getText().toString()))>0
                && (Integer.parseInt(ed_Day.getText().toString()))<=30){
            Network.onNetwork(targetDt,ma);
        }else{
            Snackbar.make(v0, "Are you Sure", Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener()  { //스낵바 Action 설정("표시할 텍스트", onClick)
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(v0.getContext(), "Plz type right text", Toast.LENGTH_SHORT).show();
                                }
                            }).show();
            ed_Year.setText("");
            ed_Month.setText("");
            ed_Day.setText("");
        }
    }
}