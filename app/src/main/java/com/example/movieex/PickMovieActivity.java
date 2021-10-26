package com.example.movieex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.movieex.connection.MyAdapter2;
import com.example.movieex.connection.Network;

public class PickMovieActivity extends AppCompatActivity {
    private RecyclerView reView;
    private Button pick;
    private MyAdapter2 mad;
    //todo 네트워크 새설정, 어뎁터?? 페이징
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_movie);
        reView = findViewById(R.id.reView);
        pick = findViewById(R.id.pick);
        mad = new MyAdapter2(R.layout.item_movielist);
        reView.setAdapter(mad);
        reView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView rView, int newState) {
                if((rView.canScrollVertically(1))&&(newState==RecyclerView.SCROLL_STATE_IDLE)){
                    Log.i("myLog","스크롤끝");
                }
            }

//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//            }
        });
        Network.onNetwork(mad);
    }
}