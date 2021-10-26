package com.example.movieex.connection;

import java.util.List;

public class MovieListResultVO {
    private int totCnt;
    private String source;
    private List<MovieListVO> movieList;

    public int getTotCnt() {
        return totCnt;
    }

    public void setTotCnt(int totCnt) {
        this.totCnt = totCnt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<MovieListVO> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieListVO> movieList) {
        this.movieList = movieList;
    }
}
