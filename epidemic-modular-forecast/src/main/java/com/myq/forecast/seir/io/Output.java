package com.myq.forecast.seir.io;

import com.myq.forecast.seir.population.SeirRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author 毛一钦
 * @Date 2022/3/18 10:25
 * @Description     单例模式
 **/
public enum  Output {

    // 外调方法
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(Output.class);

    /**
     * @Author 毛一钦
     * @Date 2022/3/18 10:26
     * @Description printSeirCSV    存入csv表格
     * @param records
     * @param fileName
     * @return void
     **/
    public void printSeirCSV(Map<Integer, SeirRecord> records, String fileName) {

        try {
            FileWriter out = new FileWriter(fileName);
            String[] headers = {"Day", "S", "E", "I", "R"};
            try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(headers))) {
                records.forEach((day, record) -> {
                    try {
                        printer.printRecord(day, record.getS(), record.getE(), record.getI(), record.getR());
                    } catch (IOException e) {
                        LOGGER.error(e);
                    }
                });
            }

        } catch (IOException e) {
            LOGGER.error(e);
        }

    }

    /**
     * @Author 毛一钦
     * @Date 2022/3/18 10:26
     * @Description printSeirList   返回list结果集
     * @param records
     * @return java.util.List
     **/
    public List printSeirList(Map<Integer, SeirRecord> records) {
        List result = new ArrayList<>();
        try {
            ArrayList<Object> title = new ArrayList<>();
            title.add("day");
            title.add("name");
            title.add("number");
            result.add(title);
            records.forEach((day, record) -> {
                ArrayList<Object> arrayListS = new ArrayList<>();
                arrayListS.add(day);
                arrayListS.add("Susceptible");
                arrayListS.add(record.getS());

                ArrayList<Object> arrayListE = new ArrayList<>();
                arrayListE.add(day);
                arrayListE.add("Exposed");
                arrayListE.add(record.getE());

                ArrayList<Object> arrayListI = new ArrayList<>();
                arrayListI.add(day);
                arrayListI.add("Infectious");
                arrayListI.add(record.getI());

                ArrayList<Object> arrayListR = new ArrayList<>();
                arrayListR.add(day);
                arrayListR.add("Recovered");
                arrayListR.add(record.getR());

                result.add(arrayListS);
                result.add(arrayListE);
                result.add(arrayListI);
                result.add(arrayListR);

            });
            LOGGER.info(result);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return result;
    }

}
