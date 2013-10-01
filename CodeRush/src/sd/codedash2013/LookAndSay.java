package sd.codedash2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Snehadeep Sethia
 * 
 */
public class LookAndSay {

	public static void main(final String[] args) throws IOException {

		final ArrayList<String> list = new ArrayList<String>();

		while (true) {
			final BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));

			final String[] input = in.readLine().split(" ");
			final int round = Integer.parseInt(input[1]);

			char[] arr = input[0].toCharArray();

			if ((round == 0) && (arr[0] == '0')) {
				break;
			}

			for (int i = 0; (i < round) && (round > 0); i++) {
				int curr = 0;
				int counter = 1;
				StringBuilder str = new StringBuilder();
				for (int j = 0; j < arr.length;) {
					curr = j + 1;
					while ((curr < arr.length) && (arr[j] == arr[curr])) {
						curr++;
						counter++;
					}
					str = str.append(counter).append(arr[j]);
					j = curr;
					counter = 1;
				}
				arr = str.toString().toCharArray();
				System.out.println(i + " " + str); //$NON-NLS-1$
			}
			if (round > 0) {
				list.add(new String(arr));
			}
		}
		for (final Object element : list) {
			final String string = (String) element;
			System.out.println(string);
		}
	}

}
