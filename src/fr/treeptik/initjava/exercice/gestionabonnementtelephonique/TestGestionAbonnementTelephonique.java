package fr.treeptik.initjava.exercice.gestionabonnementtelephonique;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fr.treeptik.initjava.exercice.gestionabonnementtelephonique.Materiel.TypeMateriel;

public class TestGestionAbonnementTelephonique {

	public static void main(String[] args) {

		// ////////////////////////////////////////////////
		// Ajout client et forfait avec la console
		//
		Scanner scanner = new Scanner(System.in);
		String line = "";
		File fileClient = new File("fichierClient");
		if (!fileClient.exists()) {
			try {
				fileClient.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File fileForfait = new File("fichierForfait");
		if (!fileForfait.exists()) {
			try {
				fileForfait.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ArrayList<Client> listClients = new ArrayList<>();

		while (!"Q".equalsIgnoreCase(line)) {
			ArrayList<Forfait> forfaits = new ArrayList<>();
			Adresse adresse = new Adresse();
			String ref = null;
			String siret = null;
			String codeAPE = null;
			String nom = null;
			String prenom = null;

			System.out.println("**************************");
			System.out.println("**********MENU************");
			System.out.println("* 1 - Ajouter Client");
			System.out.println("* 2 - Lister Client");
			System.out.println("* 3 - Lister Forfait");
			System.out.println("* Q - Quitter");
			System.out.println("Choix : ");
			line = scanner.nextLine();

			line = line.toUpperCase();
			switch (line) {
			case "1":
				System.out.println("réference Client : ");
				line = scanner.nextLine();
				ref = line;
				adresse = renseignementAdresse(scanner);

				System.out.println("**********MENU************");
				System.out.println("* 1 - Personne Morale");
				System.out.println("* 2 - Personne Physique");
				System.out.println("Choix : ");
				String persString = scanner.nextLine();
				if ("1".equalsIgnoreCase(persString)) {
					System.out.println("Siret : ");
					line = scanner.nextLine();
					siret = line;
					System.out.println("Code APE : ");
					line = scanner.nextLine();
					codeAPE = line;

				} else if ("2".equalsIgnoreCase(persString)) {
					System.out.println("Nom : ");
					line = scanner.nextLine();
					nom = line;
					System.out.println("Prenom : ");
					line = scanner.nextLine();
					prenom = line;
				}

				forfaits = new ArrayList<>();
				while (!"n".equalsIgnoreCase(line)) {

					forfaits.add(renseignementForfait(scanner));

					System.out.println("Voulez vous entrer un autre forfait ? (y/n) ");
					line = scanner.nextLine();
				}

				if ("1".equalsIgnoreCase(persString)) {
					PersonneMorale client = new PersonneMorale(ref, adresse, forfaits, siret,
							codeAPE);
					listClients.add(client);
					ecrireFichier(fileClient, client);
					ecrireFichier(fileForfait, client);
				} else if ("2".equalsIgnoreCase(persString)) {
					PersonnePhysique client = new PersonnePhysique(ref, adresse, forfaits, nom,
							prenom);
					listClients.add(client);
					ecrireFichier(fileClient, client);
					ecrireFichier(fileForfait, client);
				}

				break;
			case "2":
				for (Client client : lireFichier(fileClient)) {
					System.out.println(afficheClient(client));
				}

				break;
			case "3":
				for (Client client : lireFichier(fileClient)) {

					for (Forfait forfait : client.getForfait()) {

						System.out.println(afficheForfait(forfait, client));
					}

				}

				break;

			case "Q":

				break;

			default:
				break;
			}

		}

		scanner.close();

	}

	public static ArrayList<Client> lireFichier(File file) {

		ArrayList<Client> clients = new ArrayList<>();

		FileReader fileReader = null;

		if ("fichierClient".equalsIgnoreCase(file.getPath())) {
			try {
				fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				while (bufferedReader.ready()) {

					PersonneMorale personneMorale = null;
					PersonnePhysique personnePhysique = null;

					String line = bufferedReader.readLine();
					String[] donneesClient = line.split(":");

					String typeClient = donneesClient[0];

					if ("P".equalsIgnoreCase(typeClient)) {
						personnePhysique = new PersonnePhysique();
						personnePhysique.setRef(donneesClient[1]);
						personnePhysique.setNom(donneesClient[2]);
						personnePhysique.setPrenom(donneesClient[3]);

						Adresse adresse = new Adresse(donneesClient[4], donneesClient[5],
								donneesClient[6]);
						personnePhysique.setAdresse(adresse);

					} else if ("M".equalsIgnoreCase(typeClient)) {
						personneMorale = new PersonneMorale();

						personneMorale.setRef(donneesClient[1]);
						personneMorale.setSiret(donneesClient[2]);
						personneMorale.setCodeAPE(donneesClient[3]);

						Adresse adresse = new Adresse(donneesClient[4], donneesClient[5],
								donneesClient[6]);

						personneMorale.setAdresse(adresse);
					}

					if ("P".equalsIgnoreCase(typeClient)) {
						personnePhysique.setForfait(getForfaitFromClient(personnePhysique));
						clients.add(personnePhysique);

					} else if ("M".equalsIgnoreCase(typeClient)) {
						personneMorale.setForfait(getForfaitFromClient(personneMorale));
						clients.add(personneMorale);
					}

				}

				bufferedReader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return clients;

	}

	public static List<Forfait> getForfaitFromClient(Client client) {

		ArrayList<Forfait> listForfaits = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FileReader fileReaderForfait = null;
		try {
			fileReaderForfait = new FileReader("fichierForfait");

			BufferedReader bufferedReaderForfait = new BufferedReader(fileReaderForfait);

			while (bufferedReaderForfait.ready()) {

				ForfaitMobile forfaitMobile = null;
				ForfaitFixe forfaitFixe = null;

				String lineForfait = bufferedReaderForfait.readLine();
				String[] donneesForfait = lineForfait.split(":");
				String typeForfait = donneesForfait[0];
				
				Date dateDebut = new Date();
				Date dateFin = new Date();

				if ("M".equalsIgnoreCase(typeForfait)) {
					if (client.getRef().equalsIgnoreCase(donneesForfait[9])) {
						forfaitMobile = new ForfaitMobile();
						forfaitMobile.setRef(donneesForfait[1]);
						try {
							dateDebut = dateFormat.parse(donneesForfait[2]);
							forfaitMobile.setDateDebut(dateDebut);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						try {
							dateFin = dateFormat.parse(donneesForfait[3]);
							forfaitMobile.setDateFin(dateFin);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						forfaitMobile.setNumero(donneesForfait[4]);
						Materiel materiel = new Materiel(donneesForfait[5], TypeMateriel.MOBILE);
						forfaitMobile.setMateriel(materiel);
						forfaitMobile.setDuree(Integer.valueOf(donneesForfait[7]));
						forfaitMobile.setNbSms(Integer.valueOf(donneesForfait[8]));

						listForfaits.add(forfaitMobile);

					}
				} else if ("F".equalsIgnoreCase(typeForfait)) {
					if (client.getRef().equalsIgnoreCase(donneesForfait[10])) {
						forfaitFixe = new ForfaitFixe();
						forfaitFixe.setRef(donneesForfait[1]);
						try {
							dateDebut = dateFormat.parse(donneesForfait[2]);
							forfaitFixe.setDateDebut(dateDebut);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						try {
							dateFin = dateFormat.parse(donneesForfait[3]);
							forfaitFixe.setDateFin(dateFin);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						forfaitFixe.setNumero(donneesForfait[4]);
						Materiel materiel = new Materiel(donneesForfait[5], TypeMateriel.BOX);
						forfaitFixe.setMateriel(materiel);
						Adresse adresseForfait = new Adresse(donneesForfait[7], donneesForfait[8],
								donneesForfait[9]);
						forfaitFixe.setAdresse(adresseForfait);

						listForfaits.add(forfaitFixe);
					}
				}

			}
			bufferedReaderForfait.close();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		return listForfaits;
	}

	public static void ecrireFichier(File file, Client client) {
		String retourLigne = System.getProperty("line.separator");
		if ("fichierClient".equalsIgnoreCase(file.getPath())) {
			try {
				FileWriter fileWriter = new FileWriter(file, true);
				fileWriter.write(afficheClient(client) + retourLigne);
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if ("fichierForfait".equalsIgnoreCase(file.getPath())) {
			try {
				FileWriter fileWriter = new FileWriter(file, true);
				for (Forfait forfait : client.getForfait()) {
					fileWriter.write(afficheForfait(forfait, client) + retourLigne);
				}
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static Adresse renseignementAdresse(Scanner scanner) {
		System.out.println("Code Postal : ");
		String line = scanner.nextLine();
		String cp = line;
		System.out.println("Ville : ");
		line = scanner.nextLine();
		String ville = line;
		System.out.println("Rue : ");
		line = scanner.nextLine();
		String rue = line;
		return new Adresse(cp, ville, rue);

	}

	public static Forfait renseignementForfait(Scanner scanner) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateDebut = new Date();
		Date dateFin = new Date();
		System.out.println("réference Forfait : ");
		String line = scanner.nextLine();
		String refForfait = line;
		System.out.println("Date de début (jj/MM/aaaa) : ");
		line = scanner.nextLine();
		try {
			dateDebut = dateFormat.parse(line);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Date de fin (jj/MM/aaaa) : ");
		line = scanner.nextLine();
		try {
			dateFin = dateFormat.parse(line);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("**********MENU************");
		System.out.println("* 1 - Forfait Fixe");
		System.out.println("* 2 - Forfait Mobile");
		System.out.println("Choix : ");
		String choixForfaits = scanner.nextLine();
		if ("1".equalsIgnoreCase(choixForfaits)) {
			Adresse adresseForfait = new Adresse();
			System.out.println("numéro de téléphone : ");
			line = scanner.nextLine();
			String numero = line;
			System.out.println("Ref materiel : ");
			line = scanner.nextLine();
			String refMat = line;
			TypeMateriel typeMateriel = null;
			if ("1".equalsIgnoreCase(choixForfaits)) {
				typeMateriel = TypeMateriel.BOX;
			} else if ("2".equalsIgnoreCase(choixForfaits)) {
				typeMateriel = TypeMateriel.MOBILE;
			}
			Materiel materiel = new Materiel(refMat, typeMateriel);

			adresseForfait = renseignementAdresse(scanner);
			ForfaitFixe forfaitFixe = new ForfaitFixe(refForfait, dateDebut, dateFin, numero,
					materiel, adresseForfait);
			return forfaitFixe;

		} else if ("2".equalsIgnoreCase(choixForfaits)) {
			Integer duree = null;
			Integer nbSms = null;
			System.out.println("numéro de téléphone : ");
			line = scanner.nextLine();
			String numero = line;
			System.out.println("Ref materiel : ");
			line = scanner.nextLine();
			String refMat = line;
			TypeMateriel typeMateriel = null;
			if ("1".equalsIgnoreCase(choixForfaits)) {
				typeMateriel = TypeMateriel.BOX;
			} else if ("2".equalsIgnoreCase(choixForfaits)) {
				typeMateriel = TypeMateriel.MOBILE;
			}
			Materiel materiel = new Materiel(refMat, typeMateriel);
			;
			System.out.println("Duree d'appel en minute : ");
			line = scanner.nextLine();
			duree = Integer.valueOf(line);
			System.out.println("Nombre de sms : ");
			line = scanner.nextLine();
			nbSms = Integer.valueOf(line);

			ForfaitMobile forfaitMobile = new ForfaitMobile(refForfait, dateDebut, dateFin, numero,
					materiel, duree, nbSms);
			return forfaitMobile;

		}
		return new Forfait();

	}

	public static String afficheClient(Client client) {
		String string = null;
		if (client instanceof PersonneMorale) {
			PersonneMorale clientMorale = (PersonneMorale) client;
			string = "M:" + clientMorale.getRef() + ":" + clientMorale.getSiret() + ":"
					+ clientMorale.getCodeAPE() + ":" + clientMorale.getAdresse().getCp() + ":"
					+ clientMorale.getAdresse().getVille() + ":"
					+ clientMorale.getAdresse().getRue();
		} else if (client instanceof PersonnePhysique) {
			PersonnePhysique clientPhysique = (PersonnePhysique) client;
			string = "P:" + clientPhysique.getRef() + ":" + clientPhysique.getNom() + ":"
					+ clientPhysique.getPrenom() + ":" + clientPhysique.getAdresse().getCp() + ":"
					+ clientPhysique.getAdresse().getVille() + ":"
					+ clientPhysique.getAdresse().getRue();
		}
		return string;
	}

	public static String afficheForfait(Forfait forfait, Client client) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		String string = null;
		if (forfait instanceof ForfaitFixe) {
			ForfaitFixe forfaitFixe = (ForfaitFixe) forfait;
			string = "F:" + forfaitFixe.getRef() + ":"
					+ simpleDateFormat.format(forfaitFixe.getDateDebut()) + ":"
					+ simpleDateFormat.format(forfaitFixe.getDateFin()) + ":"
					+ forfaitFixe.getNumero() + ":" + forfaitFixe.getMateriel().getRef() + ":"
					+ forfaitFixe.getMateriel().getType() + ":" + forfaitFixe.getAdresse().getCp()
					+ ":" + forfaitFixe.getAdresse().getVille() + ":"
					+ forfaitFixe.getAdresse().getRue() + ":" + client.getRef();
		} else if (forfait instanceof ForfaitMobile) {
			ForfaitMobile forfaitMobile = (ForfaitMobile) forfait;
			string = "M:" + forfaitMobile.getRef() + ":"
					+ simpleDateFormat.format(forfaitMobile.getDateDebut()) + ":"
					+ simpleDateFormat.format(forfaitMobile.getDateFin()) + ":"
					+ forfaitMobile.getNumero() + ":" + forfaitMobile.getMateriel().getRef() + ":"
					+ forfaitMobile.getMateriel().getType() + ":" + forfaitMobile.getDuree() + ":"
					+ forfaitMobile.getNbSms() + ":" + client.getRef();
		}
		return string;

	}
}
