package medianTwoStorted;

import java.util.Arrays;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 */

public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		if ((m + n) % 2 != 0)
			return findKth(A, m, B, n, (m + n) / 2 + 1);
		else
			return (findKth(A, m, B, n, (m + n) / 2) + findKth(A, m, B, n,
					(m + n) / 2 + 1)) / 2.0;
	}

	public double findKth(int A[], int m, int B[], int n, int k) {
		if (m > n)
			return findKth(B, n, A, m, k);
		if (m == 0)
			return B[k - 1];
		if (k == 1)
			return Math.min(A[0], B[0]);
		if (k == m + n)
			return Math.max(A[m - 1], B[n - 1]);

		int pa = Math.min(k / 2, m);
		int pb = k - pa - 1;
		int Apa_1 = (pa == 0) ? Integer.MIN_VALUE : A[pa - 1];
		int Bpb_1 = (pb == 0) ? Integer.MIN_VALUE : B[pb - 1];
		int Apa = (pa == m) ? Integer.MAX_VALUE : A[pa];
		int Bpb = (pb == n) ? Integer.MAX_VALUE : B[pb];

		if (Bpb_1 < Apa && Apa < Bpb)
			return Apa;
		else if (Apa_1 < Bpb && Bpb < Apa)
			return Bpb;

		if (Apa < Bpb) {
			return findKth(Arrays.copyOfRange(A, pa + 1, A.length), m - pa - 1,
					Arrays.copyOfRange(B, 0, pb), pb, k - pa - 1);
		} else if (Apa > Bpb) {
			return findKth(Arrays.copyOfRange(A, 0, pa), pa,
					Arrays.copyOfRange(B, pb + 1, B.length), n - pb - 1, k - pb
							- 1);
		} else {
			return Apa;
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 2 };
		int[] B = { 1, 2 };
		Solution slt = new Solution();
		double result = slt.findMedianSortedArrays(A, B);
		System.out.println(result);
	}
}
