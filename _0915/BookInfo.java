package _0915;

import java.util.Scanner;

// 클래스 사용해보기
public class BookInfo {
    String bookName;
    String author;
    int price;

// 메소드 사용해보기
    public static void main(String[] args) {
        System.out.print("1. 팩토리얼 계산\n" +
                "2. 사각형 넓이 계산\n" +
                "3. 삼각형 넓이 계산\n" +
                "4. 최대공약수 계산\n" +
                "5. 최소공배수 계산\n" +
                "6. 최대-최소값 계산하기\n\n" +
                "실행할 메뉴의 번호를 입력하세요 : ");

        Operation oper = new Operation();

        Scanner menu = new Scanner(System.in);
        int num = menu.nextInt();

        Scanner scan = new Scanner(System.in);
        switch (num){
            case 1 :
                System.out.print("팩토리얼을 계산할 정수를 입력하세요 : ");
                int x = scan.nextInt();
                System.out.printf("%d 을 계산한 결과는 %d입니다.", x, oper.factorial(x));
                break;

            case 2 :
                System.out.print("사각형의 가로 길이 : ");
                System.out.print("사각형의 세로 길이 : ");
                int width1 = scan.nextInt();
                int height1 = scan.nextInt();

                System.out.printf("사각형의 넓이를 계산한 결과는 %d입니다.", oper.getArea(width1, height1));
                break;

            case 3 :
                System.out.print("삼각형의 밑변 길이 : ");
                System.out.print("삼각형의 높이 길이 : ");

                int twidth1 = scan.nextInt();
                int theight1 = scan.nextInt();

                System.out.printf("삼각형의 넓이를 계산한 결과는 %d입니다.", oper.getArea(twidth1, theight1));
                break;

            case 4 :
                System.out.print("구하려는 수 1 : ");
                int x2 = scan.nextInt();

                System.out.print("구하려는 수 2 : ");
                int y2 = scan.nextInt();

                System.out.printf("최대공약수를 계산한 결과는 %d입니다.", oper.gcd(x2, y2));
                break;

            case 5 :
                System.out.print("구하려는 수 1 : ");
                int x3 = scan.nextInt();

                System.out.print("구하려는 수 2 : ");
                int y3 = scan.nextInt();

                System.out.printf("최소공배수를 계산한 결과는 %d입니다.", oper.lcm(x3, y3));
                break;

            case 6 :
                Scanner strArray = new Scanner(System.in);
                System.out.print("숫자들을 쉼표를 기준으로 입력하세요 : ");
                String userInput = strArray.nextLine();

                int[] result = oper.minMax(userInput);
                System.out.printf("최대값은 %d, 최소값은 %d입니다.", result[1], result[0]);
                break;
        }




    }
}
