package com.politecnicomalaga.MODELO;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class HerramientaFechas {

    public HerramientaFechas(){}

    public LocalDate obtenerLocalDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.get(Calendar.DAY_OF_MONTH);
        calendar.get(Calendar.MONTH);
        calendar.get(Calendar.YEAR);


        return LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
    }

    public String obtenerFechaString(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.get(Calendar.DAY_OF_MONTH);
        calendar.get(Calendar.MONTH);
        calendar.get(Calendar.YEAR);

        return calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
    }
}
