package sorting;

public class QuickSort {

	private void quickSort(int[] arr, int low, int high) {
		if (low > high) {
			return;
		}
		int mid = (low + high) / 2;
		int pivot = arr[mid];
		int start = low;
		int end = high;
		//int pivotIndex = mid;
		while (start <= end) {// why we need to check for equals??????
			while (arr[start] < pivot) {
				start++;
			}

			while (arr[end] > pivot) {
				end--;
			}
			if (start <= end) {
				swap(arr, start, end);
					start++;
					end--;
			}
		}
		quickSort(arr, low, end);
		quickSort(arr, start, high);
	}

	private static void swap(int[] arr, int s, int e) {
		int temp = arr[s];
		arr[s] = arr[e];
		arr[e] = temp;
	}

	public static void main(String[] args) {
		/* int[] a = { 5, 8, 4, 3, 7, 6, 2, 9, 5 }; */
		int[] a = { 9, 7, 9, 1, 5, 6, 5, 9, 4, 8 };
		QuickSort sort = new QuickSort();
		sort.quickSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
