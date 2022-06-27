package sorting;

import java.util.Arrays;

public class InsertionSort {

	private void insertionSort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j - 1] > arr[j]) {
					swap(arr, j);
				} else {
					break;
				}
			}
		}
	}

	private void swap(int[] arr, int j) {
		int temp = arr[j - 1];
		arr[j - 1] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		InsertionSort sort = new InsertionSort();
		int arr[] = { 5, 2, 4, 7, 1, 3, 8, 4, 6 };
		sort.insertionSort(arr);
		Arrays.stream(arr).forEach(p -> System.out.print(p + " -> "));
	}

}
