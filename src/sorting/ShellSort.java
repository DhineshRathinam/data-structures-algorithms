package sorting;

import java.util.Arrays;

public class ShellSort {

	private void shellSort(int[] arr, int size) {
		int gap = size / 2;
		for (int j = 0; j < arr.length; j++) {
			for (int i = gap; i < arr.length; i++) {
				if (arr[i] < arr[i - gap]) {
					swap(arr, i, gap);
				}
			}
			gap = gap / 2;
		}
	}

	private void swap(int[] arr, int i, int gap) {
		int temp = arr[i];
		arr[i] = arr[i - gap];
		arr[i - gap] = temp;
	}

	public static void main(String[] args) {
		ShellSort sort = new ShellSort();
		int arr[] = { 5, 2, 4, 7, 1, 3, 8, 4, 6 };
		sort.shellSort(arr, arr.length);

		Arrays.stream(arr).forEach(p -> System.out.print(p + " -> "));
	}
}
