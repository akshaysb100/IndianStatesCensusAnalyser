package com.statetestcases.com;

import com.stateinformation.com.StateAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class StateTestCases {

    @Test
    public void check_StateCensusDataFile_ReturnHowMuchRecord() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        Assert.assertEquals(29,stateAnalyser.openCSVBuilder("/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/StateCensusData.csv"));
    }
}
