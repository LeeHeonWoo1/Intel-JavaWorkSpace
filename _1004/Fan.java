package _1004;


// 상속 시에 extends를 붙였던 것 처럼 interface의 구조에 맞게 구현한다는 의미로 implements를 붙인다.
public class Fan implements MakeInterface{
    int powerLevel = 0;
    boolean isDirect = false;

    public void turnOn(){
        System.out.println("선풍기를 작동합니다.");
    }

    public void turnOff(){
        powerLevel = MIN_POWER_LEVEL;
        System.out.println("선풍기를 끕니다.");
    }

    public void powerUp(){
        powerLevel++;
        System.out.printf("바람 세기를 %d단계로 높입니다.\n", powerLevel);
    }

    public void powerDown(){
        powerLevel--;
        System.out.printf("바람 세기를 %d단계로 낮춥니다.\n", powerLevel);
    }

    public void powerSet(int level){
        if (level > MAX_POWER_LEVEL){
            System.out.printf("최대 단계는 %d단계 입니다.\n", MAX_POWER_LEVEL);
        }else{
            powerLevel = level;
            System.out.printf("바람 세기를 %d단계로 설정합니다.\n", level);
        }
    }

    public boolean getStation(){
        return isDirect;
    }

    public void setStation(boolean f){
        isDirect = f;
    }
}
