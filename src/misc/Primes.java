package misc;

import java.util.Arrays;

public class Primes {

	public static void printListOfPrimes(int n) {
		if (n == 0 || n == 1)
			return;

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);
		primes[1] = false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (primes[i]) {

				for (int j = i * i; j <= n; j += i) {
					primes[j] = false;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (primes[i])
				System.out.print(i + ",");
		}
	}

	public static void main(String[] args) {

		printListOfPrimes(12);

	}
}
