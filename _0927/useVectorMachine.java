package _0927;

import java.util.Scanner;

public class useVectorMachine {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("벡터1 입력 : ");
        String str = scan.nextLine();
        VectorMachine vm1 = new VectorMachine(str);
        VectorMachine t = vm1.getFirstTrans("origin");
        t.showVector();

    }
}
