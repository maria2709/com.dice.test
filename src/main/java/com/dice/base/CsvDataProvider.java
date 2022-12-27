package com.dice.base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class CsvDataProvider {
    @DataProvider(name="CsvDataProvider")
    public static Iterator<Object[]> provideData(Method method) throws CsvValidationException {
        List<Object[]> list = new ArrayList<>();
        String pathName = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "test_data" +
                File.separator + method.getDeclaringClass().getSimpleName() + "_" +
                method.getName() + ".csv";
        File file = new File(pathName);
        try{
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String [] keys = csvReader.readNext();
            if (keys != null) {
                String dataParts[];
                while ((dataParts = csvReader.readNext()) != null){
                    Map<String, String> testData = new HashMap<>();
                    for (int i = 0; i < keys.length; i++) {
                        testData.put(keys[i], dataParts[i]);
                    }
                    list.add(new Object[] { testData });
                }
            }
            csvReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file " + pathName + " was not found \n" + e.getStackTrace().toString());
        } catch (IOException e) {
            throw new RuntimeException("Could not read " + pathName + "file \n" + e.getStackTrace());
        }
        return list.iterator();
    }
}
