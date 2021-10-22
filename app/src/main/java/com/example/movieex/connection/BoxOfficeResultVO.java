package com.example.movieex.connection;

import java.util.List;

public class BoxOfficeResultVO {
    private String boxofficeType;
    private String showRange;
    private String yearWeekTime;
    private List<BoxOfficeVO> weeklyBoxOfficeList;
    private List<BoxOfficeVO> dailyBoxOfficeList;

    public String getYearWeekTime() {
        return yearWeekTime;
    }

    public void setYearWeekTime(String yearWeekTime) {
        this.yearWeekTime = yearWeekTime;
    }

    public List<BoxOfficeVO> getWeeklyBoxOfficelist() { return weeklyBoxOfficeList;}

    public List<BoxOfficeVO> getDailyBoxOfficeVOList() { return dailyBoxOfficeList;    }
    public void setWeeklyBoxOfficelist(List<BoxOfficeVO> weeklyBoxOfficelist) {
        this.weeklyBoxOfficeList = weeklyBoxOfficelist;
    }

    public List<BoxOfficeVO> getDailyBoxOfficeList() {
        return dailyBoxOfficeList;
    }

    public void setDailyBoxOfficeList(List<BoxOfficeVO> dailyBoxOfficeList) {
        this.dailyBoxOfficeList = dailyBoxOfficeList;
    }


    public String getBoxofficeType() {
        return boxofficeType;
    }

    public void setBoxofficeType(String boxofficeType) {
        this.boxofficeType = boxofficeType;
    }

    public String getShowRange() {
        return showRange;
    }

    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }



    public void setDailyBoxOfficeVOList(List<BoxOfficeVO> dailyBoxOfficeVOList) {
        this.dailyBoxOfficeList = dailyBoxOfficeVOList;
    }
}
