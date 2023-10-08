package quiz;

import java.util.Scanner;

public class _0915Quiz {
    public static void main(String[] args) {
        // 별표 그리는 문제
        int spaceCnt = 0;
        for (int i = 10; i >= 4; i--) {
            if (i % 2 == 0){
                System.out.println(" ".repeat(spaceCnt++) + "*".repeat(i));
            }
        }

        for (int i = 4; i <= 10; i++) {
            if (i % 2 == 0){
                System.out.println(" ".repeat(--spaceCnt) + "*".repeat(i));
            }
        }

        // 구구단
        Scanner scanner = new Scanner(System.in);
        System.out.print("몇 단? : ");
        int danNum = scanner.nextInt();

        for (int i = 1; i < 10; i++) {
            System.out.println(danNum + "*" + i + "=" + danNum*i);
        }

        // 일차방정식의 해
        // 중첩 for 문을 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x,y) 형태로 출력하는 코드를 작성하시오. 단, x와 y는 10이하의 자연수이다

        int x = 4;
        int y = 5;

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if ((x * i) + (y * j) == 60){
                    System.out.printf("(%d, %d)" + "\n", i, j);
                }
            }
        }

        // Array 복사 후 정렬
        int[] array = {1, 5, 3, 8, 2};
        int[] resultArray = new int[array.length];

        System.arraycopy(array, 0, resultArray, 0, array.length);

        int temp;
        for (int i = 0; i < resultArray.length - 1; i++) {
            for (int j = i+1; j < resultArray.length; j++) {
                if (resultArray[i] > resultArray[j]){
                    temp = resultArray[i];
                    resultArray[i] = resultArray[j];
                    resultArray[j] = temp;
                }
            }
        }

        for (int i : resultArray){
            System.out.println(i);
        }

        scanner.close();
    }
}
