package sd.codedash2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class Arithmetic {

	static Map<Integer, Integer> map = null;

	public static int checkSeries(final int x, final int y, final int z) {
		if ((y - x) == (z - y)) {
			return 1;
		} else {
			return 2;
		}
	}

	public static void checkArtErrors(final int[] arr, final int op) {
		for (int i = 2; i < arr.length; i++) {
			final int next = arr[i] + op;
			if (((i + 1) < arr.length) && (next != arr[i + 1])) {
				map.put(arr[i + 1], next);
				arr[i + 1] = next;
			}
		}
	}

	public static void checkMulErrors(final int[] arr, final int op) {
		for (int i = 2; i < arr.length; i++) {
			final int next = arr[i] * op;
			if (((i + 1) < arr.length) && (next != arr[i + 1])) {
				map.put(arr[i + 1], next);
				arr[i + 1] = next;
			}
		}
	}

	public static void main(final String[] args) throws IOException {
		final ArrayList<String> list = new ArrayList<String>();
		final int line = 1;
		while (true) {
			final BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			// map = new HashMap<>();
			StringBuffer str = new StringBuffer();
			final String input = in.readLine();
			if (input.length() < 1) {
				break;
			}
			final String[] sseries = input.split(",");
			final int[] series = new int[sseries.length];
			for (int i = 0; i < sseries.length; i++) {
				series[i] = Integer.parseInt(sseries[i]);
			}
			final int type = checkSeries(series[0], series[1], series[2]);
			if (type == 1) {
				final int diff = series[1] - series[0];
				checkArtErrors(series, diff);
				str = str.append(line + ". arithmetic: " + series.length
						+ " terms, " + map.size() + " errors:");
				for (final Entry<Integer, Integer> entry : map.entrySet()) {
					str.append(entry.getKey() + ":" + entry.getValue());
				}
				list.add(str.toString());
			} else {
				final int div = series[1] / series[0];
				checkMulErrors(series, div);
				str = str.append(line + ". geometric: " + series.length
						+ " terms, " + map.size() + " errors:");
				for (final Entry<Integer, Integer> entry : map.entrySet()) {
					str.append(entry.getKey() + ":" + entry.getValue());
				}
				list.add(str.toString());
			}

		}
		for (final Object element : list) {
			final String string = (String) element;
			System.out.println(string);
		}
	}
}
