package com.stateinformation.com;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class StateAnalyser  {

    private String SAMPLE_JSON_FILE_PATH = "/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/csvtojsonsotfile";
    private String SAMPLE_JSON_FILE_BASED_ON_POPULATION= "/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/csvfilebaseonpopulation.json";
    private String SAMPLE_JSON_FILE_BASED_ON_DensityPerSqKm="/home/user/IdeaProjects/IndianStatesCensusAnalysers/src/main/java/com/stateinformation/com/sortcsvfilebasedondensitypersqkm.json";
    List<CSVStateCensus> csvStateCensuses = new ArrayList<>();
    public int openCSVBuilder(String STATE_CENSUS_DATA_CSV_FILE_PATH) throws StateException {
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
                csvStateCensuses.add(csvUser);
                count++;
            }
        } catch (NoSuchFileException e){
            throw new StateException(StateException.ExceptionType.NO_SUCH_FILE, "please Enter proper file path or type ", e);
        } catch (RuntimeException e) {
            throw new StateException(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, "File Delimiter is incorrect or header is incorrect", e);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int SortCSvFile(String STATE_CENSUS_DATA_CSV_FILE_PATH) throws IOException, StateException {

        int count = openCSVBuilder(STATE_CENSUS_DATA_CSV_FILE_PATH);
        Comparator<CSVStateCensus> c = (s1, s2) -> s1.getStateName().compareTo(s2.getStateName());
        csvStateCensuses.sort(c);
        writeDataCSVToJson(csvStateCensuses,SAMPLE_JSON_FILE_PATH);
        return count;
    }

    public int sortThisListBasedOnPopulation(String STATE_CENSUS_DATA_CSV_FILE_PATH) throws IOException, StateException {

        int count = openCSVBuilder(STATE_CENSUS_DATA_CSV_FILE_PATH);
        Comparator<CSVStateCensus> c = (s1, s2) -> Integer.parseInt(s2.getPopulation()) - Integer.parseInt(s1.getPopulation());
        csvStateCensuses.sort(c);
        writeDataCSVToJson(csvStateCensuses,SAMPLE_JSON_FILE_BASED_ON_POPULATION);
        return count;
    }

    public int sortThisListBasedOnDensityPerSqKm(String STATE_CENSUS_DATA_CSV_FILE_PATH) throws IOException, StateException {

        int count = openCSVBuilder(STATE_CENSUS_DATA_CSV_FILE_PATH);
        Comparator<CSVStateCensus> c = (s1, s2) -> Integer.parseInt(s2.getDensityPerSqKm()) - Integer.parseInt(s1.getDensityPerSqKm());
        csvStateCensuses.sort(c);
        writeDataCSVToJson(csvStateCensuses,SAMPLE_JSON_FILE_BASED_ON_DensityPerSqKm);
        return count;
    }

    public void writeDataCSVToJson(List<CSVStateCensus> list,String filePath) throws IOException {

        Gson gson = new Gson();
        String json = gson.toJson(list);
        FileWriter writer = new FileWriter(filePath);
        writer.write(json);
        writer.close();
    }
}
