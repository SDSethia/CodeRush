package sd.codedash2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Snehadeep Sethia
 * 
 */
public class Perfection {

	public static void main(final String[] args) throws IOException {

		System.out.println("enter an integer");
		final BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		final int input = Integer.parseInt(br.readLine());
		if (input == 0) {
			System.out.println("EOO");
		} else {
			final ArrayList<Integer> factors = new ArrayList<Integer>();
			factors.add(1);
			int sum = 0;
			for (int i = 2; i <= (input / 2); i++) {
				if ((input % i) == 0) {
					factors.add(i);
				}
			}

			for (final int x : factors) {
				sum += x;
			}
			if (sum == input) {
				System.out.println("perfect");
			} else if (sum < input) {
				System.out.println("deficient");
			} else if (sum > input) {
				System.out.println("abundant");
			} else {
				System.out.println("invalid");
			}
		}
	}
}
