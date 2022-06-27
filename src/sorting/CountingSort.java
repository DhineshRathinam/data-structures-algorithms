package sorting;

import java.util.Arrays;

public class CountingSort {
	private int[] countingSort(int[] arr) {

		int min = Arrays.stream(arr).min().getAsInt();
		int max = Arrays.stream(arr).max().getAsInt();

		int[] count = new int[max - min + 1];

		int[] output = new int[arr.length];

		for (int i : arr) {
			count[i - min] = count[i - min] + 1;
		}

		for (int j = 1; j < count.length; j++) {
			count[j] = count[j - 1] + count[j];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			
			output[count[arr[i] - min] - 1] = arr[i];
			count[arr[i] - min]--;
		}
		return output;
	}

	public static void main(String[] args) {
		CountingSort sort = new CountingSort();
		int arr[] = { 15, 25, 47, 70, 99, 32, 80, 49, 69 };
		int[] output = sort.countingSort(arr);
		Arrays.stream(output).forEach(p -> System.out.print(p + " -> "));
		System.out.println("Sorted:");
	}

}
