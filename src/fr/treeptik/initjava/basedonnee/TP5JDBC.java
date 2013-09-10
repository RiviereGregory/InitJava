package fr.treeptik.initjava.basedonnee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TP5JDBC {

	/**
	 * @param args
	 * @throws Exception
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/employee_manager", "root", "root");

		connection.setAutoCommit(false);

		// Enregistre un employee avec l'adresse
		creationEmployeeAdresse(connection);

		Scanner scanner = new Scanner(System.in);
		String line = "";
		System.out.println("Entrer le nom recherché : ");
		line = scanner.nextLine();
		// Recherche le nom d'un employe et l'affiche
		afficheEmployeeAdresseDepartement(connection, line);

		System.out.println("Entrer le nom a supprimer : ");
		line = scanner.nextLine();

		supprimeEmployeeAdresse(connection, line);
		// Affiche la liste des employés
		afficheEmployeeAdresseDepartement(connection);
		// Affiche la liste d'adresse
		afficheAdresse(connection);
		// Affecte un manager a un employé
		affecteManager(connection, scanner);

		afficheEmployee(connection);
		// Affiche la liste de employés qui ont un manager
		afficheEmployeeManager(connection);

		scanner.close();
	}

	public static void creationEmployeeAdresse(Connection connection) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement prepareStatement = connection.prepareStatement(
				"INSERT INTO Adress (city,state,street,zip) VALUES (?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		// On prepare l'insertion des paramètre qui commence par 1 en JAXB
		prepareStatement.setString(1, "City1");
		prepareStatement.setString(2, "State1");
		prepareStatement.setString(3, "Street1");
		prepareStatement.setString(4, "Zip1");
		prepareStatement.executeUpdate();

		ResultSet keys = prepareStatement.getGeneratedKeys();
		keys.next();
		int key = keys.getInt(1);

		System.out.println("Adress key : " + key);

		prepareStatement = connection.prepareStatement("INSERT INTO Employee"
				+ "(name,salary,startdate,adresse_id,departement_id) VALUES (?,?,?,?,?)");
		// On prepare l'insertion des paramètre qui commence par 1 en JAXB
		prepareStatement.setString(1, "Name4");
		prepareStatement.setInt(2, 15000);
		// Création d'une date util pour la mettre dans une date sql

		java.util.Date dateNaissance = new java.util.Date();
		String dateString = "22/12/2003";
		try {
			dateNaissance = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		prepareStatement.setDate(3, new Date(dateNaissance.getTime()));
		prepareStatement.setInt(4, key);
		prepareStatement.setInt(5, 3);
		prepareStatement.executeUpdate();

		connection.commit();

	}

	public static void afficheEmployee(Connection connection) throws SQLException {
		PreparedStatement prepareStatement = connection
				.prepareStatement("SELECT e.id AS id_employee, "
						+ "e.name AS employee_nom, e.salary AS employee_salaire, e.startdate AS employee_date ,e.manager_id, "
						+ "d.id AS department_id,d.name AS department_name FROM Employee e "
						+ "LEFT JOIN Department d ON e.departement_id=d.id");
		ResultSet resultSet = prepareStatement.executeQuery();
		System.out.println("");
		System.out.println("/* Liste Employés");
		while (resultSet.next()) {
			System.out.print("Id : " + resultSet.getInt("id_employee"));
			System.out.print(" Nom : " + resultSet.getString("employee_nom"));
			System.out.print(" Salaire : " + resultSet.getInt("employee_salaire"));
			System.out.print(" Date de naissance : " + resultSet.getDate("employee_date"));
			System.out.print(" Manager ID : " + resultSet.getInt("manager_id"));
			System.out.println(" Departement : " + resultSet.getString("department_name"));

		}
	}

	public static void afficheEmployeeAdresseDepartement(Connection connection, String line)
			throws SQLException {
		// Pour avoir toutes les info d'un employé avec adresse et departement de travail
		// Les Alias permettent de distinguer les colonne qui ont un même nom
		PreparedStatement prepareStatement = connection
				.prepareStatement("SELECT e.id AS id_employee, "
						+ "e.name AS employee_nom, e.salary AS employee_salaire, e.startdate AS employee_date ,e.manager_id, "
						+ "a.id AS adresse_id,a.city AS adresse_city, a.state AS adresse_state, a.street AS adresse_street,a.zip AS adresse_zip, "
						+ "d.id AS department_id,d.name AS department_name FROM Employee e "
						+ "LEFT JOIN Adress a ON e.adresse_id = a.id "
						+ "LEFT JOIN Department d ON e.departement_id=d.id WHERE e.name=?");
		prepareStatement.setString(1, line);
		ResultSet resultSet = prepareStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println("////////////");
			System.out.println("Id : " + resultSet.getInt("id_employee"));
			System.out.print(" Nom : " + resultSet.getString("employee_nom"));
			System.out.print(" Salaire : " + resultSet.getInt("employee_salaire"));
			System.out.print(" Date de naissance : " + resultSet.getDate("employee_date"));
			System.out.println(" Manager ID : " + resultSet.getInt("manager_id"));

			System.out.print("ville : " + resultSet.getString("adresse_city"));
			System.out.print(" etat : " + resultSet.getString("adresse_state"));
			System.out.print(" adresse : " + resultSet.getString("adresse_street"));
			System.out.println(" code postal : " + resultSet.getString("adresse_zip"));

			System.out.println("Departement : " + resultSet.getString("department_name"));

		}

	}

	public static void afficheEmployeeAdresseDepartement(Connection connection) throws SQLException {
		// Pour avoir toutes les info d'un employé avec adresse et departement de travail
		// Les Alias permettent de distinguer les colonne qui ont un même nom
		PreparedStatement prepareStatement = connection
				.prepareStatement("SELECT e.id AS id_employee, "
						+ "e.name AS employee_nom, e.salary AS employee_salaire, e.startdate AS employee_date ,e.manager_id, "
						+ "a.id AS adresse_id,a.city AS adresse_city, a.state AS adresse_state, a.street AS adresse_street,a.zip AS adresse_zip, "
						+ "d.id AS department_id,d.name AS department_name FROM Employee e "
						+ "LEFT JOIN Adress a ON e.adresse_id = a.id "
						+ "LEFT JOIN Department d ON e.departement_id=d.id");

		ResultSet resultSet = prepareStatement.executeQuery();

		System.out.println("");
		System.out.println("/* Liste Employés");
		while (resultSet.next()) {
			System.out.println("////////////");
			System.out.print("Id : " + resultSet.getInt("id_employee"));
			System.out.print(" Nom : " + resultSet.getString("employee_nom"));
			System.out.print(" Salaire : " + resultSet.getInt("employee_salaire"));
			System.out.print(" Date de naissance : " + resultSet.getDate("employee_date"));
			System.out.println(" Manager ID : " + resultSet.getInt("manager_id"));

			System.out.print("ville : " + resultSet.getString("adresse_city"));
			System.out.print(" etat : " + resultSet.getString("adresse_state"));
			System.out.print(" adresse : " + resultSet.getString("adresse_street"));
			System.out.println(" code postal : " + resultSet.getString("adresse_zip"));

			System.out.println("Departement : " + resultSet.getString("department_name"));

		}

	}

	public static void supprimeEmployeeAdresse(Connection connection, String line)
			throws SQLException {
		PreparedStatement prepareStatement = connection
				.prepareStatement("DELETE FROM Employee WHERE name=?");
		prepareStatement.setString(1, line);
		prepareStatement.executeUpdate();

		prepareStatement = connection
				.prepareStatement("DELETE FROM Adress WHERE NOT EXISTS (SELECT e.adresse_id FROM Employee e WHERE Adress.id=e.adresse_id)");
		prepareStatement.executeUpdate();
		// Pour executer les executeUpdate() qui sont fait pas besoin pour les executeQuery()
		connection.commit();

	}

	public static void afficheAdresse(Connection connection) throws SQLException {
		PreparedStatement prepareStatement = connection
				.prepareStatement("SELECT a.id AS adresse_id,a.city AS adresse_city, a.state AS adresse_state, a.street AS adresse_street,a.zip AS adresse_zip FROM Adress a ");
		ResultSet resultSet = prepareStatement.executeQuery();
		System.out.println("");
		System.out.println("/* List Adresse");
		while (resultSet.next()) {
			System.out.println("************");
			System.out.println("Id : " + resultSet.getInt("adresse_id"));
			System.out.println("ville : " + resultSet.getString("adresse_city"));
			System.out.println("etat : " + resultSet.getString("adresse_state"));
			System.out.println("adresse : " + resultSet.getString("adresse_street"));
			System.out.println("code postal : " + resultSet.getString("adresse_zip"));

		}
	}

	public static void affecteManager(Connection connection, Scanner scanner) throws SQLException {

		// Affiche les employés
		PreparedStatement prepareStatement = connection
				.prepareStatement("SELECT e.id AS id_employee, e.name AS employee_nom FROM Employee e ");
		ResultSet resultSet = prepareStatement.executeQuery();

		while (resultSet.next()) {
			System.out.print("Id : " + resultSet.getInt("id_employee"));
			System.out.println(" Nom : " + resultSet.getString("employee_nom"));
		}
		System.out.println("Entrer le numéro du manager :");
		String line = scanner.nextLine();
		int idManager = Integer.valueOf(line);
		System.out.println("Entrer le nom de l'employé qui est managé :");
		line = scanner.nextLine();
		// affecte un manager à un employé
		prepareStatement = connection
				.prepareStatement("UPDATE Employee SET manager_id=? WHERE name=?");
		prepareStatement.setInt(1, idManager);
		prepareStatement.setString(2, line);
		prepareStatement.executeUpdate();
		connection.commit();

	}

	public static void afficheEmployeeManager(Connection connection) throws SQLException {
		PreparedStatement prepareStatement = connection
				.prepareStatement("SELECT e.id AS id_employee, e.name AS employee_nom ,e.manager_id FROM Employee e WHERE e.manager_id > 0");
		ResultSet resultSet = prepareStatement.executeQuery();
		System.out.println("");
		System.out.println("/* Liste Employée managé");
		while (resultSet.next()) {
			System.out.print("Id : " + resultSet.getInt("id_employee"));
			System.out.print(" Nom : " + resultSet.getString("employee_nom"));
			System.out.println(" Manager ID : " + resultSet.getInt("manager_id"));

		}
	}

}
