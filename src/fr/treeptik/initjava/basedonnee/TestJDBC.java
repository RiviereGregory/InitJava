package fr.treeptik.initjava.basedonnee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBC {

	public static void main(String[] args) throws Exception {

		// Permet de rentrer dans le driver
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		// équivalent dans la console de :
		// mysql -u root -proot
		// USE annuaire;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/annuaire",
				"root", "root");

		// Permet de faire en sorte que toutes les commandes soit faite si une plante toutes les
		// transations seront annulée
		connection.setAutoCommit(false);

		PreparedStatement prepareStatement = null;
		// On insere les commandes avec cette fonction
		prepareStatement = connection.prepareStatement("INSERT INTO personne"
				+ "(nom,prenom,datenaissance) VALUES ('JAVA','Pers2',now())");
		// executeupdate permet d'executer rous les update pour le selecte c'est avec query
		 prepareStatement.executeUpdate();

		// Il faut mieux faire avec des point d'interrogaton
		prepareStatement = connection.prepareStatement("INSERT INTO personne"
				+ "(nom,prenom,datenaissance) VALUES (?,?,?)");
		// On prepare l'insertion des paramètre qui commence par 1 en JAXB
		prepareStatement.setString(1, "PersonneNom1");
		prepareStatement.setString(2, "PersonnePrenom1");
		// Création d'une date util pour la mettre dans une date sql
		java.util.Date dateNaissance = new java.util.Date();
		prepareStatement.setDate(3, new Date(dateNaissance.getTime()));
		prepareStatement.executeUpdate();

		// Pour rechercher que les personnes qui porte le nom de ?
		prepareStatement = connection.prepareStatement("SELECT * FROM personne WHERE nom=?");
		prepareStatement.setString(1, "Pers2");
		// prepareStatement = connection.prepareStatement("SELECT * FROM personne ");
		// Permet de pointer les données dans la base on a rien récupérer comme données
		ResultSet resultSet = prepareStatement.executeQuery();
		// permet de ce positionner sur le premier next puis les suivants
		while (resultSet.next()) {
			System.out.println("ID : " + resultSet.getInt("id"));
			System.out.println("Nom : " + resultSet.getString("nom"));
			System.out.println("Prenom : " + resultSet.getString("prenom"));
			System.out.println("Date de naissance : " + resultSet.getDate("datenaissance"));
		}

		// Permet d'effacer les personnes qui ont un nom PersonneNom1
		prepareStatement = connection.prepareStatement("DELETE FROM personne WHERE nom='PersonneNom1'");
		prepareStatement.executeUpdate();
		// Permet de valider toutes les transactions
		connection.commit();

	}

}
