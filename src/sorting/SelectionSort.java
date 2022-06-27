package sorting;

import java.util.Arrays;

//O(n2)
public class SelectionSort {

	private void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int smallestIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[smallestIndex]) {// In place sort
					smallestIndex = j;
				}
			}
			swap(arr, i, smallestIndex);
		}
	}

	private void swap(int[] arr, int i, int smallestIndex) {
		int temp = arr[i];
		arr[i] = arr[smallestIndex];
		arr[smallestIndex] = temp;
	}

	public static void main(String[] args) {
		SelectionSort sort = new SelectionSort();
		int arr[] = { 5, 2, 2, 7, 1, 3, 8, 4, 6 };
		sort.selectionSort(arr);
		Arrays.stream(arr).forEach(p -> System.out.print(p + " -> "));
	}

}
