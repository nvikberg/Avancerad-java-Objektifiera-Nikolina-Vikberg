
import com.opencsv.CSVReader;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class CSV extends GUI{
    private JButton openCSVButton;
    private JFileChooser fileChooser;
    private JTable table1;
   private String file = "src/sample - sample.csv";

    CSV(){
        super();
    }

    //method CSV READER
    public static ArrayList<String[]> readCSV(File file) { //An arraylist that holds an array of strings, method name readCSV (csv file shall be places in the array)
        ArrayList<String[]> csvData = new ArrayList<>(); //arraylist will be csvData
        try {
            FileReader fileReader = new FileReader(file); //fileReader to read the file (works like scanner)
            CSVReader csvReader = new CSVReader(fileReader); //csvReader object reading in the csv

            //for loop to read in the string columns to the ArrayList
            for (String[] columns : csvReader) { //reading in next rows as strings from csv reader to columns
                csvData.add(columns); //saving columns to the data array list - csvData
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error" + e);
         return new ArrayList<>();
        }
        return csvData;
    }

}
