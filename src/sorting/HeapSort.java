package sorting;

import java.util.Arrays;

public class HeapSort {

	private void heapSort(int[] arr, int size) {
		for (int i = (size / 2) - 1; i >= 0; i--) {
			heapify(arr, i, size);
		}
		System.out.println("After build heap:");
		Arrays.stream(arr).forEach(p -> System.out.print(p + " -> "));
		System.out.print("End");
		for (int i = size - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, 0, i);
		}

	}

	private void heapify(int[] arr, int index, int size) {
		int largest = index;
		int leftChildIndex = (2 * index) + 1;
		int rightChildIndex = (2 * index) + 2;

		if (size > leftChildIndex && arr[largest] < arr[leftChildIndex]) {
			largest = leftChildIndex;
		}

		if (size > rightChildIndex && arr[largest] < arr[rightChildIndex]) {
			largest = rightChildIndex;
		}

		if (index != largest) {
			int temp = arr[index];
			arr[index] = arr[largest];
			arr[largest] = temp;

			heapify(arr, largest, size);
		}
	}

	public static void main(String[] args) {
		HeapSort sort = new HeapSort();
		 int arr[] = { 5, 2, 7, 1, 3, 8, 4 };
		//int arr[] = { 16, 7, 22, 3, 19, 9, 33 };
		sort.heapSort(arr, arr.length);
		System.out.println("");
		System.out.println("After sorting: ");
		Arrays.stream(arr).forEach(p -> System.out.print(p + " -> "));
	}

}
