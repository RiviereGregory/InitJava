package fr.treeptik.initjava;

import java.util.Scanner;

public class LePerroquet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			String tmp = scanner.next();
			if ("quit".equalsIgnoreCase(tmp)) {
				break;
			}
			System.out.println(tmp);

		}

		scanner.close();
	}

}
