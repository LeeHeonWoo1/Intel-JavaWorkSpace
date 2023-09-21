package _0918;

import java.util.Scanner;

public class useParamClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("배열을 ,를 기준으로 작성하세요 : ");
        String userInput = scan.nextLine();

        UseParameterVer useparam = new UseParameterVer(userInput);
        useparam.printArray();
        System.out.println(useparam.sum(1, 2, 3.2, 4, 5));
    }
}
