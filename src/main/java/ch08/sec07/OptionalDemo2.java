package ch08.sec07;

import java.util.Optional;

public class OptionalDemo2 {

	public static void main(String[] args) {
		double x = 12.2;

		Optional<Optional<Double>> map = inverse(x).map(d -> squareRoot(d));

		Optional<Double> flatMap = inverse(x).flatMap(d -> squareRoot(d));

	}

	public static Optional<Double> inverse(Double x) {
		return x == 0 ? Optional.empty() : Optional.of(1 / x);
	}

	public static Optional<Double> squareRoot(Double x) {
		return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
	}

}
