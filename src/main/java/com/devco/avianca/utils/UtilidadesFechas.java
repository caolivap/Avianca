package com.devco.avianca.utils;

import static com.devco.avianca.utils.EnumConstantes.FORMATO_FECHA_YYYY_MM__DD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import net.thucydides.core.pages.PageObject;
import org.joda.time.DateTime;

public class UtilidadesFechas extends PageObject {
  private Calendar cal = new GregorianCalendar();

  public static String obtenerFechaDeVuelo(int dias) throws ParseException {
    DateTime fechaVuelo = new DateTime();
    fechaVuelo = fechaVuelo.plusDays(dias);
    return devolverFechaEnFormato(fechaVuelo.toString(), FORMATO_FECHA_YYYY_MM__DD.getValor());
  }

  public static String devolverFechaEnFormato(String fecha, String formato) throws ParseException {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
    calendar.setTime(simpleDateFormat.parse(fecha));
    return simpleDateFormat.format(calendar.getTime());
  }

}
