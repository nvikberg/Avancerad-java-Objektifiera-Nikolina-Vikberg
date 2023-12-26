import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;

public class DataValues extends DefaultTableModel { // default table model to display the table data in swing

    //array lists in values and columns
    private ArrayList<String[]> values; // arraylist that represents the value (rows) in the table
    private String[] columns; //string array columns names

    //constructor with ArrayList holding values and String Array holding columns
    public DataValues(ArrayList<String[]>values, String[] columns) {
        this.values = values; //storing rows
        this.columns = columns; //storing the column

    }
    //adding column count, names, row count, editable cells and value
    @Override
    public int getRowCount() {
        if(values==null)
            return 0;
        return values.size(); //return the correct number of rows in the table (size)
    }

    @Override
    public int getColumnCount() {
        if(columns==null) //ensures that it returns the correct number of columns, handling the case where the columns array is null.
            return 0;
        return columns.length; //returns correct number of columns
    }

    @Override
    public String getColumnName(int column) { //column name to string
        return columns [column]; //returns name of the column at the specified index from the columns array.
    }


    @Override
    public Object getValueAt(int row, int column) { //retrieving the value at specified rows and columns in the table
        return values.get(row)[column];
    }

}
