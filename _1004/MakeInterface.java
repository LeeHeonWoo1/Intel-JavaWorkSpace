package _1004;

public interface MakeInterface {
    // 인터페이스는 두 객체를 연결하는 역할을 한다. : 캡슐화를 구현하기 위해서 사용한다.
    // 객체 A가 인터페이스의 메소드를 호출하면, 인터페이스는 객체 B의 메소드를 호출하고 그 결과를 받아 객체 A로 전달해준다.

    // 인터페이스 내부에 정의되는 필드들의 경우, static final 키워드가 붙는 "상수" 가 된다.
    int MAX_POWER_LEVEL = 5;
    int MIN_POWER_LEVEL = 0;

    // 중괄호를 열어 내부에 작동 코드를 넣었던 방식과는 다르게 인터페이스에서 메소드를 정의하는 경우 양식만 지정하면 된다.
    public void turnOn();
    public void turnOff();
    public void powerUp();
    public void powerDown();
    public void powerSet(int level);
}
