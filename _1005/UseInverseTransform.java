package _1005;

import java.util.Scanner;

public class UseInverseTransform {
    public static void main(String[] args) {
        Scanner strScanner = new Scanner(System.in);
        Transformer trans = new Transformer();

        System.out.print("변환할 진법을 선택하세요 : ");
        String formation = strScanner.nextLine();

        switch (formation){
            case "2진수 역변환":
                System.out.print("변환할 2진수를 입력하세요 : ");
                String userInput = strScanner.nextLine();
                trans.inverseTransform(2, userInput);
                break;

            case "8진수 역변환":
                System.out.print("변환할 숫자를 입력하세요 : ");
                String userInput3 = strScanner.nextLine();
                trans.inverseTransform(8, userInput3);

                break;

            case "16진수 역변환":
                System.out.print("변환할 숫자를 입력하세요 : ");
                String userInput2 = strScanner.nextLine();
                trans.inverseTransform(16, userInput2);

                break;
        }
    }
}
