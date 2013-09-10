package fr.treeptik.initjava.collection.exemple;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ExempleDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Date date1 = new Date(); // date courante au moment de l'execution
		System.out.println("date courante brute : " + date1);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		String sDate = dateFormat.format(date1);

		System.out.println("date courante formatée : " + sDate);

		sDate = "26/12/1953 15:00";

		Date date2 = null;

		try {
			date2 = dateFormat.parse(sDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		System.out.println("date choisie non formatée : " + date2);

		// /////////////////////////////////////////////////////////////
		//
		// methode calendar
		//

		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date2);// cale le calendar sur la date passée en paramètre

		calendar1.add(Calendar.DAY_OF_MONTH, 7); // on ajoute 7 jours à la date
													// du calendar

		date2 = calendar1.getTime(); // on recupere la date au format date

		System.out.println("date modifié avec le calendar : " + dateFormat.format(date2));

		calendar1.add(Calendar.DAY_OF_MONTH, -7);// on enleve 7 jours à la date
													// du calendar

		date2 = calendar1.getTime();
		System.out.println("date modifié avec le calendar : " + dateFormat.format(date2));

		long second = TimeUnit.DAYS.toSeconds(32 * 365);// transforme le nombre
														// de jour en seconde
		System.out.println("date en seconde depuis 1970 : " + second);

		long hours = TimeUnit.DAYS.toHours(32 * 365);// transforme le nombre
		// de jour en heure
		System.out.println("date en heures depuis 1970 : " + hours);

		// //////////////////////////////////////////////////////////////
		Scanner scanner = new Scanner(System.in);
		// System.out.print("saisir date JJ/MM/AAAA : ");
		String dateSaisie = "";

		Date date = null;
		SimpleDateFormat simpleDateFormat;
		int falseDate = 0;
		while (falseDate == 0) {
			System.out.print("saisir date JJ/MM/AAAA : ");
			dateSaisie = scanner.nextLine();
			// definit la mise en forme que l'on veut
			simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = simpleDateFormat.parse(dateSaisie);
				// simpleDateFormat.format(date) sert à appliquer la mise en
				// forme
				System.out.println(simpleDateFormat.format(date));
				falseDate = 1;

			} catch (ParseException e) {
				// e.printStackTrace();
				System.out.println("erreur saisie");
				continue;
			}
		}

		System.out.println("///date reformatée////");
		// On reformate la forme de la date
		simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// simpleDateFormat.format(date) sert à appliquer la mise en
		// forme
		System.out.println(simpleDateFormat.format(date));

		System.out.println("///avec le calendar////");

		// /
		// Aute Methode avec les calandar
		//

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int mois = calendar.get(Calendar.MONTH) + 1;// recupere le mois sous
													// forme de collection de 0
													// à 11 c'est pour cela
													// qu'il faut +1
		int jour = calendar.get(Calendar.DAY_OF_MONTH);
		int annee = calendar.get(Calendar.YEAR);
		String dateInverse = "" + annee + "/" + mois + "/" + jour;
		simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		try {
			date = simpleDateFormat.parse(dateInverse);
			// simpleDateFormat.format(date) sert à appliquer la mise en forme
			System.out.println(simpleDateFormat.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		scanner.close();
	}

}
