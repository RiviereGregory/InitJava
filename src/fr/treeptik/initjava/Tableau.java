package fr.treeptik.initjava;

import java.util.Scanner;

public class Tableau {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		Integer[] integers = new Integer[5];
		
		while(! "q".equalsIgnoreCase(line)){			
			System.out.println("entrer un entier :");
			line = scanner.nextLine();
			Integer integer = Integer.valueOf(line);
			integers = ajoutElementTableau(integer, integers);
			for (Integer ValueInt : integers) {
				System.out.println(ValueInt);
				
			}			
			System.out.println("pour quitter entrer q ou entrer pour continuer");			
			line = scanner.nextLine();
		}		
		scanner.close();
	}
	
	public static Integer[] ajoutElementTableau(Integer value, Integer[] tableauInt) {
		if(!(tableauInt[tableauInt.length-1] == null)){
			Integer[] newTableauNote = new Integer[tableauInt.length + 5];
			System.arraycopy(tableauInt, 0, newTableauNote, 0, tableauInt.length);
			tableauInt = newTableauNote;
			
			// ou plus simple
//			tableauInt = Arrays.copyOf(tableauInt, tableauInt.length+5);
		}
		
		for(int i=0 ; i< tableauInt.length ; i++){
			if(tableauInt[i] == null){
				tableauInt[i] = value;
				break;
			}
		}
		
		return tableauInt;
	}

}
