package sd.google.codejam2010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AlienNumber {
	public static void main(final String[] args) {
		try {
			final BufferedReader in = new BufferedReader(new FileReader(
					"AlienNumber-small.in"));
			final BufferedWriter out = new BufferedWriter(new FileWriter(
					"AlienNumber-small.out"));
			final AlienNumber x = new AlienNumber();
			String str;
			in.readLine();
			while ((str = in.readLine()) != null) {
				final String res = x.convert(str);
				out.write(res + "\n");

			}
			in.close();
			out.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	int count = 1;

	String convert(final String in) {
		final String from = in.split(" ")[0];
		final String src = in.split(" ")[1];
		final String dest = in.split(" ")[2];
		final int sBase = src.length();
		final int dBase = dest.length();
		long num = 0;
		for (int i = 0; i < from.length(); i++) {
			num *= sBase;
			num += (src.indexOf(from.charAt(i)));
		}
		final StringBuffer res = new StringBuffer();
		while (num > 0) {
			final int a = (int) (num % dBase);
			res.append(dest.charAt(a));
			num /= dBase;

		}
		return "Case #" + (count++) + ": " + res.reverse().toString();
	}

}
