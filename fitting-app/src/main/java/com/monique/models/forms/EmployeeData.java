package com.monique.models.forms;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class EmployeeData {

    private static final String DATA_FILE = "employee_list.csv";
    private static boolean isDataLoaded = false;

    private static ArrayList<HashMap<String, String>> allEmployees;

    public static ArrayList<String> findAll(String field) {

        loadData();
        ArrayList<String> values = new ArrayList<>();

        for (HashMap<String, String> row : allEmployees) {
            String aValue = row.get(field);

            if (!values.contains(aValue)) {
                values.add(aValue);
            }
        }
        Collections.sort(values);
        return values;
    }

    public static ArrayList<HashMap<String, String>> findAll() {
        loadData();

        return new ArrayList<>(allEmployees);
    }

    public static ArrayList<HashMap<String, String>> findByColumnAndValue(String column, String value) {

        loadData();

        ArrayList<HashMap<String, String>> employee = new ArrayList<>();

        for (HashMap<String, String> row : allEmployees) {
            String aValue = row.get(column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                employee.add(row);
            }
        }
        return employee;
    }
    private static void loadData() {
        if (isDataLoaded) {
            return;
        }

        try {
            Resource resource = new ClassPathResource(DATA_FILE);
            InputStream is = resource.getInputStream();
            Reader reader = new InputStreamReader(is);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            allEmployees = new ArrayList<>();

            for (CSVRecord record : records) {
                HashMap<String, String> newEmployee = new HashMap<>();
                for (String headerLabel : headers) {
                    newEmployee.put(headerLabel, record.get(headerLabel));
                }
                allEmployees.add(newEmployee);
            }

            isDataLoaded = true;
        }catch (IOException e) {
            System.out.println("Failed to load employee data");
            e.printStackTrace();
        }
    }

    public static ArrayList<HashMap<String, String>> findByColumnAndValue(String empSearch) {

        return null;
    }
}
