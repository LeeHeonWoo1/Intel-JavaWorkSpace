package _0918;

import _0918.MatrixMachine;

import java.util.Scanner;

public class UseMatrixMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        System.out.print("1. 행렬합 계산\n2. 행렬 x 정수\n3. 행렬 x 행렬\n4. 전치행렬 구하기\n\n실행할 메뉴를 입력하세요 : ");
        int menuNum = intScanner.nextInt();

        switch (menuNum) {
            case 1:
                System.out.print("행렬합 수행 행렬 1 : ");
                String arr1 = scanner.nextLine();
                System.out.print("행렬합 수행 행렬 2 : ");
                String arr2 = scanner.nextLine();

                MatrixMachine test = new MatrixMachine(arr1);
                MatrixMachine test2 = new MatrixMachine(arr2);

                MatrixMachine sumResult = new MatrixMachine(test2.addMatrix(test));
                sumResult.showMatrix();
                break;

            case 2:
                System.out.print("행렬곱을 수행할 정수를 입력하세요 : ");
                int mulInt = intScanner.nextInt();

                System.out.print("행렬을 입력하세요 : ");
                String strArr = scanner.nextLine();

                MatrixMachine test4 = new MatrixMachine(strArr);
                MatrixMachine mulResult = new MatrixMachine(test4.mulMatrix(mulInt));
                mulResult.showMatrix();
                break;

            case 3:
                System.out.print("행렬곱을 수행할 행렬을 입력하세요 : ");
                String strArr1 = scanner.nextLine();

                System.out.print("행렬곱을 수행할 다른 행렬을 입력하세요 : ");
                String strArr2 = scanner.nextLine();

                MatrixMachine test5 = new MatrixMachine(strArr1);
                MatrixMachine test6 = new MatrixMachine(strArr2);

                MatrixMachine mulResult2 = new MatrixMachine(test5.mulMatrix1(test6));
                mulResult2.showMatrix();
                break;

            case 4:
                System.out.print("행렬을 입력하세요 : ");
                String strArr3 = scanner.nextLine();

                MatrixMachine test7 = new MatrixMachine(strArr3);
                MatrixMachine tResult = new MatrixMachine(test7.T());
                tResult.showMatrix();
                tResult.showIdenMat();
                break;
        }


    }
}