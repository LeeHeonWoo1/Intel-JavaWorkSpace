package GridGame;

import java.util.Scanner;

public class Hero {
    public static void main(String[] args) {
        SetEnvironment field = new SetEnvironment();
        Scanner intScanner = new Scanner(System.in);
        SituationHandler sit = new SituationHandler();

        System.out.print("설정할 함정의 개수를 입력하세요 : ");
        int trapCnt = intScanner.nextInt();

        System.out.print("배치할 몬스터의 수를 입력하세요 : ");
        int monCnt = intScanner.nextInt();

        field.setFeild();
        field.setLocation();
        field.setTrap(trapCnt);
        field.setEscape();
        field.setBossLocation(monCnt);
        field.getFeild();

        int exp = 0;
        while (field.getUserHp() != 0){
            System.out.print("1. 12시 이동\n2. 3시 이동\n3. 6시 이동\n4. 9시 이동\n>>>  ");
            int sight = intScanner.nextInt(); // 1 : 12시, 2 : 3시, 3 : 6시, 4 : 9시
            switch (sight){
                case 1:
                    System.out.print("이동 방향 12시, 움직일 칸 수를 입력하세요 : ");
                    int yPoint = intScanner.nextInt();
                    sit.isEscape(yPoint, sight);
                    sit.isTrapped(yPoint, sight);
                    field.moveY(yPoint, sight);
                    exp += 10;
                    field.getFeild();
                    break;

                case 2:
                    System.out.print("이동 방향 3시, 움직일 칸 수를 입력하세요 : ");
                    int xPoint = intScanner.nextInt();
                    sit.isEscape(xPoint, sight);
                    sit.isTrapped(xPoint, sight);
                    field.moveX(xPoint, sight);
                    exp += 10;
                    field.getFeild();
                    break;

                case 3:
                    System.out.print("이동 방향 6시, 움직일 칸 수를 입력하세요 : ");
                    int yPoint2 = intScanner.nextInt();
                    sit.isEscape(yPoint2, sight);
                    sit.isTrapped(yPoint2, sight);
                    field.moveY(yPoint2, sight);
                    exp += 10;
                    field.getFeild();
                    break;

                case 4:
                    System.out.print("이동 방향 9시, 움직일 칸 수를 입력하세요 : ");
                    int xPoint2 = intScanner.nextInt();
                    sit.isEscape(xPoint2, sight);
                    sit.isTrapped(xPoint2, sight);
                    field.moveX(xPoint2, sight);
                    exp += 10;
                    field.getFeild();
                    break;
            }
        }
    }
}
