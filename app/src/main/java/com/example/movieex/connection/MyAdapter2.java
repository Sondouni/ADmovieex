package com.example.movieex.connection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieex.R;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
        private List<BoxOfficeVO> list;
        private List<MovieListVO> list1;
        public void setList(List<BoxOfficeVO> list){this.list = list;}
        public void setList1(List<MovieListVO> list1){this.list1 = list1;}
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
            holder.setItem(list1.get(position));
        }
//todo list / list1을 구분하는 방법?
        @Override
        public int getItemCount() {
            if(layout == R.layout.item_rvt){
                return  list == null? 0:list.size();
            }else if(layout == R.layout.item_movielist){
                return  list1 == null? 0:list1.size();
            }else {
                return 0;
            }
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
//                tvDirectors.setText(vo.getPeopleNm());
                tvGenre.setText(vo.getRepGenreNm());
                tvNational.setText(vo.getRepNationNm());
            }
        }
}

