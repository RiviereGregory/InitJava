package fr.treeptik.initjava;

public class MinMaxTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinMax minMax = new MinMax();
		Integer max = minMax.Max(10, 20);
		System.out.println(max);
		max = minMax.Max(10, 10);
		System.out.println(max);
		max = minMax.Max(100, 20);
		System.out.println(max);
		System.out.println("//////////////////////////");
		Integer min = minMax.Min(10, 20);
		System.out.println(min);
		min = minMax.Min(10, 10);
		System.out.println(min);
		min = minMax.Min(100, 20);
		System.out.println(min);

	}

}
