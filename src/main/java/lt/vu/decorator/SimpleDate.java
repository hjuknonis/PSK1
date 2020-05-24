package lt.vu.decorator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SimpleDate implements DateTemplate {

    public String getDate(){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date = new java.util.Date();
        return df.format(date);
    }
}
