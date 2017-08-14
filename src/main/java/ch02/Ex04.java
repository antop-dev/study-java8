package ch02;

import org.omg.CORBA.IntHolder;

public class Ex04 {

	public static void main(String[] args) {
		IntHolder ih1 = new IntHolder(10);
		IntHolder ih2 = new IntHolder(20);
		System.out.println("ih1 = " + ih1.value + ", ih2 = " + ih2.value);

		// 교체
		int temp = ih1.value;
		ih1.value = ih2.value;
		ih2.value = temp;
		System.out.println("ih1 = " + ih1.value + ", ih2 = " + ih2.value);
		
		Integer i1 = new Integer(111);
		Integer i2 = new Integer(222);
		System.out.println("i1 = " + i1 + ", i2 = " + i2);
		
		Integer t = i1;
		i1 = i2;
		i2 = t;
		System.out.println("i1 = " + i1 + ", i2 = " + i2);
	}

}
