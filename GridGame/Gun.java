package GridGame;

import java.util.Random;
import java.util.Scanner;

public class Gun extends SelectWeapon{
    static double skill1C = 0.1;
    static double skill2C = 0.2;
    static double skill3C = 0.7;
    static double skill4C = 0.5;
    static int gunExp = 0;
    static int proficiency = 1;
    Random random = new Random();

    public int hit(int damage){
        int criticalRate = random.nextInt(100);
        if (criticalRate <= 20){
            damage *= 2;
        }

        return damage;
    }

    public void levelUp(){
        if (gunExp >= 100){
            proficiency += 1;
            gunExp -= 100;
            FieldOfGame.userHp = 150;

            System.out.println("✌️ 총 무기에 대한 숙련도레벨이 증가합니다. 계수가 0.1씩 추가됩니다. ✌️");
            System.out.println("또한, 체력의 최대치가 " + FieldOfGame.userHp +"으로 늘어나며, 회복합니다.");
            System.out.print("현재 레벨 : " + proficiency + "lv.  " + gunExp + "%\n");

            skill1C += 0.1;
            skill2C += 0.1;
            skill3C += 0.1;
        }else
            System.out.println("숙련도가 부족합니다. 조금 더 쌓은 후에 다시 시도해주세요.");
    }

    public void select() {
        System.out.println("====================================================================");
        System.out.print("현재 장착한 무기는 총입니다. 3가지의 스탠스로 아래의 스킬들을 사용할 수 있습니다\n" +
                "1. 핸드건/레인 오브 불릿(데미지 " + (int)(14*skill1C) + ", 명중률 70%)\n"+
                "2. 샷건/샷건의 지배자(데미지 " + (int)(30*skill2C) + ", 명중률 50%)\n"+
                "3. 라이플/타겟다운(데미지 " + (int)(90*skill3C) + ", 명중률 25%)\n"+
                "4. 라이플/퍼펙트 샷(데미지 " + (int)(70*skill4C) + ", 명중률 40%)\n");
        System.out.println("====================================================================");
    }

    public void gunSkills(int monsterHp) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.printf("👿 현재 몬스터의 체력은 %d입니다. \n", monsterHp);
        while (monsterHp > 0) {
            System.out.print("타격할 스킬의 번호를 입력하세요 >> ");
            int skillNum = scanner.nextInt();
            int monDamage = random.nextInt(10)+1;
            switch (skillNum) {
                case 1:
                    int hitRate = random.nextInt(100);
                    int skillDamage = this.hit((int)(14*skill1C));

                    if (hitRate <= 70) {
                        if (skillDamage > (int)(14*skill1C)) {
                            monsterHp -= skillDamage;
                            System.out.printf("✨ 크리티컬 히트 ! ✨ 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                        else {
                            monsterHp -= skillDamage;
                            System.out.printf("스킬이 적중합니다. 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                    } else {
                        FieldOfGame.userHp -= monDamage;
                        System.out.printf("🥵 타격에 실패하여 %d의 피해를 입습니다. 현재 체력이 감소합니다. 현재 체력 : %d\n", monDamage, FieldOfGame.userHp);
                    }

                    break;
                case 2:
                    int hitRate2 = random.nextInt(100);
                    int skillDamage2 = this.hit((int)(30*skill2C));

                    if (hitRate2 <= 50) {
                        monsterHp -= skillDamage2;
                        if (skillDamage2 > (int)(30*skill2C)) {
                            monsterHp -= skillDamage2;
                            System.out.printf("✨ 크리티컬 히트 ! ✨ 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                        else {
                            monsterHp -= skillDamage2;
                            System.out.printf("스킬이 적중합니다. 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                    } else {
                        FieldOfGame.userHp -= monDamage;
                        System.out.printf("🥵 타격에 실패하여 %d의 피해를 입습니다. 현재 체력이 감소합니다. 현재 체력 : %d\n", monDamage, FieldOfGame.userHp);
                    }

                    break;
                case 3:
                    int hitRate3 = random.nextInt(100);
                    int skillDamage3 = this.hit((int)(90*skill3C));

                    if (hitRate3 <= 25) {
                        if (skillDamage3 > (int)(90*skill3C)) {
                            monsterHp -= skillDamage3;
                            System.out.printf("✨ 크리티컬 히트 ! ✨ 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        } else {
                            monsterHp -= skillDamage3;
                            System.out.printf("스킬이 적중합니다. 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                    } else {
                        FieldOfGame.userHp -= monDamage;
                        System.out.printf("🥵 타격에 실패하여 %d의 피해를 입습니다. 현재 체력이 감소합니다. 현재 체력 : %d\n", monDamage, FieldOfGame.userHp);
                    }

                    break;
                case 4:
                    int hitRate4 = random.nextInt(100);
                    int skillDamage4 = this.hit((int)(70*skill4C));

                    if (hitRate4 <= 40) {
                        if (skillDamage4 > (int)(70*skill4C)) {
                            monsterHp -= skillDamage4;
                            System.out.printf("✨ 크리티컬 히트 ! ✨ 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                        else {
                            monsterHp -= skillDamage4;
                            System.out.printf("스킬이 적중합니다. 몬스터의 체력이 %d 남았습니다.\n", monsterHp);
                        }
                    } else {
                        FieldOfGame.userHp -= monDamage;
                        System.out.printf("🥵 타격에 실패하여 %d의 피해를 입습니다. 현재 체력이 감소합니다. 현재 체력 : %d\n", monDamage, FieldOfGame.userHp);
                    }

                    break;
            }
        }

        System.out.println("전투를 마쳤습니다. 경험치를 획득합니다.");
        gunExp += monsterHp/5;
        FieldOfGame.point += monsterHp/10;
        System.out.println("현재 경험치는 " + gunExp + "% 입니다.");
    }
}
