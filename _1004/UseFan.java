package _1004;

public class UseFan {
    public static void main(String[] args) {
        // 인터페이스에서 정의한 형상에 맞게 구현한 클래스를 사용하려면 클래스로 객체를 생성하는게 아니라
        // 인터페이스 이름으로 객체를 생성해야 한다.
        MakeInterface cooler;

        cooler = new Fan();
        cooler.turnOn();
        cooler.powerUp();
        cooler.powerDown();
        cooler.powerSet(12);
        cooler.turnOff();

//        cooler = new AirConditioner();
//        cooler.turnOn();
//        cooler.turnOff();

    }
}
