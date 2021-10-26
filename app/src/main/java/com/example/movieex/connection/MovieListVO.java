package com.example.movieex.connection;

public class MovieListVO {
    private String movieNm;
    private String movieNmEn;
    private String movieCd;
    private String repNationNm;
    private String repGenreNm;
    private String peopleNm;
    private String openDt;
    private DirectorsVO peopleNmm;//리스트를해야하나?
    //todo 피플네임 가져오긴 했는데 가능?


    public String getPeopleNm() {
        return peopleNm;
    }

    public void setPeopleNm() {
        this.peopleNm = ( new DirectorsVO()).getPeopleNm();
    }



    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }
    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public String getMovieNmEn() {
        return movieNmEn;
    }

    public void setMovieNmEn(String movieNmEn) {
        this.movieNmEn = movieNmEn;
    }

    public String getMovieCd() {
        return movieCd;
    }

    public void setMovieCd(String movieCd) {
        this.movieCd = movieCd;
    }

    public String getRepNationNm() {
        return repNationNm;
    }

    public void setRepNationNm(String repNationNm) {
        this.repNationNm = repNationNm;
    }

    public String getRepGenreNm() {
        return repGenreNm;
    }

    public void setRepGenreNm(String repGenreNm) {
        this.repGenreNm = repGenreNm;
    }
}
