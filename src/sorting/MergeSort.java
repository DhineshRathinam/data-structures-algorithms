package sorting;

import java.util.Arrays;

public class MergeSort {

	private int[] mergeSort(int[] arr) {
		if (arr.length == 1) {
			return arr;
		}
		int mid = (arr.length) / 2;

		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

		return merge(left, right);
	}

	private int[] merge(int[] left, int[] right) {
		int[] joined = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				joined[k] = left[i];
				i++;
				k++;
			} else if (left[i] > right[j]) {
				joined[k] = right[j];
				j++;
				k++;
			}
		}

		while (i < left.length) {
			joined[k] = left[i];
			k++;
			i++;
		}
		while (j < right.length) {
			joined[k] = right[j];
			k++;
			j++;
		}
		return joined;
	}

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		//int arr[] = { 5, 2, 7, 1, 3, 8, 4 };
		int arr1[] = { 500, 245, 77, 100, 30, 85, 245, 49, 101 };
		//int arr2[] = { 500, 245, 77, 245 };
		int[] joined = sort.mergeSort(arr1);
		Arrays.stream(joined).forEach(p -> System.out.print(p + " -> "));
	}

}
