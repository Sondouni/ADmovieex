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
class MovieListAdapter extends MyAdapter{
    static class MyViewHolder extends MyAdapter.MyViewHolder{
        //todo 레이아웃 아이템만들기, 어뎁터 상속버전
        public MyViewHolder(View v){
            super(v);
        }
    }
}
/*
//todo 어뎁터 오버로딩버전, 어뎁터생성할때 R.layout.레이아웃 입력하자
public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    private List<BoxOfficeVO> list;
    public void setList(List<BoxOfficeVO> list){this.list = list;}
    private int layout;

    public MyAdapter2(int layout){
        this.layout = layout;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(layout, parent,false);
        return new MyViewHolder(v,layout);
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
        private TextView tvMovieNm,tvMovieNmEn,tvOpenDt,tvDirectors,tvGenre,tvNational;

        public MyViewHolder(View v, int num){
            super(v);
            switch (num){
                case R.layout.item_rvt:
                    tvTitel = v.findViewById(R.id.tvTitel);
                    tvDate = v.findViewById(R.id.tvDate);
                    tvAud = v.findViewById(R.id.tvAud);
                    tvRank = v.findViewById(R.id.tvRank);
                    break;
                case R.layout.item_movielist:
                    tvMovieNm = v.findViewById(R.id.tvMovieNm);
                    tvMovieNmEn = v.findViewById(R.id.tvMovieNmEn);
                    tvOpenDt = v.findViewById(R.id.tvOpenDt);
                    tvDirectors = v.findViewById(R.id.tvDirectors);
                    tvGenre = v.findViewById(R.id.tvGenre);
                    tvNational = v.findViewById(R.id.tvNational);
                    break;
            }
        }
        public void setItem(BoxOfficeVO vo){
            tvTitel.setText(vo.getMovieNm());
            tvDate.setText(vo.getOpenDt());
            tvAud.setText(vo.getAudiCnt());
            tvRank.setText(vo.getRank());
        }
        public void setItem(MovieListVO vo){
            tvMovieNm.setText(vo.getMovieNm());
            tvMovieNmEn.setText(vo.getMovieNmEn());
            tvOpenDt.setText(vo.getOpenDt());
            tvDirectors.setText(vo.getPeopleNm());
            tvGenre.setText(vo.getRepGenreNm());
            tvNational.setText(vo.getRepNationNm());
        }
    }
}
*/