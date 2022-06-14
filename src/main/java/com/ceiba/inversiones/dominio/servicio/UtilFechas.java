package com.ceiba.inversiones.dominio.servicio;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilFechas {

    private UtilFechas() {
        throw new IllegalStateException("Utility class");
    }

    public static Date getLastAccountingDay(String hour) throws ParseException {
        DateTime curr = new DateTime();
        DateTime last = curr.minusDays(1);
        int dayOfWeek = last.getDayOfWeek();
        while (dayOfWeek < 1 || dayOfWeek > 5) {
            last = last.minusDays(1);
            dayOfWeek = last.getDayOfWeek();
        }
        Date lastAccountingDay = last.toDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd " + hour);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf2.parse(sdf.format(lastAccountingDay));
    }

    public static Date getCurrentAccountingDay(String hour) throws ParseException {
        Date curr = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd " + hour);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf2.parse(sdf.format(curr));
    }

    public static Date ahora(){
        return new Date();
    }

    public static String formatearFecha(Date date, int format){
        SimpleDateFormat sdf;

        switch(format){
            case 1:
                sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                return sdf.format(date);
            case 2:
                sdf = new SimpleDateFormat("dd-MM-yyyy");
                return sdf.format(date);
            default:
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                return sdf.format(date);
        }
    }
}
