package com.example.bookingfilght.Models;

import java.util.Date;

public class CovidCaseDTO {

    private Integer cases;
    private Integer todayCases;

    private Integer deaths;
    private Integer todayDeaths;
    private Integer recovered;
    private Integer todayRecovered;
    private Integer tests;

    public CovidCaseDTO( Integer cases, Integer todayCases, Integer deaths, Integer todayDeaths, Integer recovered, Integer todayRecovered, Integer tests) {
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.tests = tests;
    }


    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(Integer todayCases) {
        this.todayCases = todayCases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(Integer todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(Integer todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public Integer getTests() {
        return tests;
    }

    public void setTests(Integer tests) {
        this.tests = tests;
    }
}
