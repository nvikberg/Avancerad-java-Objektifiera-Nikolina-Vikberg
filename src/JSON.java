import com.opencsv.CSVReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class JSON extends GUI {

    public static ArrayList<String[]> readJSON(File file) { //method for json file to return an arraylist of strings
        ArrayList<String[]> jsonData = new ArrayList<>();  //array list holding strings
        JSONParser jsonParser = new JSONParser(); //add json parser to parse contecnt of the file in to jsonarray

        try (FileReader reader = new FileReader(file)) { //read data using file reader
           //parse reader object to get the reader set into the object
            JSONArray array = (JSONArray) jsonParser.parse(reader);  //now transfer to an array

            JSONObject headerObject = (JSONObject) array.get(0); //gets first items of the array (header)
            String [] columns = new String [] {"A", "B", "C", "D", "E", "F", "G", "H"}; // string array for the  A B C values

            jsonData.add(columns); //add columns to json Data

            //loop thru from index 1 to end of array (not index 0 since that is the header)
            for (int i = 1; i < array.size(); i++ ) {
                JSONObject rowObject = (JSONObject) array.get(i); //get data from array and transfer to rowObject
                String [] row = new String[columns.length]; //new string row with same length as columns array
                // to store the values of each column for the current row.

                //iterating thru each column array starting from 0 and going up to columns.length - 1. This loop is used to process each column.
                for (int j = 0; j < columns.length; j++) {
                    row [j] = getStringOrNull(rowObject, columns[j]); //getStringOrNull is used to retrieve the value associated with// the key.
                }

                jsonData.add(row); //add row to jsonData

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return jsonData; //return jsonData

    }

    //method to take jsonibject "rowobject" and String "key" to see if rowObject contains the key and if it does
    // it return the value as a string
    private static String getStringOrNull(JSONObject rowObject, String key) {
    return rowObject.containsKey(key) ? rowObject.get(key).toString(): "";
    }

}

