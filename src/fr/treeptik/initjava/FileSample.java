package fr.treeptik.initjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileSample {

	public static void main(String[] args) throws IOException {

		File file = new File(
				"/home/stagiaire/Formation/initJava/Workspace/InitJava/monSuperFichier.txt");
		// File file = new File("monSuperFichier.txt");// Ce met à la racine du projet
		// c'est un chemin relatif par rapport au projet
		System.out.println(" Exist ? " + file.exists());

		// Creation du fichier sur le disque
		file.createNewFile();

		System.out.println(" Exist ? " + file.exists());

		// Permet d'avoir le chemin
		System.out.println("Absolute Path : " + file.getAbsolutePath());
		System.out.println("Canonical Path : " + file.getCanonicalPath());
		// Affiche le chemin que l'on a mis lors de la creation du file
		System.out.println("Path : " + file.getPath());
		// affiche le parent que si on l'a mis dans le path
		System.out.println("Parent : " + file.getParent());

		// On creer un objet file qui ce place dans le dossier parent
		File parentFile = file.getParentFile();
		System.out.println("Canonical Path parent: " + parentFile.getCanonicalPath());

		// recupere la derniere modification du file sous forme de long
		System.out.println(parentFile.lastModified());
		// pour afficher une date il faut passer le long dans le constructeur
		Date date = new Date(parentFile.lastModified());
		System.out.println(date);

		// Permet de récuperer le separateur dans le nom
		// il ne faut pas mettre "parent/fichier"
		// mais "parent"+File.separator + "fichier"
		System.out.println("Path separator : " + File.pathSeparator);
		System.out.println("File separator : " + File.separator);

		System.out.println("///////////////////////");
		// recherche liste des fichiers et repetoire
		File fileListe = new File("Rep1");
		estUnRepetoire(fileListe);
		System.out.println("//////////////////////");
		estUnRepetoireAutre(fileListe);

		System.out.println("/////////////////////");
		// Ecrire dans un fichier
		File fileToWrite = new File("Rep1/newFile.txt");

		if (!fileToWrite.exists()) {
			fileToWrite.createNewFile();
		}
		// le true permet d'éviter d'ecraser le fichier
		FileWriter fileWriter = new FileWriter(fileToWrite, true);

		// Permet de récupérer la chaine de caractere pour le retour à la ligne en fonction du
		// système d'exploitation
		String retourLigne = System.getProperty("line.separator");

		fileWriter.write("super ligne 1" + retourLigne);
		fileWriter.write("super ligne 2" + retourLigne);
		fileWriter.write("super ligne 3" + retourLigne);

		fileWriter.close();

		System.out.println("/////////////////////");
		// Lire dans un fichier

		// il faut un FileReader
		FileReader fileReader = new FileReader(fileToWrite);
		// Il faut un BufferedReader pour pouvoir avoir la méthode readLine
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// la méthode ready permet de savoir s'il reste des lignes à lire
		while (bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			System.out.println(line);
		}

		bufferedReader.close();
	}

	public static void estUnRepetoire(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				System.out.println(file2);
				estUnRepetoire(file2);
			}
		}
	}

	// Version Fabien
	public static void estUnRepetoireAutre(File file) {
		for (File file2 : file.listFiles()) {
			if (file2.isDirectory()) {
				System.out.println("++ Repertoire : " + file2);
				estUnRepetoireAutre(file2);
			} else {
				System.out.println("++ Fichier : " + file2);
			}
		}
	}

}
