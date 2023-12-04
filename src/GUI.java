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

   //adding attributes / components
    JTable table1;
    JFileChooser fileChooser;
    private JButton openCSVButton;
    private JButton openJSONButton;
    private JScrollPane scrollPane;
    private JPanel panel1, panel2;
    // private Json jParser;
    // private String jsonFile = "src/sample.json";
    // public static ArrayList<String> aryLJson = new ArrayList<>();
    //private CSVReader csvReader;
    ImageIcon image = new ImageIcon("icons8-lotus-48.png");  //create image icon to use in frame and more

    // constructor
    GUI() {

        design(); //adding a little color just for fun

        //setting  up the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1); //adding panel1 (panel 1 holds all components) to content pane
        setIconImage(image.getImage()); //place logo in frame (switches out java logo)
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);

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
                    System.out.println("You chose to open this file: " + fileChooser.getSelectedFile().getName()); //prints out only in terminal for now
                    File file = fileChooser.getSelectedFile(); //saving the chosen file in to "file"
                    ArrayList<String[]> all; //arraylist named all
                    all = CSV.readCSV(file); //csv file to the arraylist all (calling read.csv method from CSV class)
                    String[] columns = all.get(0); //Reading in the first strings from arraylist All , and adding the first row (0) of the csv file to string column
                    DataValues dataValues = new DataValues(all, columns); //adding the arraylists all and string array columns to dataValues
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