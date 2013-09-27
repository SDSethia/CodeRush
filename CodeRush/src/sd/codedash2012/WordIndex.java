package sd.codedash2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordIndex {

	public static void main(final String[] args) throws IOException {
		while (true) {
			System.out.println("enter the digits");
			final BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			final char[] inputArr = br.readLine().toLowerCase().toCharArray();
			int curLength = inputArr.length - 1;
			int result = 0;
			for (int i = 0; i < inputArr.length; i++) {
				if (i > 0) {
					if (inputArr[i] < inputArr[i - 1]) {
						System.out.println("Invalid!!!");
						break;
					}
				}
				System.out.println((inputArr[i] - 'a') + 1);
				result += (Math.pow(26, curLength)) * ((inputArr[i] - 'a') + 1);
				curLength--;
			}
			System.out.println(result);
			if (inputArr.length > 1) {
				final int series = (inputArr[0] - 'a') + 1;
				result -= (series * (series + 1)) / 2;
			}
			System.out.println(result);
			result = 0;
			for (int i = 24; i >= 1; i--) {
				result += (i * (i + 1)) / 2;
			}
			System.out.println(result);
		}

	}
}
