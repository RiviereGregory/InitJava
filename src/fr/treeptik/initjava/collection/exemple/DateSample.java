package fr.treeptik.initjava.collection.exemple;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Création Date du moment
		Date now = new Date();
		System.out.println("#############");
		System.out.println(now);
		System.out.println(now.getTime());
		System.out.println("#############");

		// Formatage d'une date
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(dateFormat.format(now));
		System.out.println("#############");

		Date date = null;

		try {
			date = dateFormat.parse("26/12/1953");
			System.out.println(date);
			System.out.println(dateFormat.format(date));
			System.out.println("#############");

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Opération sur les DATE
		Calendar calendar = Calendar.getInstance();

		// Lire le Mois, le jour, l'année
		// Janvier == 0
		int mois = calendar.get(Calendar.MONTH) + 1;
		int jour = calendar.get(Calendar.DATE);
		int annee = calendar.get(Calendar.YEAR);

		System.out.println("" + jour + "/" + mois + "/" + annee);

		// on cale le calendar sur la date date
		calendar.setTime(date);
		// on ajoute 10 jours a date
		calendar.add(Calendar.DATE, 10);

		Date newDate = calendar.getTime();
		System.out.println(dateFormat.format(newDate));

		// Conversion
		System.out.println(TimeUnit.DAYS.toSeconds(365 * 32));
		System.out.println("#############");

		// Comparaison
		date.compareTo(now);
		System.out.println(date.compareTo(now));

	}

}
