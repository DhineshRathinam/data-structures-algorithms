package trees;

/**
 * 1. Construct the segment tree 2. Search or query the given range to get the
 * value 3. Update
 *
 */
public class SegmentTree {

	int[] arr = { 5, 7, 11, 3, 2 };
	int[] seg = new int[2 * arr.length];

	public int build(int pos, int low, int high, int[] arr, int index) {

		if (low == high) {
			return seg[pos] = arr[low];
		}

		int mid = (low + high) / 2;
		int left = build(2 * pos + 1, low, mid, arr, low);
		int right = build(2 * pos + 2, mid + 1, high, arr, low);
		return seg[pos] = Math.min(left, right);
	}

	private int query(int ql, int qh, int low, int high, int pos) {

		if (ql <= low && qh >= high) {
			return seg[pos];
		}

		if (ql > high || qh < low) {
			return Integer.MAX_VALUE;
		}
		int mid = (low + high) / 2;
		int left = query(ql, qh, low, mid, 2 * pos + 1);
		int right = query(ql, qh, mid + 1, high, 2 * pos + 2);

		return Math.min(left, right);

	}

	private void update(int valToUpdate, int low, int high, int pos, int indexToUpdate, int diff) {

		if (low == indexToUpdate && high == indexToUpdate) {
			seg[pos] = valToUpdate;
		}
		if (low <= indexToUpdate && high >= indexToUpdate) {
			int mid = (low + high) / 2;
			update(valToUpdate, low, mid, 2 * pos + 1, indexToUpdate, diff);
			update(valToUpdate, mid + 1, high, 2 * pos + 2, indexToUpdate, diff);
		}
	}

	public static void main(String[] args) {
		SegmentTree segmentTree = new SegmentTree();
		segmentTree.build(0, 0, segmentTree.arr.length - 1, segmentTree.arr, 0);
		for (int i = 0; i < segmentTree.seg.length; i++) {
			System.out.println(segmentTree.seg[i]);

		}

		int a = segmentTree.query(1, 3, 0, segmentTree.arr.length - 1, 0);
		System.out.println("The minimum value in the given range: " + a);

		int valToUpdate = 9;
		int diff = segmentTree.arr[2] - valToUpdate;
		segmentTree.arr[2] = valToUpdate;
		segmentTree.update(9, 0, segmentTree.arr.length - 1, 0, 2, diff);

		for (int i = 0; i < segmentTree.seg.length; i++) {
			System.out.println(segmentTree.seg[i]);

		}
	}
}
