package fr.treeptik.initjava.jeurole;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestPersonnage {

	@Test(expected = NullPointerException.class)
	@Ignore // Permet de ne pas faire le test
	public void testAttaquerParamNull() {

		Magicien magicien = new Magicien(10, new Baguette(), "Magicien1");

		magicien.attaquer(null);

	}

	@Test
	public void testAttaquerOk() {
		Magicien magicien = new Magicien(10, new Baguette(), "Magicien1");
		Chevalier chevalier = new Chevalier(10, new Epee(), "Chevalier1");

		int nbVie = magicien.attaquer(chevalier);

		Assert.assertEquals(0, nbVie);// Permet de tester si la valeur retournée dans nbVie est bien
										// égale à 0
		Assert.assertEquals(0, chevalier.getNombreVie().intValue());// Permet de tester si la valeur
																	// contenu dans l'objet
																	// chevalier est bien égale à 0

	}

}
