//Nikolina Vikberg

import com.opencsv.CSVReader;
import com.eclipsesource.json.*;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class GUI extends JFrame {

    //adding table1 as object
    JTable table1;
    JFileChooser fileChooser;
    private CSVReader csvReader;
    private JButton openCSVButton;
    private JButton openJSONButton;
    private JScrollPane scrollPane;
    private JPanel panel1, panel2;
    private Json jParser;
    private String jsonFile = "src/sample.json";
    public static ArrayList<String> aryLJson = new ArrayList<>();
    ImageIcon image = new ImageIcon("icons8-lotus-48.png");  //create image icon to use in frame and more


    GUI() {
        //setting  up the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setIconImage(image.getImage()); //place logo in frame (switches out java logo)
        setVisible(true);

        fileChooser = new JFileChooser();
        buttonAction(); //calling button 1 csv method
    }


    public void buttonAction() {
        openCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = fileChooser.showOpenDialog(null); //saving a response for the dialog window (from filechooser)
                if (response == JFileChooser.APPROVE_OPTION) { //if the user clicks open - code below should execute

                    File file = fileChooser.getSelectedFile(); //saving the chosen file in to "file"
                    ArrayList<String[]> all = readCSV(file); //reading in "aryl csv method" to arraylist
                    String[] columns = all.get(0); //Reading in the first string columns at the top (titles)
                    DataValues dataValues = new DataValues(all, columns); //all + columns to dataValues
                    table1.setModel(dataValues); //saving the data values to table1 model

                    //Adding sorting feature to the table
                    TableRowSorter<TableModel> sorter = new TableRowSorter<>(dataValues);
                    table1.setRowSorter(sorter);

                }
            }
        });
    }

    //method CSV READER
    private static ArrayList<String[]> readCSV(File file) { //An arraylist that holds an arrayof strings, method name readCSV
        ArrayList<String[]> csvData = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file); //fileReader to read the file (works like scanner)
            CSVReader csvReader = new CSVReader(fileReader); //csvReader object reading in the csv

            //for loop to read in the string columns to the ArrayList
            for (String[] columns : csvReader) { //reading in next rows as stringscolumns from csv reader
                csvData.add(columns); //saving it to the data array list
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
            // return new ArrayList<>();
        }
        return csvData; //return statement - returning data
    }
}