package _0920;

public class SmartPhone extends Phone {
    // 클래스 상속
    public boolean wifi;

    public SmartPhone(String model, String color){
        // 필드에 변수가 없어도 상속을 받았기 때문에 상속 클래스에 있는 필드 변수를 사용할 수 있다.
        this.model = model;
        this.color = color;
    }

    public void setWifi(boolean wifi){
        this.wifi = wifi;
        System.out.println("와이파이 상태 변경");
    }

    public void internet(){
        System.out.println("인터넷에 연결");
    }
}
