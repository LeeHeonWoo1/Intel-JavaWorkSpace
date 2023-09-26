package GridGame;

import java.util.Scanner;

public class Hero {
    public static void main(String[] args) {
        SetEnvironment field = new SetEnvironment();
        Scanner intScanner = new Scanner(System.in);
        SituationHandler sit = new SituationHandler();
        Gun gun = new Gun();
        Staff staff = new Staff();

        System.out.print("설정할 함정의 개수를 입력하세요 : ");
        int trapCnt = intScanner.nextInt();

        System.out.print("배치할 몬스터의 수를 입력하세요 : ");
        int monCnt = intScanner.nextInt();

        sit.setFeild();
        sit.setLocation();
        sit.setTrap(trapCnt);
        sit.setEscape();
        sit.setBossLocation(monCnt);

        boolean flag = true;

        while (flag){
//            sit.getFeild();
            if (FieldOfGame.userHp <= 0){
                System.out.println("hp가 모두 소진되었습니다. 게임을 종료합니다.");
                flag = false;
            }

            sit.getStation(); 
            System.out.print("1. 12시 이동\n2. 3시 이동\n3. 6시 이동\n4. 9시 이동\n5. 맵 확인하기(포인트 차감)\n6. 숙련도 레벨 증가\n>>>  ");
            int sight = intScanner.nextInt(); // 1 : 12시, 2 : 3시, 3 : 6시, 4 : 9시
            switch (sight){
                case 1:
                    System.out.print("이동 방향 12시, 움직일 칸 수를 입력하세요 : ");
                    int yPoint = intScanner.nextInt();
                    flag = sit.isEscape(yPoint, sight);
                    sit.isTrapped(yPoint, sight);
                    sit.isEncounter(yPoint, sight);
                    field.moveY(yPoint, sight);
                    break;

                case 2:
                    System.out.print("이동 방향 3시, 움직일 칸 수를 입력하세요 : ");
                    int xPoint = intScanner.nextInt();
                    flag = sit.isEscape(xPoint, sight);
                    sit.isTrapped(xPoint, sight);
                    sit.isEncounter(xPoint, sight);
                    field.moveX(xPoint, sight);
                    break;

                case 3:
                    System.out.print("이동 방향 6시, 움직일 칸 수를 입력하세요 : ");
                    int yPoint2 = intScanner.nextInt();
                    flag = sit.isEscape(yPoint2, sight);
                    sit.isTrapped(yPoint2, sight);
                    sit.isEncounter(yPoint2, sight);
                    field.moveY(yPoint2, sight);
                    break;

                case 4:
                    System.out.print("이동 방향 9시, 움직일 칸 수를 입력하세요 : ");
                    int xPoint2 = intScanner.nextInt();
                    flag = sit.isEscape(xPoint2, sight);
                    sit.isTrapped(xPoint2, sight);
                    sit.isEncounter(xPoint2, sight);
                    field.moveX(xPoint2, sight);
                    break;

                case 5:
                    System.out.print("현재 포인트는 " + FieldOfGame.point + "점 입니다. ");
                    if (FieldOfGame.point > 20){
                        System.out.println("20점을 차감하여 맵을 확인합니다.");
                        sit.getFeild();
                    }else{
                        System.out.println("포인트가 부족하여 맵을 확인할 수 없습니다. 포인트를 더 모아주세요.");
                    }
                    break;

                case 6:
                    System.out.print("숙련도를 올릴 무기를 선택하세요\n1. 스태프\n2. 핸드건/샷건/라이플\n>> ");
                    int weaponNum = intScanner.nextInt();

                    switch(weaponNum){
                        case 1:
                            staff.levelUp();
                            break;
                        case 2:
                            gun.levelUp();
                            break;
                    }
                    break;
            }
        }
    }
}
