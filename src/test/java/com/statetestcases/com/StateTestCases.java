package com.statetestcases.com;

import com.stateinformation.com.StateAnalyser;
import com.stateinformation.com.StateException;
import org.junit.Assert;
import org.junit.Test;

public class StateTestCases {

    String STATE_CENSUS_DATA_CSV_FILE = "/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.csv";
    String SAMPLE_JSON_FILE_BASED_ON_STATE_NAME = "/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/jsonfile/csvtojsonsotfile.JSON";
    String SAMPLE_JSON_FILE_BASED_ON_POPULATION = "/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/jsonfile/csvfilebaseonpopulation.json";
    String SAMPLE_JSON_FILE_BASED_ON_DENSITY_PER_SQ_KM = "/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/jsonfile/sortcsvfilebasedondensitypersqkm.json";
    String SAMPLE_JSON_FILE_BASED_ON_AREA_IN_SQ_KM = "/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/jsonfile/sortcsvfilebasedonareaInSqKm.json";

    @Test
    public void check_StateCensusDataFile_ReturnHowMuchRecord() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29, stateAnalyser.readCSVFile("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.csv"));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileName_ThrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29, stateAnalyser.readCSVFile("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusDat.csv"));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileType_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29, stateAnalyser.readCSVFile(
                    "/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.type"));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenDelimiterIncorrect_ThrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29, stateAnalyser.readCSVFile("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.csv"));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenHeaderIncorrect_ThrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29, stateAnalyser.readCSVFile("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.csv"));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }

    @Test
    public void sortSCVFile_ToJsonFile_AlphabeticalOrder() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(true, stateAnalyser.sortDetails(STATE_CENSUS_DATA_CSV_FILE,
                    "stateName", SAMPLE_JSON_FILE_BASED_ON_STATE_NAME));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }

    @Test
    public void sortSCVFile_UsingPopulationOfState_AlphabeticalOrder() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(true, stateAnalyser.sortDetails(STATE_CENSUS_DATA_CSV_FILE,
                    "population", SAMPLE_JSON_FILE_BASED_ON_POPULATION));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }

    @Test
    public void sortSCVFile_UsingPopulationOfState_WhenIncorrectFileType_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(true, stateAnalyser.sortDetails("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.txt",
                    "population", SAMPLE_JSON_FILE_BASED_ON_POPULATION));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void sortSCVFile_UsingPopulationOfState_WhenIncorrectFileName_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(true, stateAnalyser.sortDetails("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusDat.csv",
                    "population", SAMPLE_JSON_FILE_BASED_ON_POPULATION));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void sortSCVFile_UsingDensityPerSqKmOfState_AlphabeticalOrder() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(true, stateAnalyser.sortDetails(STATE_CENSUS_DATA_CSV_FILE,
                    "densityPerSqKm", SAMPLE_JSON_FILE_BASED_ON_DENSITY_PER_SQ_KM));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }

    @Test
    public void sortSCVFile_UsingDensityPerSqKmOfState_WhenIncorrectFileType_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(true, stateAnalyser.sortDetails(
                    "/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.txt",
                    "densityPerSqKm", SAMPLE_JSON_FILE_BASED_ON_DENSITY_PER_SQ_KM));
        } catch (StateException e) {
            System.out.println("Exception is : " + e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void sortSCVFile_UsingDensityPerSqKmOfState_WhenIncorrectFileName_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(true, stateAnalyser.sortDetails(
                    "/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusDat.csv",
                    "densityPerSqKm", SAMPLE_JSON_FILE_BASED_ON_DENSITY_PER_SQ_KM));
        } catch (StateException e) {
            System.out.println("Exception is : " + e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void sortSCVFile_UsingAreaInSqKmOfState_AlphabeticalOrder() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(true, stateAnalyser.sortDetails(STATE_CENSUS_DATA_CSV_FILE,
                    "areaInSqKm", SAMPLE_JSON_FILE_BASED_ON_AREA_IN_SQ_KM));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }

    @Test
    public void sortSCVFile_UsingAreaInSqKmOfState_WhenIncorrectFileType_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(true, stateAnalyser.sortDetails(
                    "/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.txt",
                    "areaInSqKm", SAMPLE_JSON_FILE_BASED_ON_AREA_IN_SQ_KM));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void sortSCVFile_UsingAreaInSqKmOfState_WhenIncorrectFileName_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(true, stateAnalyser.sortDetails(
                    "/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusDat.csv",
                    "areaInSqKm", SAMPLE_JSON_FILE_BASED_ON_AREA_IN_SQ_KM));
        } catch (StateException e) {
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
}
