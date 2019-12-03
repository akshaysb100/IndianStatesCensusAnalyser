package com.stateinformation.com;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus implements Comparable {

    @CsvBindByName(column = "StateName")
    private String stateName  ;

    @CsvBindByName(column = "Population")
    private String population;

    @CsvBindByName(column = "AreaInSqKm")
    private  int areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm")
    private int densityPerSqKm;

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

    public int getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(int areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    public int getDensityPerSqKm() {
        return densityPerSqKm;
    }

    public void setDensityPerSqKm(int densityPerSqKm) {
        this.densityPerSqKm = densityPerSqKm;
    }

    @Override
    public String toString() {
        return "CSVStateCensus{" +
                "stateName='" + stateName + '\'' +
                ", population='" + population + '\'' +
                ", areaInSqKm=" + areaInSqKm +
                ", densityPerSqKm=" + densityPerSqKm +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        return this.getStateName().compareTo(((CSVStateCensus)o).getStateName());
    }
}
