
import com.opencsv.CSVReader;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class CSV extends GUI{
   //private String file = "src/sample - sample.csv";

    //method to read data from a CSV file and store it in an ArrayList, each array of strings is a row from the CSV file.
    public static ArrayList<String[]> readCSV(File file) {
            ArrayList<String[]> csvData = new ArrayList<>(); //arrayList to store the data from the CSV file

        try {
            FileReader fileReader = new FileReader(file); //fileReader to read the file (works like scanner)
            CSVReader csvReader = new CSVReader(fileReader); //csvReader object reading in the csv

            //for loop to read in each row (as an array of strings) in the CSVReader
            for (String[] columns : csvReader) { //reading in next rows as strings from csv reader to columns, for each loop is gets assigned a new row from the csv reader
                csvData.add(columns); //saving the string columns to the data array list - csvData
            }
        } catch (FileNotFoundException e) { // catch case if file is not found
            System.out.println("Error" + e);
        }
        return csvData;
    }

}
