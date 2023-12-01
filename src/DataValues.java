import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import com.eclipsesource.json.*;

public class DataValues extends DefaultTableModel {

    //array lists in values and columns
    private final ArrayList<String[]> values; // set arraylist values as final
    private final String[] columns; //set string array columns as final

    //constructor with ArrayList holding values and String Array holding columns
    public DataValues(ArrayList<String[]>values, String[] columns) {
        this.values = values;
        this.columns = columns;
    }


    //adding column count, names, row count, editable cells and value
    @Override
    public int getRowCount() {
        if(values==null)
            return 0;
        return values.size();
    }

    @Override
    public int getColumnCount() {
        if(columns==null)
            return 0;
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns [column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return super.isCellEditable(row, column);
    }

    @Override
    public Object getValueAt(int row, int column) {
        return values.get(row)[column];
    }

}
