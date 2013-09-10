package fr.treeptik.initjava.exercice.fichierxml;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import fr.treeptik.initjava.exercice.fichierxml.xml.Annuaire;
import fr.treeptik.initjava.exercice.fichierxml.xml.Personne;

public class FichierXml {

	/**
	 * @param args
	 * @throws JAXBException
	 * @throws DatatypeConfigurationException
	 */
	public static void main(String[] args) throws JAXBException, DatatypeConfigurationException {
		JAXBContext context = JAXBContext
				.newInstance("fr.treeptik.initjava.exercice.fichierxml.xml");
		Scanner scanner = new Scanner(System.in);
		String line = "";
		Annuaire annuaire = new Annuaire();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// Création de l'annuaire avec des personnes
		while (!"n".equalsIgnoreCase(line)) {
			Personne personne = new Personne();
			System.out.println("entrer le nom : ");
			String nom = scanner.nextLine();
			personne.setNom(nom);
			System.out.println("entrer le prenom : ");
			String prenom = scanner.nextLine();
			personne.setPrenom(prenom);
			System.out.println("entrer la date jj/MM/aaaa : ");
			String dateString = scanner.nextLine();

			Date date = null;

			try {
				date = dateFormat.parse(dateString);
				System.out.println(date);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			// Pour créer un xml gregorian calendar il faut 3 étapes
			// Créer un GregorianCalendar et mettre la date
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(date);
			// Créer un DatatypeFactory
			DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
			// Et enfin créer un XMLGregorianCalendar avec
			// datatypeFactory.newXMLGregorianCalendar(gregorianCalendar)
			XMLGregorianCalendar xmlGregorianCalendar = datatypeFactory
					.newXMLGregorianCalendar(gregorianCalendar);

			personne.setDateNaissance(xmlGregorianCalendar);

			annuaire.getPersonne().add(personne);
			System.out.println("voulez vous ajouter une autre personne (y/n)?");
			line = scanner.nextLine();
		}
		// Création du fichier annuaire
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(annuaire, new File("annuaire.xml"));

		// Lecture du fichier annuaire
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Annuaire newAnnuaire = (Annuaire) unmarshaller.unmarshal(new File("annuaire.xml"));
		System.out.println(newAnnuaire.getPersonne().size());

		for (Personne string : newAnnuaire.getPersonne()) {
			System.out.println("nom : " + string.getNom());
			System.out.println("prenom : " + string.getPrenom());
			// Transformer une XMLGregorianCalendar en Date
			Date date1 = new Date(string.getDateNaissance().toGregorianCalendar().getTimeInMillis());
			// ou
			// Date date1 = string.getDateNaissance().toGregorianCalendar().getTime();
			System.out.println("Date : " + dateFormat.format(date1));

		}

		scanner.close();
	}

}
