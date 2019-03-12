package problems.max_pairwise_product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
  Find the maximum product of two distinct numbers in a sequence of non-negative integers.
  Problems: Enter count number -> find two max number in array -> multiply this two number
  Example: enter number 3 -> array consist 3 value, arr = {1, 2, 3} -> result 3
 */

public class MaxPairwiseProduct {
    public static void main(String[] args) {
        FastScanner s = new FastScanner(System.in);
        int n = s.nextInt();
        long[] num = new long[n];

        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(s.next());
        }

        System.out.println(multiplyMaxDigits(num));
    }

    private static long multiplyMaxDigits(long[] num) {
        Arrays.sort(num);
        int len = num.length;
        return num[len - 1] * num[len - 2];
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            } }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                } }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
