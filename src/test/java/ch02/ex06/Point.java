package ch02.ex06;

/**
 * 평면에 놓인 점을 기술하는 점 클래스
 * 
 * @author antop
 *
 */
public class Point {

	private double x;
	private double y;

	/**
	 * 0,0으로 점을 생성한다.
	 */
	public Point() {
		this(0, 0);
	}

	/**
	 * x좌표와 y좌표를 지정하여 점을 생성한다.
	 * 
	 * @param x
	 * @param y
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * x 좌표
	 * 
	 * @return
	 */
	public double getX() {
		return x;
	}

	/**
	 * y 좌표
	 * 
	 * @return
	 */
	public double getY() {
		return y;
	}

	/**
	 * 지정한 x, y 좌표만큼 이동한다.
	 * 
	 * @param x
	 *            이동할 x 크기
	 * @param y
	 *            이동할 y 크기
	 * @return {@link Point}
	 */
	public Point translate(double x, double y) {
		this.x = this.x + x;
		this.y = this.y + y;
		return this;
	}

	/**
	 * 
	 * 지정한 배율만큼 좌표를 확대/축소한다.
	 * 
	 * @param scale
	 *            배율
	 * @return 새로운 {@link Point}
	 */
	public Point scale(double scale) {
		this.x = this.x * scale;
		this.y = this.y * scale;
		return this;
	}

}