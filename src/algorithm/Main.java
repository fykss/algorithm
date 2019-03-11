package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println(reverse("-23213423141314"));
        System.out.println(Long.MAX_VALUE);
    }


    private static long reverse(String x) {


        long res = 0;
        res = Long.parseLong(x);
        if (res < 0) {
            long a = Long.parseLong(reverseStr(x));
            a *= (-1);
            return a * (-1);
        } else return Long.parseLong(reverseStr(x));
    }

    private static String reverseStr(String n) {
        StringBuilder res = new StringBuilder();
        for (int i = n.length() - 1; i >= 0; i--) {
            res.append(n.charAt(i));
        }
        return res.toString();
    }
}
