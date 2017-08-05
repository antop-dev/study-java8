package ch01;

class Ex04 {

	public static void main(String[] args) {
		double min = Math.nextUp(0);
		double max = Math.nextDown(Double.MAX_VALUE);

		System.out.println("min = " + min);
		System.out.println("max = " + max);
	}

}
