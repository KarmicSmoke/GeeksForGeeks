package dp;

public class LargestSumContiguousSubArray {

    public static void main(String[] args) {

        int[] array = {1, 2, 3};
        System.out.println(kadaneAlgo(array));
        System.out.println(kadaneAlgoOptimized(array));
    }

    private static int kadaneAlgo(int[] array) {

        int[] maxSum = new int[array.length];
        maxSum[0] = Math.max(0, array[0]);

        for (int i = 1; i < array.length; ++i)
            maxSum[i] = Math.max(array[i], maxSum[i - 1] + array[i]);


        int ans = array[0];
        for (int i = 1; i < array.length; ++i)
            ans = Math.max(ans, maxSum[i]);
        return ans;

    }

    private static int kadaneAlgoOptimized(int[] array) {

        int maxSum = Math.max(0, array[0]); // If maxSum needed is always non-negative , take maxSum = 0
        int lastMaxSum = 0;

        for (int i = 1; i < array.length; ++i) {
            lastMaxSum = Math.max(array[i], lastMaxSum + array[i]);
            maxSum = Math.max(maxSum, lastMaxSum);
        }

        return maxSum;

    }

}


