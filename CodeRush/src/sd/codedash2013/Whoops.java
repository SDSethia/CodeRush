package sd.codedash2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author Snehadeep Sethia
 * 
 */
public class Whoops {

	private static boolean whoops = false;

	private static boolean nextTurn(final String person, final int nextNumber) {

		final String strNumber = Integer.toString(nextNumber);

		if (("michael".equalsIgnoreCase(person)) && (nextNumber != 7)
				&& strNumber.contains("7")) {
			return false;
		} else if (("tim".equalsIgnoreCase(person)) && (nextNumber != 7)
				&& ((nextNumber % 7) == 0)) {
			return false;
		} else if ("lyndsey".equalsIgnoreCase(person)) {
			final int reminder = (((nextNumber % 9) == 0) && (nextNumber != 0)) ? 9
					: nextNumber % 9;
			final boolean partialCond = (reminder == 7) ? false : true;
			if (!partialCond) {
				if (strNumber.contains("7")) {
					return true;
				} else {
					return false;
				}
			} else {
				return partialCond;
			}
		} else if ("richard".equalsIgnoreCase(person) && whoops) {
			whoops = false;
			return false;
		}
		return true;
	}

	private static boolean checkWhoops(final int nextNumber) {

		final String strNumber = Integer.toString(nextNumber);

		if (strNumber.contains("7")
				|| ((nextNumber % 7) == 0)
				|| (((((nextNumber % 9) == 0) && (nextNumber != 0)) ? 9
						: nextNumber % 9) == 7)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(final String[] args) throws IOException {
		final BufferedReader in = new BufferedReader(new InputStreamReader(
				System.in));
		final Map<String, Integer> map = new HashMap<String, Integer>();
		final String[] players = in.readLine().split(" ");
		int noOfRounds = Integer.parseInt(in.readLine());

		for (final String player : players) {
			map.put(player, 0);
		}

		int currentIndex = 0;
		int currentCounter = 0;
		boolean direction = true; // clockwise

		while (noOfRounds > 0) {
			final String currentPerson = players[currentIndex];
			final boolean returnedValue = nextTurn(currentPerson,
					++currentCounter);
			if (returnedValue) {
				final boolean checkWhoops = checkWhoops(currentCounter);
				if (!checkWhoops) {
					System.out.println(currentPerson + "-" + currentCounter);
					whoops = false;
				} else {
					if (!"jr".equalsIgnoreCase(currentPerson)) {
						System.out.println(currentPerson + "-Whoops!");
						direction = (direction == true) ? false : true;
						whoops = true;
					} else {
						System.out
								.println(currentPerson + "-" + currentCounter);
						noOfRounds--;
						int count = map.get(currentPerson);
						map.put(currentPerson, ++count);
						if ("richard".equalsIgnoreCase(currentPerson)) {
							System.out.println("Richard-");
						}
						System.out.println("END OF ROUND");
						currentCounter = 0;
						direction = true;
						currentIndex -= 1;
					}

				}
				if (direction) {
					currentIndex += 1;
					if (currentIndex == players.length) {
						currentIndex = 0;
					}
				} else {
					currentIndex -= 1;
					if (currentIndex < 0) {
						currentIndex = players.length - 1;
					}
				}
			} else {
				noOfRounds--;
				int count = map.get(currentPerson);
				map.put(currentPerson, ++count);
				if ("richard".equalsIgnoreCase(currentPerson)) {
					System.out.println("Richard-");
				} else {
					System.out.println(currentPerson + "-" + currentCounter);
				}
				System.out.println("END OF ROUND");
				currentCounter = 0;
				direction = true;
			}
		}
		for (final Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
