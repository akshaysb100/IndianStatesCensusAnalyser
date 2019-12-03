package com.statetestcases.com;

import com.stateinformation.com.StateAnalyser;
import com.stateinformation.com.StateException;
import org.junit.Assert;
import org.junit.Test;

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
}
