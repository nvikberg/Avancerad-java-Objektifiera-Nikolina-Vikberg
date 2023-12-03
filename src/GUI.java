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
    // private Json jParser;
    // private String jsonFile = "src/sample.json";
    // public static ArrayList<String> aryLJson = new ArrayList<>();
    ImageIcon image = new ImageIcon("icons8-lotus-48.png");  //create image icon to use in frame and more


    GUI() {

        design(); //adding a little color just for fun

        //setting  up the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1); //adding panel to
        setIconImage(image.getImage()); //place logo in frame (switches out java logo)
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(new Color(50, 105, 90));

        fileChooser = new JFileChooser(); //allows user to search through files (JFileChooser)
        buttonAction(); //calling button action method

    }

    //method for CSV action event, for whatever file user picks, csv reader shall read it in and save it down to columns and rows with help of csvreader method
    public void buttonAction() {
        openCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = fileChooser.showOpenDialog(GUI.this); //saving a response for the dialog window (from filechooser)
                if (response == JFileChooser.APPROVE_OPTION) { //if the user clicks open - code below should execute
                    System.out.println("You chose to open this file: " +
                            fileChooser.getSelectedFile().getName());
                    File file = fileChooser.getSelectedFile(); //saving the chosen file in to "file"
                    ArrayList<String[]> all; //reading in array list csv "method" to arraylist
                    all = CSV.readCSV(new File("src/sample - sample.csv")); //csv file to the arraylist all (calling read.csv method from CSV class)
                    String[] columns = all.get(0); //Reading in the first strings from arraylist All , and adding the first row of the csv file
                    DataValues dataValues = new DataValues(all, columns); //adding all and columns to dataValues
                    table1.setModel(dataValues); //saving the data values to table1 model

                    //Adding sorting feature to the table
                    TableRowSorter<TableModel> sorter = new TableRowSorter<>(dataValues);
                    table1.setRowSorter(sorter);

                }
            }
        });
    }

    public void design() {
        //adding UI manager "Look and Feel design just for fun
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;
                }
            }
        } catch (Exception ignored) {
        }
        UIManager.put("nimbusBlueGrey", new Color(50, 105, 90)); //changing color of buttons
        UIManager.put("control", new Color(181, 227, 178, 255)); //changing color of background
    }
}