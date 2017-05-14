package br.ic.ufal.ProjetoFolhaPagamento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Datas {

	public static boolean validarData(String data) {
		boolean bool = false;

		Calendar dt = Calendar.getInstance();
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

		dt.setLenient(false);

		try {

			dt.setTime(formatoData.parse(data));

			if(validaValoresData(data)) bool = true;
			else bool = false;


		} catch (ParseException ex) {
			bool = false;
		}

		return bool;
	}

	private static boolean validaValoresData(String data){

		GregorianCalendar calendar =  new GregorianCalendar();   
		int dia = 0,mes = 0,ano = 0;
		String diaStr = data.substring(0,2);
		String mesStr = data.substring(3,5);
		String anoStr = data.substring(6,10);

		try {
			dia = Integer.parseInt(diaStr);
			mes = Integer.parseInt(mesStr);
			ano = Integer.parseInt(anoStr);
		} catch (Exception e) {
			return false;
		}


		if (dia < 1 || mes < 1 || ano < 1){
			return false;

		} else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){

			if (dia > 31) return false;
			
		}else if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
			
			if (dia > 30)  return false;
		
		} else if (mes == 2){

			if (calendar.isLeapYear(ano)){
				
				if (dia <= 29) return false;

			} else  if (dia > 28)	return false;
			
		} else return false;
		
		return true;
	}

	
	
	public static boolean ultimoDiaMes(Date date) {
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		
		int ultimoDiaMes = gc.getActualMaximum( Calendar.DAY_OF_MONTH );
		
		if(gc.get(GregorianCalendar.DAY_OF_MONTH) == ultimoDiaMes){
			return true;
		}
		
		return false;
	}
}

