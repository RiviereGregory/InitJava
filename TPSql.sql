// création de la base
CREATE DATABASE employee_manager;
USE employee_manager;

//création des tables
CREATE TABLE Employee (id INT NOT NULL AUTO_INCREMENT,name VARCHAR(255), salary BIGINT, startdate DATE,adresse_id INT,departement_id INT, PRIMARY KEY (id));
CREATE TABLE Project (id INT NOT NULL AUTO_INCREMENT,dtype VARCHAR(31), name VARCHAR(255),PRIMARY KEY (id));
CREATE TABLE Department (id INT NOT NULL AUTO_INCREMENT,name VARCHAR(255),PRIMARY KEY (id));
CREATE TABLE Adress (id INT NOT NULL AUTO_INCREMENT,city VARCHAR(255), state VARCHAR(255), street VARCHAR(255),zip VARCHAR(255),PRIMARY KEY (id));
CREATE TABLE Work (project_id INT,employee_id INT,PRIMARY KEY (project_id,employee_id));

// Insertion des données dans les tables
INSERT INTO Adress (city,state,street,zip) VALUES ('Marseille','France','BD Baille','13005');
INSERT INTO Adress (city,state,street,zip) VALUES ('Aix-en-provence','France','Cours Mirabeau','13100');
INSERT INTO Adress (city,state,street,zip) VALUES ('New York','NY','123 Apple Tree','10001');

INSERT INTO Department (name) VALUES ('Qualité');
INSERT INTO Department (name) VALUES ('R&D');
INSERT INTO Department (name) VALUES ('Web');

INSERT INTO Project (name) VALUES ('TOPPUB');
INSERT INTO Project (name) VALUES ('Fusion Portail Web');
INSERT INTO Project (name) VALUES ('Copernic');

INSERT INTO Employee (name,salary,startdate,adresse_id,departement_id) VALUES ('Jhon',15000,'2001-01-01',1,1);
INSERT INTO Employee (name,salary,startdate,adresse_id,departement_id) VALUES ('Rob',20000,'2011-03-12',2,2);
INSERT INTO Employee (name,salary,startdate,adresse_id,departement_id) VALUES ('Peter',25000,'2012-06-05',2,3);

INSERT INTO Work (project_id,employee_id) VALUES (1,1);
INSERT INTO Work (project_id,employee_id) VALUES (1,2);
INSERT INTO Work (project_id,employee_id) VALUES (2,2);

// Ajout de colonne dans les tables
ALTER TABLE Employee ADD COLUMN manager_id int;
//Ajout de contrainte
ALTER TABLE Employee ADD CONSTRAINT fk_id_manager FOREIGN KEY (manager_id) REFERENCES Employee(id);
//Insertion de donnée
INSERT INTO Employee(name) VALUES ('Gavin');
//Modification de donnée dans la_table
UPDATE Employee SET manager_id=4 WHERE name='Rob';
// Ajout de colonne dans les tables
ALTER TABLE Employee ADD COLUMN lastname VARCHAR(255);

// Calcul de valeur dans un alias(as)
SELECT * FROM Employee WHERE salary IS NOT NULL ORDER BY salary DESC;
SELECT MAX(e.salary) AS max FROM Employee e;
SELECT e.name, MIN(salary) AS min FROM Employee e;
SELECT AVG(salary) AS moyenne FROM Employee;

// Recherche du nom des projets de l_employee avec l_id 1 avec la jointure pour faire le chemin entre table Employee et project en passant par work
SELECT p.name FROM Project p INNER JOIN Work w ON p.id=w.project_id INNER JOIN Employee e ON e.id=w.employee_id WHERE e.id=1; 

// Pour afficher le nom des employés et des projets associés on met RIGHT pour que les projets sans employés soit afficher
SELECT p.name,e.name FROM Employee e INNER JOIN Work w ON e.id=w.employee_id RIGHT JOIN Project p ON p.id=w.project_id ORDER BY p.name;

// pour selectionner les employés qui n_ont pas de projet
SELECT e.name FROM Employee e WHERE NOT EXISTS (SELECT employee_id FROM Work WHERE employee_id=e.id);
// on peut utiliser not in la différence c_est que si on test une valeur null elle sera vrai
SELECT e.name FROM Employee e WHERE e.id NOT IN (SELECT employee_id FROM Work);

//Pour selectionner tous les projets du department Qualité
SELECT p.name FROM Project p INNER JOIN Work w ON p.id=w.project_id INNER JOIN Employee e ON e.id=w.employee_id INNER JOIN Department d 
ON e.departement_id=d.id WHERE d.name='Qualité'; 

// Afficher le nom de tous les projets classés par département
SELECT p.name,d.name FROM Project p INNER JOIN Work w ON p.id=w.project_id INNER JOIN Employee e ON e.id=w.employee_id INNER JOIN Department d 
ON e.departement_id=d.id ORDER BY d.name; 

// Modification du departement des employés
UPDATE Employee SET departement_id=2 WHERE name='Gavin'; 
UPDATE Employee SET departement_id=null WHERE name='Gavin'; 
UPDATE Employee SET departement_id=1 WHERE name='Peter'; 
UPDATE Employee SET departement_id=3 WHERE name='Peter'; 


SELECT departement_id, COUNT(departement_id) AS nbdpt FROM Employee GROUP BY departement_id ORDER BY nbdpt DESC;
SELECT MAX(a.nbdpt) FROM (SELECT departement_id, COUNT(departement_id) AS nbdpt FROM Employee GROUP BY departement_id) a;

SELECT departement_id FROM Employee GROUP BY departement_id HAVING count(*) = (SELECT max(nb) FROM (SELECT count(departement_id) AS nb FROM Employee
GROUP BY departement_id) AS Employee ) ;

// correction fabien pour afficher le departement qui a le  plus d_employés
SELECT d.name, e.departement_id , COUNT(e.departement_id) as 'nbEmployees' FROM Employee e JOIN Department d WHERE d.id=e.departement_id 
GROUP BY e.departement_id Order by nbEmployees desc limit 1;
