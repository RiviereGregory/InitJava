package fr.treeptik.initjava.exercice.fichier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;
import java.util.Scanner;

import fr.treeptik.initjava.jeurole.Arme;
import fr.treeptik.initjava.jeurole.Baguette;
import fr.treeptik.initjava.jeurole.Chevalier;
import fr.treeptik.initjava.jeurole.Elfe;
import fr.treeptik.initjava.jeurole.Epee;
import fr.treeptik.initjava.jeurole.Gourdin;
import fr.treeptik.initjava.jeurole.Magicien;
import fr.treeptik.initjava.jeurole.Personnage;

public class FichierTexte {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		File fileEcriture = new File("fichierEcriture");
		if (!fileEcriture.exists()) {
			try {
				fileEcriture.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileEcriture, true));
		while (!"Q".equalsIgnoreCase(line)) {
			System.out.println("saisir une phrase");
			line = scanner.nextLine();
			if (!"Q".equalsIgnoreCase(line)) {
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
		}
		bufferedWriter.close();

		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileEcriture));
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			System.out.println(line);
		}

		bufferedReader.close();
		System.out.println("///////////////////////");

		// Sérialisation
		// Il faut mettre implements java.io.Serializable dans les class que l'on veut sérialiser
		FileOutputStream fos = new FileOutputStream("MonPerso.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Arme armeCourante = new Gourdin();
		Personnage personnage = new Magicien(100, armeCourante, "Merlin");
		Arme armeCourante1 = new Epee();
		Personnage personnage1 = new Chevalier(100, armeCourante1, "Arthur");
		Arme armeCourante2 = new Epee();
		Personnage personnage2 = new Elfe(100, armeCourante2, "Elfe");
		Arme armeCourante3 = new Baguette();
		Personnage personnage3 = new Magicien(100, armeCourante3, "Mage");

		oos.writeObject(personnage);
		oos.writeObject(personnage1);
		oos.writeObject(personnage2);
		oos.writeObject(personnage3);
		oos.close();

		// Désérialisation
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("MonPerso.ser")));
		Personnage newPersonnage = (Personnage) ois.readObject();
		Personnage newPersonnage1 = (Personnage) ois.readObject();
		Personnage newPersonnage2 = (Personnage) ois.readObject();
		Personnage newPersonnage3 = (Personnage) ois.readObject();
		ois.close();

		System.out.println(newPersonnage);
		System.out.println(newPersonnage1);
		System.out.println(newPersonnage2);
		System.out.println(newPersonnage3);

		// Copie de fichier avec FileChannel et transferTo
		System.out.println("///////////////////////");
		File filesrc = new File("fichierEcriture");
		File filedest = new File("fichierEcritureCopie");
		copieFichier(filesrc, filedest);

		bufferedReader = new BufferedReader(new FileReader(filedest));
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			System.out.println(line);
		}

		bufferedReader.close();
		scanner.close();

	}

	@SuppressWarnings("resource")
	public static void copieFichier(File in, File out) {
		try {
			FileChannel fileChannelIn = new FileInputStream(in).getChannel();
			FileChannel fileChannelOut = new FileOutputStream(out).getChannel();
			fileChannelIn.transferTo(0, fileChannelIn.size(), fileChannelOut);
			fileChannelIn.close();
			fileChannelOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
