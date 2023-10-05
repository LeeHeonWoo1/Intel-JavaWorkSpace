package _1005;

import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        int[] num = new int[5];

        Scanner intScanner = new Scanner(System.in);

        for (int i = 0; i < num.length; i++) {
            num[i] = intScanner.nextInt();
        }

        int max = num[0], min = num[0];
        for (int i = 1; i < num.length; i++) {
            if (max < num[i])
                max = num[i];
            if (min > num[i])
                min = num[i];
        }

        System.out.println(max);
        System.out.println(min);
    }
}
