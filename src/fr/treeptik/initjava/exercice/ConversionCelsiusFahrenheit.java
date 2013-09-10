package fr.treeptik.initjava.exercice;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConversionCelsiusFahrenheit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String line = "";
		double temperatureConvertie;
		DecimalFormat dF = new DecimalFormat("0.00");

		while (!"N".equalsIgnoreCase(line)) {
			System.out.println("------------------------------");
			System.out.println("Convertisseur C-F");
			System.out.println("------------------------------");
			System.out.println("1- Conversion C->F");
			System.out.println("2- Conversion F->C");

			line = scanner.nextLine();
			int choixTypeConversion = Integer.valueOf(line);
			if (choixTypeConversion == 1 || choixTypeConversion == 2) {
				System.out.println("Temperature à convertir : ");
				line = scanner.nextLine();
				double temperatureSaisie = Double.valueOf(line);

				if (choixTypeConversion == 1) {
					temperatureConvertie = 1.8 * temperatureSaisie + 32;
					System.out.println(dF.format(temperatureSaisie) + "°C correspond à " + dF.format(temperatureConvertie) + "°F");
				} else if (choixTypeConversion == 2) {
					temperatureConvertie = temperatureSaisie - 32;
					temperatureConvertie /= 1.8;
					System.out.println(dF.format(temperatureSaisie) + "°F correspond à " + dF.format(temperatureConvertie) + "°C");
				}

				System.out.println("Souhaitez vous convertir une autre température ? (y/n)");

				line = scanner.nextLine();
			}

		}
		System.out.println("au revoir !");

		scanner.close();

	}

}
