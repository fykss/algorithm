package problems.prime_number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Range integer from 0 to n. Enter n: ");
        int n = s.nextInt();
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if ((i % j) == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) result.add(i);
        }
        System.out.println(result);
    }
}
