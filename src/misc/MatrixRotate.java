package misc;

public class MatrixRotate {

	private static void transpose(int[][] a) {
		for (int i = 0; i < a.length; i++)
			for (int j = i; j < a.length; j++) {
				int tmp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = tmp;
			}

	}

	private static void reverseRows(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			int len = a.length / 2;
			for (int j = 0; j < len; j++) {
				int tmp = a[i][j];
				a[i][j] = a[i][a.length - j - 1];
				a[i][a.length - j - 1] = tmp;
			}
		}
	}

	public static void rotate90ClockWise(int[][] a) {
		transpose(a);
		reverseRows(a);

	}

	private static void print(int[][] a) {
		for (int[] x : a) {
			for (int y : x) {
				System.out.print(y + ",");
			}
			System.out.println();
		}
		System.out.println("--------");

	}

	public static void main(String[] args) {

		int[][] a = { { 1, 2, 3,4 }, { 5, 6,7,8 }, { 9,10,11,12 }, {13,14,15,16}};
		print(a);

		rotate90ClockWise(a);

		print(a);

	}

}
