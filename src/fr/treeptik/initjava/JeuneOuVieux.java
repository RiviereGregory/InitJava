package fr.treeptik.initjava;

import java.util.Scanner;

public class JeuneOuVieux {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("entrer votre age : ");
		Integer age = scanner.nextInt();
		if(age<20){
			System.out.println("vous êtes jeunes");
		}else if (age>=20 && age<30){
			System.out.println("vous n'êtes plus tout jeune et pas complètement vieux");
		}else if (age>60){
			System.out.println("vous êtes vieux");
		}else{
			System.out.println("ne dit rien");
		}

		scanner.close();
	}

}
