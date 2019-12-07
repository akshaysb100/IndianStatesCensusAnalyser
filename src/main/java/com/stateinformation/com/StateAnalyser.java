package com.stateinformation.com;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class StateAnalyser {

    List<CSVStateCensus> csvStateCensusesList = new ArrayList<>();

    public int readCSVFile(String STATE_CENSUS_DATA_CSV_FILE_PATH) throws StateException {

        int count = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(STATE_CENSUS_DATA_CSV_FILE_PATH));
            CsvToBean<CSVStateCensus> cavToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStateCensus> csvUserIterator = cavToBean.iterator();
            while (csvUserIterator.hasNext()) {
                CSVStateCensus csvUser = csvUserIterator.next();
                csvStateCensusesList.add(csvUser);
                count++;
            }
        } catch (NoSuchFileException e) {
            throw new StateException(StateException.ExceptionType.NO_SUCH_FILE,
                    "please Enter proper file path or type ", e);
        } catch (RuntimeException e) {
            throw new StateException(StateException.ExceptionType.SOME_OTHER_FILE_ERROR,
                    "File Delimiter is incorrect or header is incorrect", e);
        } catch (IOException e) {
            throw new StateException(StateException.ExceptionType.SOME_OTHER_FILE_ERROR,
                    "File Delimiter is incorrect or header is incorrect", e);
        }
        return count;
    }

    public void writeDataCSVToJson(List<CSVStateCensus> list, String filePath) throws StateException {

        Gson gson = new Gson();
        String json = gson.toJson(list);
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new StateException(StateException.ExceptionType.SOME_OTHER_FILE_ERROR,
                    "File Delimiter is incorrect or header is incorrect", e);
        }
    }

    public boolean sortDetails(String csvFile, String fieldName, String SAMPLE_JSON_FILE_BASED_ON_FIELD) throws StateException {

        readCSVFile(csvFile);
        Collections.sort(csvStateCensusesList, new Comparator<CSVStateCensus>() {
            @Override
            public int compare(CSVStateCensus o1, CSVStateCensus o2) {
                try {
                    Field fieldType = CSVStateCensus.class.getDeclaredField(fieldName);
                    fieldType.setAccessible(true);
                    Comparable stateCensusFieldValue1 = (Comparable) fieldType.get(o1);
                    Comparable stateCensusFieldValue2 = (Comparable) fieldType.get(o2);
                    return stateCensusFieldValue1.compareTo(stateCensusFieldValue2);
                } finally {
                    return 0;
                }
            }
        });
        writeDataCSVToJson(csvStateCensusesList, SAMPLE_JSON_FILE_BASED_ON_FIELD);
        return true;
    }
}

