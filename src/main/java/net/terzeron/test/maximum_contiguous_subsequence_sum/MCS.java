package net.terzeron.test.maximum_contiguous_subsequence_sum;

/**
 * Linear maximum contiguous subsequence sum algorithm.
 * seqStart and seqEnd represent the actual best sequence.
 */

public class MCS {
	public static void main(String args[]) {
		int a[] = {-2, 11, -4, 13, -5, 2};

		System.out.println("Maximum sum:"+maximumSubsequenceSum(a));
	}

	static int maximumSubsequenceSum(int [] a)
	{
		int maxSum = 0;
		int thisSum = 0;
		int seqStart, seqEnd;

		for (int i = 0, j = 0;  j < a.length; j++) {
			thisSum += a[j];
			if (thisSum > maxSum) {
				maxSum = thisSum;
				seqStart = i;
				seqEnd = j;
			} else if (thisSum < 0) {
				i = j + 1;
				thisSum = 0;
			}
		}

		return maxSum;
	}
}


