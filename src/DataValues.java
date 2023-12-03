import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import com.eclipsesource.json.*;

public class DataValues extends DefaultTableModel {

    //array lists in values and columns
    private final ArrayList<String[]> values; // set arraylist values as final
    private final String[] columns; //set string array columns as final

    //constructor with ArrayList holding values and String Array holding columns
    public DataValues(ArrayList<String[]>values, String[] columns) {
        this.values = values; //storing rows
        this.columns = columns; //storing the header
    }


    //adding column count, names, row count, editable cells and value
    @Override
    public int getRowCount() {
        if(values==null)
            return 0;
        return values.size(); //return the correct number of rows in the table (size)
    }

    @Override
    public int getColumnCount() {// will continue to read in columns until there is null left
        if(columns==null)
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
