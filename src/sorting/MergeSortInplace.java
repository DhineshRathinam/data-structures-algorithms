package sorting;

import java.util.Arrays;

public class MergeSortInplace {
	private void mergeSortInPlace(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		mergeSortInPlace(arr, low, mid);
		mergeSortInPlace(arr, mid + 1, high);

		mergeInPlace(arr, low, mid, high);
	}

	private void mergeInPlace(int[] arr, int low, int mid, int high) {// [5,4,1,7], 0, 0, 1

		int[] joined = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				joined[k] = arr[i];
				k++;
				i++;
			} else if (arr[i] > arr[j]) {
				joined[k] = arr[j];
				k++;
				j++;
			}
		}

		while (i <= mid) {
			joined[k] = arr[i];
			k++;
			i++;
		}

		while (j <= high) {
			joined[k] = arr[j];
			k++;
			j++;
		}

		for (int l = 0; l < joined.length; l++) {
			arr[l + low] = joined[l];
		}

	}

	public static void main(String[] args) {
		MergeSortInplace sortInplace = new MergeSortInplace();
		int arr[] = { 5, 4, 1, 7, 5 };
		sortInplace.mergeSortInPlace(arr, 0, arr.length - 1);
		Arrays.stream(arr).forEach(p -> System.out.print(p + " -> "));
	}
}
