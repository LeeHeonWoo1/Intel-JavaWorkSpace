package quiz;

import java.io.*;
import java.util.Scanner;

public class ReadPersonInfo {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        HandlePersonInfo hpi = new HandlePersonInfo();

        boolean flag = true;

        while(flag){
            System.out.println("--------------실행화면--------------");
            System.out.print("1. 입력\n2. 전체출력\n3. 검색\n4. 삭제\n5. 수정\n6. 종료\n\n실행할 메뉴의 번호를 입력하세요 >> ");
            int menu = intScanner.nextInt();
            switch (menu){
                case 1:
                    System.out.print("등록할 사람의 수를 입력하세요 : ");
                    int personCnt = intScanner.nextInt();
                    hpi.writeData(personCnt);

                    break;

                case 2:
                    hpi.readAllData();
                    break;

                case 3:
                    System.out.print("조회할 인원의 이름을 입력하세요 : ");
                    String name = strScanner.nextLine();
                    hpi.searchData(name);

                    break;

                case 4:
                    System.out.print("삭제하려는 인원의 이름을 입력하세요 : ");
                    String key = strScanner.nextLine();
                    hpi.delData(key);

                    break;

                case 5:
                    hpi.modData();
                    break;

                case 6:
                    flag = false;
                    break;

            }
        }
    }
}
