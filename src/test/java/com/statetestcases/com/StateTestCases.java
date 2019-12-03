package com.statetestcases.com;

import com.stateinformation.com.StateAnalyser;
import com.stateinformation.com.StateException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateTestCases {

    @Test
    public void check_StateCensusDataFile_ReturnHowMuchRecord() throws StateException {

        StateAnalyser stateAnalyser = new StateAnalyser();
        Assert.assertEquals(29,stateAnalyser.openCSVBuilder("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.csv"));
    }

    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileName_ThrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29,stateAnalyser.openCSVBuilder("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusDat.csv"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileType_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29,stateAnalyser.openCSVBuilder("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.type"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenDelimiterIncorrect_ThrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29,stateAnalyser.openCSVBuilder("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.csv"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenHeaderIncorrect_ThrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29,stateAnalyser.openCSVBuilder("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.csv"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }

    @Test
    public void sortSCVFile_ToJsonFile_AlphabeticalOrder() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29,stateAnalyser.SortCSvFile("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.csv"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sortSCVFile_UsingPopulationOfState_AlphabeticalOrder() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29,stateAnalyser.sortThisListBasedOnPopulation("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.csv"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sortSCVFile_UsingPopulationOfState_WhenIncorrectFileType_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29,stateAnalyser.sortThisListBasedOnPopulation("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.txt"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sortSCVFile_UsingPopulationOfState_WhenIncorrectFileName_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29,stateAnalyser.sortThisListBasedOnPopulation("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusDat.csv"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sortSCVFile_UsingDensityPerSqKmOfState_AlphabeticalOrder() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29,stateAnalyser.sortThisListBasedOnDensityPerSqKm("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.csv"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sortSCVFile_UsingDensityPerSqKmOfState_WhenIncorrectFileType_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(29,stateAnalyser.sortThisListBasedOnDensityPerSqKm("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.txt"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sortSCVFile_UsingDensityPerSqKmOfState_WhenIncorrectFileName_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            Assert.assertEquals(true,stateAnalyser.sortThisListBasedOnDensityPerSqKm("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusDat.csv"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            Assert.assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
