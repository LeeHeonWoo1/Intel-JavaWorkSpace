package _0915;

import java.util.Scanner;

class QuizToFunctions {
    // 행렬의 각 원소가 1자리수인 행렬을 입력받아 행렬합 계산하기
    public static void main(String[] args) {
        String[] userInput = getInputData();
        String intStr1 = userInput[0].replaceAll("[^0-9]", ""); // 정규식
        String intStr2 = userInput[1].replaceAll("[^0-9]", ""); // 정규식

        int[] rowAndColumn = getRowColCnt();
        int[][] intArray1 = new int[rowAndColumn[0]][rowAndColumn[1]];
        int[][] intArray2 = new int[rowAndColumn[0]][rowAndColumn[1]];

        int increase1 = 0;
        System.out.println("===================================");
        for (int i = 0; i < intArray1.length; i++) { // 배열의 길이만큼 순회하면서
            for (int j = 0; j < intArray1[i].length; j++) {
                intArray1[i][j] = Integer.parseInt(intStr1.substring(j+increase1, j+increase1+1));
                System.out.print(intArray1[i][j] + "\t");
            }
            increase1 += rowAndColumn[1];
            System.out.println();
        }
        System.out.println("===================================");
        int increase2 = 0;
        for (int i = 0; i < intArray2.length; i++) { // 배열의 길이만큼 순회하면서
            for (int j = 0; j < intArray2[i].length; j++) {
                intArray2[i][j] = Integer.parseInt(intStr2.substring(j+increase2, j+increase2+1));
                System.out.print(intArray2[i][j] + "\t");
            }
            increase2 += rowAndColumn[1];
            System.out.println();
        }
        System.out.println("===================================");
        System.out.println("위 두 행렬을 기반으로 행렬합을 연산한 결과는");
        System.out.println("===================================");
        for (int i = 0; i < intArray2.length; i++) { // 배열의 길이만큼 순회하면서
            for (int j = 0; j < intArray2[i].length; j++) {
                System.out.print((intArray1[i][j]+intArray2[i][j]) + "\t");
            }
            increase2 += rowAndColumn[1];
            System.out.println();
        }
        System.out.println("입니다.");
    }

    static String[] getInputData(){
        Scanner array1String = new Scanner(System.in);
        Scanner array2String = new Scanner(System.in);

        System.out.println("연산을 수행할 한 행렬을 입력하세요 : ");
        String onlyInt1 = array1String.nextLine();

        System.out.println("연산을 수행할 나머지 행렬을 입력하세요 : ");
        String onlyInt2 = array2String.nextLine();
        return new String[] {onlyInt1, onlyInt2};
    }

    static int[] getRowColCnt(){
        Scanner rowCnt = new Scanner(System.in);
        Scanner colCnt = new Scanner(System.in);

        System.out.println("행의 개수를 입력하세요 : ");
        int rows = rowCnt.nextInt();

        System.out.println("열의 개수를 입력하세요 : ");
        int cols = colCnt.nextInt();

        return new int[] {rows, cols};
    }


}
// {{3, 2, 8}, {2, 4, 7}}
// {{4, 1, 0}, {6, 9, 2}}