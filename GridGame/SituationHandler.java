package GridGame;

import java.util.Random;
import java.util.Scanner;

public class SituationHandler extends SetEnvironment{
    Staff staff = new Staff();
    Gun gun = new Gun();

    public boolean isEnd(String userName){
        boolean result = true;
        if (FieldOfGame.userHp <= 0){
            System.out.println("hp가 모두 소진되었습니다. 게임을 종료합니다.");
            System.out.print(userName + "님의 최종 스코어는 " + Gun.proficiency + Staff.proficiency + "lv 입니다.");
            result = false;
        }

        return result;
    }

    public void isTrapped(int grid, int sight){
        if (sight == 1){
            if(feild[locationX - grid][locationY].equals("🧨")){
                userHp -= 10;
                System.out.println("😵‍💫 함정에 빠져들었습니다. hp가 10 감소합니다. 😵‍💫");
            }
        }else if(sight == 3){
            if(feild[locationX + grid][locationY].equals("🧨")){
                userHp -= 10;
                System.out.println("😵‍💫 함정에 빠져들었습니다. hp가 10 감소합니다. 😵‍💫");
            }
        }else if (sight == 2){
            if(feild[locationX][locationY + grid].equals("🧨")){
                userHp -= 10;
                System.out.println("😵‍💫 함정에 빠져들었습니다. hp가 10 감소합니다. 😵‍💫");
            }
        }else {
            if(feild[locationX][locationY - grid].equals("🧨")){
                userHp -= 10;
                System.out.println("😵‍💫 함정에 빠져들었습니다. hp가 10 감소합니다. 😵‍💫");
            }
        }
    }

    public boolean isEscape(int grid, int sight){
        boolean sc = true;

        if (sight == 1){
            if(feild[locationX - grid][locationY].equals("🛟")) {
                System.out.println("탈출에 성공하였습니다. 게임을 종료합니다.");
                sc = false;
            }
        }else if(sight == 3){
            if(feild[locationX + grid][locationY].equals("🛟")) {
                System.out.println("탈출에 성공하였습니다. 게임을 종료합니다.");
                sc = false;
            }
        }else if (sight == 2){
            if(feild[locationX][locationY + grid].equals("🛟")) {
                System.out.println("탈출에 성공하였습니다. 게임을 종료합니다.");
                sc = false;
            }
        }else {
            if(feild[locationX][locationY - grid].equals("🛟")) {
                System.out.println("탈출에 성공하였습니다. 게임을 종료합니다.");
                sc = false;
            }
        }

        return sc;
    }

    public boolean fight(String userName){
        boolean result = true;
        Random random = new Random();
        int monsterHp = random.nextInt(200);
        Scanner intScanner = new Scanner(System.in);

        System.out.print("무기를 선택하세요. 현재 보유중인 무기 내역은 아래와 같습니다.\n1. 스태프\n2. 핸드건/샷건/라이플\n\n>> ");
        int weapon = intScanner.nextInt();

        switch (weapon){
            case 1:
                if (isEnd(userName)){
                    staff.select();
                    staff.skills(monsterHp);
                }else{
                    result = false;
                }
                break;
            case 2:
                if (isEnd(userName)){
                    gun.select();
                    gun.gunSkills(monsterHp);
                }else{
                    result = false;
                }
                break;
        }
        return result;
    }

    public boolean isEncounter(int grid, int sight, String userName){
        boolean result = true;

        if (sight == 1){
            if(feild[locationX - grid][locationY].equals("👿")) {
                System.out.println("몹을 마주했습니다. 전투를 시작합니다.");
                result = this.fight(userName);
            }
        }else if(sight == 3){
            if(feild[locationX + grid][locationY].equals("👿")) {
                System.out.println("몹을 마주했습니다. 전투를 시작합니다.");
                result = this.fight(userName);
            }
        }else if (sight == 2){
            if(feild[locationX][locationY + grid].equals("👿")){
                System.out.println("몹을 마주했습니다. 전투를 시작합니다.");
                result = this.fight(userName);
            }
        }else {
            if(feild[locationX][locationY - grid].equals("👿")) {
                System.out.println("몹을 마주했습니다. 전투를 시작합니다.");
                result = this.fight(userName);
            }
        }

        return result;
    }
}
