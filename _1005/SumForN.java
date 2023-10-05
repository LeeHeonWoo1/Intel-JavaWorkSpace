package _1005;

import java.util.Scanner;

public class SumForN {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);

        System.out.print("계산할 범위 n : ");
        int n = intScanner.nextInt();
        int sum = 0;

        for (int j = 1; j <= n; j++)
            sum += j;

        System.out.println(sum);
    }
}
