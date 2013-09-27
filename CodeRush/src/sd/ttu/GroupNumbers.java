package sd.ttu;

public class GroupNumbers {

	/**
	 * given a set of positive and negative integers group all the positive
	 * integers on one side and negative integers on one side... numbers should
	 * be in the same order they appear....
	 */
	public static void main(final String[] args) {
		final int arr[] = { 1, 2, 3, -5, -3, 2, 7, -4, 5 };
		int nIndex = -1;
		int pIndex = 0;
		int tIndex = 0;

		while (pIndex < arr.length) {
			if (arr[pIndex] >= 0) {
				if (nIndex < 0) {
					pIndex++;
				} else {
					tIndex = pIndex++;
					while (tIndex > nIndex) {
						final int temp = arr[tIndex];
						arr[tIndex] = arr[tIndex - 1];
						arr[tIndex - 1] = temp;
						tIndex--;
					}
					nIndex++;
				}
			} else {
				if (nIndex < 0) {
					nIndex = pIndex++;
				} else {
					pIndex++;
				}
			}

		}
		for (final int element : arr) {
			System.out.print(element + " ");
		}
	}

}
