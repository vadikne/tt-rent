 import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
// import java.util.Date;
 import org.omg.CORBA.DATA_CONVERSION;

/**
 * Created by owner on 21.07.2017.
 */
public class WorkUtils {


        // public static Date dateConvert(Date dateOf) {
        public static Date dateConvert(String dateOf) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = Date.valueOf(dateOf);

            //2    return new Date(format.parse(dateOf));

            return date;
        }
    }

