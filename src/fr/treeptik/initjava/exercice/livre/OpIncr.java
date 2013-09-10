package fr.treeptik.initjava.exercice.livre;

public class OpIncr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i, j, n;
		i = 0;
		n = i++;
		System.out.println("A : i = " + i + " n = " + n); // 0 0
		i = 10;
		n = ++i;
		System.out.println("B : i = " + i + " n = " + n);// 11 11
		i = 20;
		j = 5;
		n = i++ * ++j;
		System.out.println("C : i = " + i + " j = " + j + " n = " + n);// 21 6 120
		i = 15;
		n = i += 3;
		System.out.println("D : i = " + i + " "  + "n = " + n);// 18 18
		i = 3;
		j = 5;
		n = i *= --j;
		System.out.println("E : i = " + i + " j = " + j+ " n = " + n);// 12 4 12

	}
}
