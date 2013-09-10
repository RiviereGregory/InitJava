package fr.treeptik.initjava.basedonnee;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TP5JDBCMetaData {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/employee_manager", "root", "root");

		DatabaseMetaData metaData = connection.getMetaData();
		
		// Récupération des info
		ResultSet tables = metaData.getTables(connection.getCatalog(), null, "%", null);		
		// Récupération du database avec affiche de toutes les tables
		while(tables.next()){
			System.out.println("////////////////////");
			for(int i=0;i< tables.getMetaData().getColumnCount();i++){
				String nomColonne = tables.getMetaData().getColumnName(i+1);
				Object valeurColonne = tables.getObject(i+1);
				System.out.println(nomColonne+" = "+valeurColonne);
			}
		}
		
		// Recupere les information sur la table Employee (Equivalent de DESC en plus détaillé)
		String nomTable = "Employee";
		// Récupération des info
		ResultSet resultat = metaData.getColumns(connection.getCatalog(), null, nomTable, "%");
		// Affichage des info
		ResultSetMetaData resultSetMetaData = resultat.getMetaData();
		while (resultat.next()) {
			System.out.println("***********************");
			for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
				String col = resultSetMetaData.getColumnName(i+1);
				Object val = resultat.getObject(i+1);
				System.out.println(col+" = "+val);
				
			}
			
		}
		
		// Permet de récupére les INDEX (la clef primaire les constraints...)
		resultat = metaData.getIndexInfo(connection.getCatalog(), null, "Employee", false, false);
		resultSetMetaData = resultat.getMetaData();
		while (resultat.next()) {
			System.out.println("###########################");
			for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
				String col = resultSetMetaData.getColumnName(i+1);
				Object val = resultat.getObject(i+1);
				System.out.println(col+" = "+val);				
			}			
		}
		
		
	}

}
