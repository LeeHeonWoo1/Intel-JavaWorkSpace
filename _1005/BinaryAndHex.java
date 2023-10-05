package _1005;

import java.util.Scanner;

public class BinaryAndHex {
    public static void main(String[] args) {
        Scanner strScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        Transformer trans = new Transformer();

        System.out.print("변환할 진법을 선택하세요 : ");
        String formation = strScanner.nextLine();

        switch (formation){
            case "2진수":
                System.out.print("변환할 숫자를 입력하세요 : ");
                int userInput = intScanner.nextInt();
                trans.transform(2, userInput);
                break;

            case "8진수":
                System.out.print("변환할 숫자를 입력하세요 : ");
                int userInput3 = intScanner.nextInt();
                trans.transform(8, userInput3);

                break;

            case "16진수":
                System.out.print("변환할 숫자를 입력하세요 : ");
                int userInput2 = intScanner.nextInt();
                String result2 = "";

                while (userInput2 >= 1){
                    int remain = userInput2 % 16;

                    if (remain >= 10)
                        result2 += (char)(remain + 55);
                    else
                        result2 += remain;

                    userInput2 /= 16;
                }

                char[] arr2 = result2.toCharArray();
                for (int i = arr2.length - 1; i >=0  ; i--)
                    System.out.print(arr2[i]);

                break;
        }

    }
}
