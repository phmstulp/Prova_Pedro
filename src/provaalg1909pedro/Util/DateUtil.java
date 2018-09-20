package provaalg1909pedro.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pedro Henrique Martins Stulp
 */
public class DateUtil {
    static SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat sdfDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public static Date stringToDate(String data){
        Date dataRetorno = new Date();
        try {
            dataRetorno = sdfData.parse(data);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dataRetorno;
    }
    
    public static Date stringToDateHora(String dataHora){
        Date dataRetorno = new Date();
        try {
            dataRetorno = sdfDataHora.parse(dataHora);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dataRetorno;
    }
    
    public static String dateToString(Date data){
        try{
            return sdfData.format(data);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "";
    }
    
    public static String dateToStringHora(Date data){
        try{
            return sdfDataHora.format(data);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "";
    }
}
