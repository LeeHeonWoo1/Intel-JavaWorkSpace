package _1004;

// 상속 시에 extends를 붙였던 것 처럼 interface의 구조에 맞게 구현한다는 의미로 implements를 붙인다.
public class Fan implements MakeInterface{

    public void turnOn(){
        System.out.println("선풍기를 작동합니다.");
    }

    public void turnOff(){
        System.out.println("선풍기를 끕니다.");
    }
}
