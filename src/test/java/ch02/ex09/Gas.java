package ch02.ex09;

public class Gas {

	private double capacity = 0;
	private double used = 0;

	public void use(double gallons) {
		this.capacity -= gallons;
		this.used += gallons;
	}

	/**
	 * 가스 충전
	 * 
	 * @param gallons
	 */
	public void charge(double gallons) {
		this.capacity += gallons;
	}

	/**
	 * 남은 가스량
	 * 
	 * @return
	 */
	public double getCapacity() {
		return capacity;
	}

	/**
	 * 사용한 가스량
	 * 
	 * @return
	 */
	public double getUsed() {
		return used;
	}

}
