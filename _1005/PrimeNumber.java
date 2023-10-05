package _1005;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);

        System.out.print("N 이하의 소수 출력 : ");
        int n = intScanner.nextInt();
        for (int i = 2; i <= n; i++) { // n이하의 수들을 탐색하면서
            int cnt = 0;
            for (int j = 1; j <= i; j++) { // 그 수보다 작은 수들에 대해
                if(i%j == 0) // 나눠떨어지는 경우에는
                    cnt += 1; // cnt를 1 증가시킨다
            }

            if (cnt == 2) // cnt는 지금 약수의 개수를 의미하는 변수이기 때문에, 그 수가 2라면
                System.out.println(i); // i를 출력한다.
        }
    }
}
