package ch01;

public class Ex09 {

	public static void main(String[] args) {
		String s1 = "antop";
		String s2 = "antop";
		String s3 = new String("antop");

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s3));
	}

}
