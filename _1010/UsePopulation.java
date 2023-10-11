package _1010;

import java.util.Scanner;

public class UsePopulation {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        Population p = new Population();

        String filepath = "C:/Users/OWNER/Desktop/population2.txt";
        p.setData(filepath);
        boolean flag = true;

        System.out.println("금정구 전체의 데이터를 다룹니다. 실행할 메뉴의 번호를 입력하세요.");
        while(flag){
            System.out.print("1. 전체 출력\n2. 동간 최대최소 출력\n3. 동내 최대최소 출력\n4. 종료\n\n>> ");

            int menuNum = intScanner.nextInt();
            switch (menuNum){
                case 1:
                    p.getData();
                    break;
                case 2:
                    p.getMinMax();
                    break;
                case 3:
                    p.getMinMaxIn();
                    break;
                case 4:
                    flag = false;
                    break;

            }
        }


    // 행정
    }
}
