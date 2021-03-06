package com.example.movieex.connection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    // 데일리
    @GET("boxoffice/searchDailyBoxOfficeList.json")
    Call<BoxOfficeResultBodyVO> searchDailyBoxOfficeList (@Query("key") String key
            , @Query("targetDt") String targetDt);
    // 위클리
    @GET("boxoffice/searchWeeklyBoxOfficeList.json")
    Call<BoxOfficeResultBodyVO> searchWeeklyBoxOfficeList (@Query("key") String key
            , @Query("targetDt") String targetDt,@Query("weekGb")String weekGb);

    //영화목록 가져오기
    @GET("movie/searchMovieList.json")
    Call<MovieListResultBodyVO> searchMovieList (@Query("key") String key
            ,@Query("curPage") String curPage,@Query("itemPerPage") String itemPerPage);
}
