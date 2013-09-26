package code.sd.psecurity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordSecurity {

	public static void main(final String[] args) throws NumberFormatException,
			IOException {

		while (true) {
			System.out.println("enter an password");
			final BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			final String input = br.readLine().toLowerCase();
			boolean oneVowel = false;
			boolean threeConsecutive = false;
			boolean twoConsecutive = false;
			if ("end".equals(input)) {
				break;
			}
			final char[] tokens = input.toCharArray();
			final char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
			final char[] notEO = { 'a', 'b', 'c', 'd', 'f', 'g', 'h', 'i', 'j',
					'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
					'x', 'y', 'z' };
			for (int i = 0; i < (tokens.length); i++) {
				final char x = tokens[i];
				final char y, z;
				if ((i + 1) < tokens.length) {
					y = tokens[i + 1];
				} else {
					y = '\0';
				}
				if ((i + 2) < tokens.length) {
					z = tokens[i + 2];
				} else {
					z = '\0';
				}
				if (!oneVowel) {
					for (final char v : vowels) {
						if (v == x) {
							oneVowel = true;
							break;
						}
					}
				}
				if (!threeConsecutive) {
					if ((x == vowels[0]) || (x == vowels[1])
							|| (x == vowels[2]) || (x == vowels[3])
							|| (x == vowels[4])) {
						if ((y == vowels[0]) || (y == vowels[1])
								|| (y == vowels[2]) || (y == vowels[3])
								|| (y == vowels[4])) {
							if ((z == vowels[0]) || (z == vowels[1])
									|| (z == vowels[2]) || (z == vowels[3])
									|| (z == vowels[4])) {
								threeConsecutive = true;
							}
						}
					}
					if ((x != vowels[0]) && (x != vowels[1])
							&& (x != vowels[2]) && (x != vowels[3])
							&& (x != vowels[4])) {
						if ((y != '\0') && (y != vowels[0]) && (y != vowels[1])
								&& (y != vowels[2]) && (y != vowels[3])
								&& (y != vowels[4])) {
							if ((z != '\0') && (z != vowels[0])
									&& (z != vowels[1]) && (z != vowels[2])
									&& (z != vowels[3]) && (z != vowels[4])) {
								threeConsecutive = true;
							}
						}
					}
				}
				if (!twoConsecutive) {
					for (final char w : notEO) {
						if (x == w) {
							for (final char u : notEO) {
								if (y == u) {
									twoConsecutive = true;
								}
							}
						}
					}
				}
			}
			System.out.println(oneVowel + " " + threeConsecutive + " "
					+ twoConsecutive);
			if (oneVowel && !threeConsecutive && !twoConsecutive) {
				System.out.println("<" + input + "> " + "is acceptable");
			} else {
				System.out.println("<" + input + "> " + "is not acceptable");
			}
		}

	}
}
