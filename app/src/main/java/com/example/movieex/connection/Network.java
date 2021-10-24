package com.example.movieex.connection;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    static Retrofit rf = new Retrofit.Builder()
            .baseUrl("https://www.kobis.or.kr/kobisopenapi/webservice/rest/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    final static String KEY = "71ebaabe99c41b10686133dae485862a";

    public static void onNetwork(String targetDt, MyAdapter ma){
        RetrofitService sv = rf.create(RetrofitService.class);
        Call<BoxOfficeResultBodyVO> call = sv.searchDailyBoxOfficeList(KEY,targetDt);
        call.enqueue(new Callback<BoxOfficeResultBodyVO>() {
            @Override
            public void onResponse(Call<BoxOfficeResultBodyVO> call, Response<BoxOfficeResultBodyVO> response) {
                if(response.isSuccessful()){
                    BoxOfficeResultBodyVO vo = response.body();
                    BoxOfficeResultVO resultVO = vo.getBoxOfficeResult();
                    List<BoxOfficeVO> list = resultVO.getDailyBoxOfficeList();
                    ma.setList(list);
                    ma.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<BoxOfficeResultBodyVO> call, Throwable t) {

            }
        });
    }
}
