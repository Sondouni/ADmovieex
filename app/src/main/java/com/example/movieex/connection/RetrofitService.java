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
    @GET("boxoffice/searchWeeklyBoxOfficeList.json?weekGb=1")
    Call<BoxOfficeResultBodyVO> searchWeeklyBoxOfficeList(@Query("Key") String key
            , @Query("targetDt") String targetDt);
}
