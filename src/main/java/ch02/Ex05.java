package ch02;

import ch02.ex05.Point;

public class Ex05 {

	public static void main(String[] args) {
		Point p = new Point(3, 4).translate(1, 3).scale(0.5);
		
		System.out.println(p.getX());
		System.out.println(p.getY());
	}

	

}

