package sd.codedash2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UDSequences {

	public static void main(final String args[]) throws IOException {

		while (true) {
			System.out.println("enter the digits");
			final BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			final String[] inputArr = br.readLine().split(" ");
			final int[] input = new int[inputArr.length];
			for (int i = 0; i < inputArr.length; i++) {
				input[i] = Integer.parseInt(inputArr[i]);
			}
			if ((input.length == 1) && (input[0] == 0)) {
				break;
			}
			boolean incFlip = false;
			boolean decFlip = false;
			float up = 0;
			float down = 0;
			int inc = 0;
			int upDivisor = 0;
			int dec = 0;
			int decDivisor = 0;
			int eql = 0;
			for (int i = 1; i < input.length; i++) {
				final int x = input[i - 1];
				final int y = input[i];
				if (y == 0) {
					if (incFlip) {
						up += inc;
						up += eql;
						upDivisor++;
					}
					if (decFlip) {
						down += dec;
						down += eql;
						decDivisor++;
					}
				} else if (y > x) {
					if (decFlip) {
						down += dec;
						decDivisor++;
						down += eql;
						eql = 0;
						dec = 0;
						decFlip = false;
					}
					up += eql;
					eql = 0;
					incFlip = true;
					inc++;
				} else if (y < x) {
					if (incFlip) {
						up += inc;
						upDivisor++;
						up += eql;
						eql = 0;
						inc = 0;
						incFlip = false;
					}
					down += eql;
					eql = 0;
					decFlip = true;
					dec++;
				} else if (y == x) {
					eql++;
					if (decFlip) {
						down += dec;
						dec = 0;
					}
					if (incFlip) {
						up += inc;
						inc = 0;
					}
				}
			}
			System.out.println((up / upDivisor) + " " + (down / decDivisor));
		}

	}
}
