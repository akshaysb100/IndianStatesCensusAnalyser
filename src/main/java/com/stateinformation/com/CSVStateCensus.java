package com.stateinformation.com;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus implements Comparable {

    @CsvBindByName(column = "StateName")
    private String stateName  ;

    @CsvBindByName(column = "Population")
    private String population;

    @CsvBindByName(column = "AreaInSqKm")
    private  String areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm")
    private String densityPerSqKm;

    public CSVStateCensus() {
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(String areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    public String getDensityPerSqKm() {
        return densityPerSqKm;
    }

    public void setDensityPerSqKm(String densityPerSqKm) {
        this.densityPerSqKm = densityPerSqKm;
    }

    @Override
    public int compareTo(Object o) {
        return this.getStateName().compareTo(((CSVStateCensus)o).getStateName());
    }
}
