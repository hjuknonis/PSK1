package lt.vu.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Decorator
public class SimpleDateDecorator implements DateTemplate{

    @Inject @Delegate @Any
    SimpleDate simpleDate;

    public String getDate(){
        return "Current date in custom format: " + simpleDate.getDate();
    }
}
