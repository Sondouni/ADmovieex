package com.example.movieex.connection;

import android.util.Log;

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
    final static String ITEM_PER_PAGE = "20";
    static int curPage = 1;
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
    public static void onNetwork(String targetDt, MyAdapter ma, String weekGb){
        RetrofitService sv = rf.create(RetrofitService.class);
        Call<BoxOfficeResultBodyVO> call = sv.searchWeeklyBoxOfficeList(KEY,targetDt,weekGb);
        call.enqueue(new Callback<BoxOfficeResultBodyVO>() {
            @Override
            public void onResponse(Call<BoxOfficeResultBodyVO> call, Response<BoxOfficeResultBodyVO> response) {
                if(response.isSuccessful()){
                    BoxOfficeResultBodyVO vo = response.body();
                    BoxOfficeResultVO resultVO = vo.getBoxOfficeResult();
                    List<BoxOfficeVO> list = resultVO.getWeeklyBoxOfficelist();
                    ma.setList(list);
                    ma.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<BoxOfficeResultBodyVO> call, Throwable t) {

            }
        });
    }
    public static void onNetwork(MyAdapter2 ma){
        RetrofitService sv = rf.create(RetrofitService.class);
        Call<MovieListResultBodyVO> call = sv.searchMovieList(KEY,(curPage++)+"",ITEM_PER_PAGE);
        call.enqueue(new Callback<MovieListResultBodyVO>() {
            @Override
            public void onResponse(Call<MovieListResultBodyVO> call, Response<MovieListResultBodyVO> response) {
                if(response.isSuccessful()){
                    MovieListResultBodyVO vo = response.body();
                    MovieListResultVO resultVO = vo.getMovieListResult();
                    List<MovieListVO> list = resultVO.getMovieList();
                    for (MovieListVO item : list) {
                        Log.i("myLog", item.getPeopleNm());
                    }
                    ma.setList1(list);
                    ma.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MovieListResultBodyVO> call, Throwable t) {
                Log.i("myLog","");
            }
        });
    }
}
