package ch02.ex09;

public class Car {

	private final double milesPerGallon;
	private Gas gas;

	/**
	 * 
	 * @param milesPerGallon
	 *            연료 효율성(갤런당 마일 단위)
	 */
	public Car(int milesPerGallon) {
		this.gas = new Gas();
		this.milesPerGallon = milesPerGallon;
	}

	/**
	 * 지정한 거리(mile)만큼 이동한다.
	 * 
	 * @param miles
	 *            거리
	 * @return
	 */
	public Car drive(double miles) {
		gas.use(miles / milesPerGallon);
		return this;
	}

	/**
	 * 지정한 수만큼 가스 탱크에 갤런을 채운다.
	 * 
	 * @param gallons
	 *            가스(gallon)
	 * @return
	 */
	public Car charge(double gallons) {
		gas.charge(gallons);
		return this;
	}

	public double getMiles() {
		return gas.getUsed() * milesPerGallon;
	}

	public double getMilesPerCallon() {
		return milesPerGallon;
	}

	public Gas getGas() {
		return gas;
	}

}
