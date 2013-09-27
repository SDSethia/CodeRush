package sd.ttu;

public class CatInHat {

	/**
	 * A clever cat walks into a messy room which he needs to clean. Instead of
	 * doing the work alone, it decides to have its helper cats do the work. It
	 * keeps its (smaller) helper cats inside its hat. Each helper cat also has
	 * helper cats in its own hat, and so on. Eventually, the cats reach a
	 * smallest size. These smallest cats have no additional cats in their hats.
	 * These unfortunate smallest cats have to do the cleaning. The number of
	 * cats inside each (non-smallest) cat’s hat is a constant, N. The height of
	 * these cats-in-a-hat is 1/(N+1) times the height of the cat whose hat they
	 * are in. The smallest cats are of height one;these are the cats that get
	 * the work done.All heights are positive integers.Given the height of the
	 * initial cat and the number of worker cats (of height one), find the
	 * number of cats that are not doing any work (cats of height greater than
	 * one) and also determine the sum of all the cats’ heights (the height of a
	 * stack of all cats standing one on top of another).
	 * 
	 * Input: Height of Initial Cat and no of worker cats (last level) Output:
	 * No of non-working cats(lazy cats) and height of all the cats when stacked
	 * together
	 */

	public static int CatsInHat(int wCats, final int workerCats, int divisor) {
		int reminder = 0;
		while (true) {
			if (wCats == 1) {
				break;
			}
			reminder = wCats % divisor;
			if (reminder != 0) {
				divisor++;
				wCats = workerCats;
			} else {
				wCats /= divisor;
			}
		}
		return divisor;
	}

	public static void main(final String[] args) {

		int heightOfInitialCat = 729;
		final int workerCats = 64;
		int level;
		int catsInHat = 0;
		int divisor = 2;
		int lazyCats = 0;
		int totalStackHeight = 0;

		do {
			int wCats = workerCats;
			level = 1;
			catsInHat = CatsInHat(wCats, workerCats, divisor++);
			wCats = workerCats;

			while ((wCats /= catsInHat) != 1) {
				level++;
			}
		} while (Math.pow(catsInHat + 1, level) != heightOfInitialCat);
		/*
		 * This do while is to take care of situation where multiple ans are
		 * ture eg. 64 = 2^6 and 64 = 4^3, so heightOfInitialCat is used to
		 * understand whether it would fall under 2^6 or 4^3
		 */

		for (int i = 0; i < level; i++) {
			lazyCats += Math.pow(catsInHat, i);
		}

		for (int i = 0; i <= level; i++) {
			totalStackHeight += heightOfInitialCat * Math.pow(catsInHat, i);
			heightOfInitialCat /= catsInHat + 1;
		}

		System.out.println(lazyCats + "--" + totalStackHeight);
	}

}
