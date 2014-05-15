package charnetskaya.maxsum;

import java.util.Scanner;

public class MaxSum {

	private final int[][] array;

	public MaxSum(int[][] array) {
		this.array = array;
	}

	public int returnMaxSubArray() {
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				for (int m = i; m < array.length; m++) {
					for (int n = j; n < array[0].length; n++) {
						int temp = 0;

						for (int p = i; p <= m; p++) {
							for (int q = j; q <= n; q++) {
								temp += array[p][q];
							}
						}

						if (temp > sum) {
							sum = temp;
						}
					}
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {

		System.out.println("Enter numbers");
		Scanner in = new Scanner(System.in);
		int arraySize = in.nextInt();
		int[][] array = new int[arraySize][arraySize];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = in.nextInt();
			}
		}
		MaxSum subArray = new MaxSum(array);
		System.out.println(subArray.returnMaxSubArray());

	}
}
