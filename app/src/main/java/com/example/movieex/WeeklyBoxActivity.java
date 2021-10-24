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

public class WeeklyBoxActivity extends AppCompatActivity {
    private EditText ed_Year,ed_Month,ed_Day;
    private Button btnS;
    private MyAdapter ma;
    private RecyclerView rvlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_box);
        ed_Year = findViewById(R.id.ed_Year);
        ed_Month = findViewById(R.id.ed_Month);
        ed_Day = findViewById(R.id.ed_Day);
        btnS = findViewById(R.id.btnS);

        ma = new MyAdapter();
        //ma.setLayout(레이아웃 번호);
        rvlist = findViewById(R.id.rvT);
        rvlist.setAdapter(ma);
    }
    public void searchClick(View v){
        String targetDt =
        ed_Year.getText().toString()+
        ed_Month.getText().toString()+
        ed_Day.getText().toString();
        if(targetDt.length()==8){
            Network.onNetwork(targetDt,ma);
        }else{
            Snackbar.make(v, "SnackBar Message, 커스텀", Snackbar.LENGTH_SHORT)
                    // 스낵바 Action 설정("표시할 텍스트", onClick)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // 스낵바의 OK 클릭시 실행할 작업
                            Toast.makeText(view.getContext(), "스낵바 Action 클릭", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
        }
    }
}