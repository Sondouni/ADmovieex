package com.example.movieex.connection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieex.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<BoxOfficeVO> list;
    public void setList(List<BoxOfficeVO> list){this.list = list;}
    private int layout = R.layout.item_rvt;

    public void setLayout(int layout) {
        this.layout = layout;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_rvt, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null? 0:list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{ // 이것도 콜백으로 만들어서 쓰일때마다 바꿀수 잇을까?
        private TextView tvTitel,tvDate,tvAud,tvRank;
        public MyViewHolder(View v){
            super(v);
            tvTitel = v.findViewById(R.id.tvTitel);
            tvDate = v.findViewById(R.id.tvDate);
            tvAud = v.findViewById(R.id.tvAud);
            tvRank = v.findViewById(R.id.tvRank);
        }
        public void setItem(BoxOfficeVO vo){
            tvTitel.setText(vo.getMovieNm());
            tvDate.setText(vo.getOpenDt());
            tvAud.setText(vo.getAudiCnt());
            tvRank.setText(vo.getRank());
        }
    }
}
