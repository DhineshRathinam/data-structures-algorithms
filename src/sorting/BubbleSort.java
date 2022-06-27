package sorting;

import java.util.Arrays;

public class BubbleSort {

	private void bubbleSort(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
			size--;
		}
	}

	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		int arr[] = { 5, 2, 2, 7, 1, 3, 8, 4, 6 };
		sort.bubbleSort(arr);
		Arrays.stream(arr).forEach(p -> System.out.print(p + " -> "));
	}
}
