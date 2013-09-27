package sd.ttu;

public class MaxPalindrome {

	/**
	 * To find the longest palindrome in a string
	 */
	public static void main(final String[] args) {
		final String str = "abcdcbrkeippississippitefxmississippi";
		final char arr[] = str.toCharArray();
		final int paliArr[] = new int[3];// [0] = i, [1] =j and [2] = maxlength
		int oi = 0, i = 0, j = 0;
		int si = 0, ei = 0, len = 0;
		final int psi, pei;
		while ((oi + paliArr[2]) < arr.length) {
			i = oi;
			j = arr.length - 1;
			while (j > i) {
				if (arr[i] != arr[j]) {
					if (len == 0) {
						j--;
					} else {
						len = 0;
						si = 0;
						ei = 0;
						i = oi;
						j--;
					}
				} else {
					if (len == 0) {
						si = i;
						ei = j;
					}
					len += 2;
					i++;
					j--;
				}
			}
			if ((ei - si) > paliArr[2]) {
				paliArr[0] = si;
				paliArr[1] = ei;
				paliArr[2] = (ei - si) + 1;
			}
			oi++;
			len = 0;
		}
		if (paliArr[0] != paliArr[1]) {
			for (int k = paliArr[0]; k <= paliArr[1]; k++) {
				System.out.print(arr[k] + " ");
			}
		} else {
			System.out.println("No palindrome");
		}

	}

}
