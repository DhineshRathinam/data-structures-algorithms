package sorting;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

	private void radixSort(int[] arr) {
		List<Integer> buckets[] = new ArrayList[10];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < arr.length; i++) {
			int lsb = arr[i] % 10;
			//buckets[lsb] = arr[i];
		}

	}

	public static void main(String[] args) {
		RadixSort sort = new RadixSort();
		int arr[] = { 5, 2, 7, 1, 3, 8, 4 };
		sort.radixSort(arr);
	}

}
