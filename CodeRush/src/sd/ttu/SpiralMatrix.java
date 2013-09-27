package sd.ttu;

public class SpiralMatrix {

	public static void main(final String[] args) {
		final int A[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 },
				{ 13, 14, 15, 16, 17, 18 }, { 19, 20, 21, 22, 23, 24 },
				{ 25, 26, 27, 28, 29, 30 }, { 31, 32, 33, 34, 35, 36 } };

		final int size = 6;

		final int loop = (int) Math.ceil(size / 2.0);

		int rir = 0, cirl = 0, cirh = size - 1;
		int ridl = 1, ridh = size - 1, cid = size - 1;
		int ril = size - 1, cilh = size - 2, cill = 0;
		int riuh = size - 2, riul = 1, ciu = 0;

		for (int i = 0; i < loop; i++) {

			for (int j = cirl; j <= cirh; j++) {
				System.out.print(A[rir][j] + " ");
			}

			rir++;
			cirl++;
			cirh--;

			for (int j = ridl; j <= ridh; j++) {
				System.out.print(A[j][cid] + " ");
			}

			ridl++;
			ridh--;
			cid--;

			for (int j = cilh; j >= cill; j--) {
				System.out.print(A[ril][j] + " ");
			}

			ril--;
			cilh--;
			cill++;

			for (int j = riuh; j >= riul; j--) {
				System.out.print(A[j][ciu] + " ");
			}
			riuh--;
			riul++;
			ciu++;
		}
	}
}
