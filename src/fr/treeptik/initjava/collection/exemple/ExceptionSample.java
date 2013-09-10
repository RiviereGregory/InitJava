package fr.treeptik.initjava.collection.exemple;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExceptionSample {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		boolean isDateOk = true;

		do {
			System.out.println("saisir une date (dd/MM/yyyy) : ");
			String sDate = scanner.nextLine();
			try {
				System.out.println(parseDate(sDate));
				parseInt("1");
				isDateOk = true;
			} catch (ParseException | NumberFormatException e) { // on peut
				// mettre un pipe (|)pour
				// ajouter d'autre exception qui ne sont pas de la même famille
				// par ex (ParseException | Exception e ) ce n'est pas possible
				// par ex (ParseException | NumberFormatException e) est
				// possible
				// e.printStackTrace();
				isDateOk = false;
				// throw new Exception("Erreur dans le main " + e.getMessage());
				// permet de sortir du code en cas d'exception mais il faut mettre throws Exception
				// à coté du nom de la methode
				throw new ApplicationException(e.getMessage());// l'exception que l'on a cée

			} catch (Exception e) { // juste pour l'exemple de plusieur
									// exceptions
				e.printStackTrace();
				isDateOk = false;
			} finally {
				// on passe tjs par ce bloc même si on a une exception

				System.out.println(" -- Fin Try -- ");

			}

		} while (!isDateOk);

		System.out.println("FIN");

		scanner.close();

	}

	public static Date parseDate(String stringDate) throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		return simpleDateFormat.parse(stringDate);
	}

	public static Integer parseInt(String stringInt) throws NumberFormatException {

		return Integer.valueOf(stringInt);

	}

}
