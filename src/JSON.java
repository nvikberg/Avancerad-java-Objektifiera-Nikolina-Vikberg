import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSON extends GUI {

    JSON() {
        super();

        readJSON();
    }

    public static void readJSON(){
    JSONParser jsonParser = new JSONParser(); //add json parser

        try(FileReader reader = new FileReader("src/sample.json")){ //read data using file reader
        Object obj = jsonParser.parse(reader); //parse reader object to get the reader set into the object
        JSONArray array = (JSONArray) obj;            //now transfer to an array
        System.out.println(array); //printing it out

    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }

    }
}
