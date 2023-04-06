


import org.apache.commons.math4.legacy.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math4.legacy.stat.descriptive.rank.Percentile.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class StatisticalTest2 {


    private static final String SAMPLE_CSV_FILE_PATH = "./18100205.csv";

    public static void main(String[] args) throws IOException {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter City and Province (City, Province): ");
        String location1 = myObj.nextLine();
        System.out.println("Enter Year and Month (yyyy-mm): ");
        String date1 = myObj.nextLine();



        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String REF_DATE = csvRecord.get(0);
                String GEO = csvRecord.get(1);
                String DGUID = csvRecord.get(2);
                String New_housing_price_indexes = csvRecord.get(3);
                String UOM = csvRecord.get((4));
                String UOM_ID = csvRecord.get((5));
                String SCALAR_FACTOR = csvRecord.get((6));
                String SCALAR_ID = csvRecord.get((7));
                String VECTOR = csvRecord.get((8));
                String COORDINATE = csvRecord.get((9));
                String VALUE = csvRecord.get((10));
                String STATUS = csvRecord.get((11));
                String SYMBOL = csvRecord.get((12));
                String TERMINATED = csvRecord.get((13));
                String DECIMALS = csvRecord.get((14));

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("REF_DATE : " + REF_DATE);
                System.out.println("GEO : " + GEO);
                System.out.println("DGUID : " + DGUID);
                System.out.println("New housing price indexes : " + New_housing_price_indexes);
                System.out.println("UOM : " + UOM);
                System.out.println("UOM_ID : " + UOM_ID);
                System.out.println("SCALAR_FACTOR : " + SCALAR_FACTOR);
                System.out.println("SCALAR_ID : " + SCALAR_ID);
                System.out.println("VECTOR : " + VECTOR);
                System.out.println("COORDINATE : " + COORDINATE);
                System.out.println("VALUE : " + VALUE);
                System.out.println("STATUS : " + STATUS);
                System.out.println("SYMBOL : " + SYMBOL);
                System.out.println("TERMINATED : " + TERMINATED);
                System.out.println("DECIMALS : " + DECIMALS);
                System.out.println("---------------\n\n");
            }
        }
    }
}


/* try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                if (csvRecord.get(0) == date1 && csvRecord.get(1) == location1) {
                    String REF_DATE1 = csvRecord.get(0);
                    String GEO1 = csvRecord.get(1);

                    System.out.println("REF_DATE : " + REF_DATE1);
                    System.out.println("GEO : " + GEO1);
                }
                else{
                    System.out.println ("error");
                }

            }*/
