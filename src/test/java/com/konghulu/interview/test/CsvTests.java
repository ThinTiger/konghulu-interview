package com.konghulu.interview.test;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * @author: za-lining
 * @date: 2019/4/19
 **/
@Slf4j
public class CsvTests extends BaseApplicationTest {

    @Test
    public void csvTest() {
        File exportFile = new File("D:\\test.csv");
        String[] issuedCount = new String[]{"\tHeader1", "\t6"};
        String[] balanceCount = new String[]{"\tHeader2", "\t9994"};
        String[] headers = new String[]{"\tColumn1", "\tColumn2", "\tColumn3", "\tColumn4", "\tColumn5", "\tColumn6"};
        List<String> data = Lists.newArrayList("aaa", "\tbbbbbbbbbbbbbb", "\tccccccccccccccc", "\tdddddddddddddddd", "\teeeeee", "\tffffff");
        List<List<String>> dataList = Lists.newArrayList();
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        exportByList(headers, dataList, exportFile, issuedCount, balanceCount);
    }

    private void exportByList(String[] headers, List<List<String>> dataList, File file, String[] issuedCount, String[] balanceCount) {
        OutputStreamWriter osw = null;
        CSVFormat csvFormat = null;
        CSVPrinter csvPrinter = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(file), "GBK");
            csvFormat = CSVFormat.DEFAULT;
            csvPrinter = new CSVPrinter(osw, csvFormat);
            csvPrinter.printRecord(issuedCount);
            csvPrinter.printRecord(balanceCount);
            csvPrinter.printRecord("");
            csvPrinter.printRecord(headers);
            for (int i = 0; i < dataList.size(); i++) {
                List<String> values = dataList.get(i);
                csvPrinter.printRecord(values);
            }
        } catch (Exception e) {
            log.error("csv exportByList err", e);
        } finally {
            close(osw, csvPrinter);
        }
    }

    private void close(OutputStreamWriter os, CSVPrinter csvPrinter) {
        if (csvPrinter != null) {
            try {
                csvPrinter.flush();
                os.flush();
                csvPrinter.close();
                os.close();
            } catch (IOException e) {
                log.error("csv close err", e);
            }
        }
    }
}
