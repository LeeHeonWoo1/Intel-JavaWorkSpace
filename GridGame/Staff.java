package GridGame;

import java.util.Scanner;
import java.util.Random;

public class Staff extends SelectWeapon {
    static int staffExp = 0;
    static int proficiency = 1;

    static double skill1C = 0.2;
    static double skill2C = 0.3;
    static double skill3C = 0.9;
    static double skill4C = 0.6;
    Random random = new Random();

    public void levelUp(){
        if(staffExp >= 100){
            proficiency += 1;
            staffExp -= 100;
            FieldOfGame.userHp = 150;

            System.out.println("총 무기에 대한 숙련도레벨이 증가합니다. 계수가 0.1씩 추가됩니다.");
            System.out.println("또한, 체력의 최대치가 " + FieldOfGame.userHp +"으로 늘어나며, 회복합니다.");
            System.out.print("현재 레벨 : " + proficiency + "lv.  " + staffExp + "%\n");

            skill1C += 0.1;
            skill2C += 0.1;
            skill3C += 0.1;
            skill4C += 0.1;
        }else{
            System.out.println("숙련도가 부족합니다. 조금 더 쌓은 후에 시도해주세요.");
        }
    }

    public int hit(int damage){
        int criticalRate = random.nextInt(100);
        if (criticalRate <= 20){
            damage *= 2;
        }

        return damage;
    }

    public void select() {
        System.out.println("====================================================================");
        System.out.print("현재 장착한 무기는 스태프입니다. 아래의 스킬들을 사용할 수 있습니다\n" +
                "1. 아이스 애로우(데미지 " + (int)(10*skill1C) + ", 명중률 70%)\n"+
                "2. 엘리멘탈 리액트(데미지 " + (int)(30*skill2C) + ", 명중률 50%)\n"+
                "3. 종말의 날(데미지 " + (int)(70*skill3C) + ", 명중률 30%)\n"+
                "4. 익스플로전(데미지 "+ (int)(65*skill4C) +", 명중률 35%)\n");
        System.out.println("====================================================================");
    }

    public void skills(int monsterHp) {
        Scanner scanner = new Scanner(System.in);
        int copyOfHp = monsterHp;

        System.out.printf("현재 몬스터의 체력은 %d입니다. \n", monsterHp);
        while (monsterHp > 0) {
            System.out.print("타격할 스킬의 번호를 입력하세요 >> ");
            int skillNum = scanner.nextInt();
            int monDamage = random.nextInt(10)+1;
            switch (skillNum) {
                case 1:
                    int hitRate = random.nextInt(100);
                    int skillDamage = this.hit((int)(10*skill1C));

                    if (hitRate <= 70) {
                        if (skillDamage > (int)(10*skill1C)) {
                            monsterHp -= skillDamage;
                            System.out.printf("크리티컬 히트 ! 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                        else {
                            monsterHp -= skillDamage;
                            System.out.printf("스킬이 적중합니다. 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                    } else {
                        FieldOfGame.userHp -= monDamage;
                        System.out.printf("타격에 실패하여 피해를 입습니다. 현재 체력이 감소합니다. 현재 체력 : %d\n", FieldOfGame.userHp);
                    }

                    break;
                case 2:
                    int hitRate2 = random.nextInt(100);
                    int skillDamage2 = this.hit((int)(30*skill2C));

                    if (hitRate2 <= 50) {
                        if (skillDamage2 > (int)(30*skill2C)) {
                            monsterHp -= skillDamage2;
                            System.out.printf("크리티컬 히트 ! 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        } else {
                            monsterHp -= skillDamage2;
                            System.out.printf("스킬이 적중합니다. 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                    } else {
                        FieldOfGame.userHp -= monDamage;
                        System.out.printf("타격에 실패하여 피해를 입습니다. 현재 체력이 감소합니다. 현재 체력 : %d\n", FieldOfGame.userHp);
                    }

                    break;
                case 3:
                    int hitRate3 = random.nextInt(100);
                    int skillDamage3 = this.hit((int)(70*skill3C));

                    if (hitRate3 <= 35) {
                        if (skillDamage3 > (int)(70*skill3C)) {
                            monsterHp -= skillDamage3;
                            System.out.printf("크리티컬 히트 ! 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                        else {
                            monsterHp -= skillDamage3;
                            System.out.printf("스킬이 적중합니다. 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                    } else {
                        FieldOfGame.userHp -= monDamage;
                        System.out.printf("타격에 실패하여 피해를 입습니다. 현재 체력이 감소합니다. 현재 체력 : %d\n", FieldOfGame.userHp);
                    }

                    break;
                case 4:
                    int hitRate4 = random.nextInt(100);
                    int skillDamage4 = this.hit((int)(65*skill4C));

                    if (hitRate4 <= 30) {
                        if (skillDamage4 > (int)(65*skill4C)) {
                            monsterHp -= skillDamage4;
                            System.out.printf("크리티컬 히트 ! 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                        else {
                            monsterHp -= skillDamage4;
                            System.out.printf("스킬이 적중합니다. 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                    } else {
                        FieldOfGame.userHp -= monDamage;
                        System.out.printf("타격에 실패하여 피해를 입습니다. 현재 체력이 감소합니다. 현재 체력 : %d\n", FieldOfGame.userHp);
                    }

                    break;
            }
        }

        System.out.println("전투를 마쳤습니다. 경험치, 포인트를 획득합니다.");
        staffExp += copyOfHp/5;
        FieldOfGame.point += copyOfHp/10;
        System.out.println("현재 경험치는 " + staffExp + "% 입니다.");
    }
}
