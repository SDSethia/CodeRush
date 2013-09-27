package sd.ttu;

public class MaxSubArray {

	/**
	 * Find the max sub array within a 1-D array
	 * http://en.wikipedia.org/wiki/Maximum_subarray_problem Use the
	 * MaxSubArr_generator.xlsx to generate new arrays to test the code
	 */
	public static void main(final String[] args) {
		final int arr[] = { 1, 2, 3, -5, -3, 2, 7, -4, 5 };
		final int maxSoFar[] = new int[3]; // holds i,j and maxvalue in 0,1 and
											// 2 positions
		final int maxEndHere[] = new int[3]; // holds i,j and maxvalue in 0,1
												// and 2 positions
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			final int max = Math.max(0, maxEndHere[2] + arr[i]);
			if (max > 0) {
				if (!flag) {
					maxEndHere[0] = i;
					maxEndHere[1] = i;
					maxEndHere[2] = arr[i];
					flag = true;
				} else {
					maxEndHere[1] = i;
					maxEndHere[2] += arr[i];
				}
			} else {
				flag = false;
			}
			if (maxSoFar[2] < maxEndHere[2]) {
				maxSoFar[0] = maxEndHere[0];
				maxSoFar[1] = maxEndHere[1];
				maxSoFar[2] = maxEndHere[2];
			}

		}
		for (int i = maxSoFar[0]; i <= maxSoFar[1]; i++) {
			System.out.println(arr[i] + " ");
		}
	}

}
