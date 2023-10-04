package _1004;

import java.util.Scanner;

public class AirConditioner implements MakeInterface{
    int temp = 24;
    Scanner intScanner = new Scanner(System.in);
    boolean isDirect = false;

    public void turnOn(){
        System.out.println("에어컨을 작동합니다.");
    }

    public void turnOff(){
        System.out.println("에어컨을 끕니다.");
    }

    public void powerSet(int newTemp){
        System.out.printf("에어컨의 온도를 %d도로 설정합니다.\n", newTemp);
    }

    public void powerUp(){
        System.out.print("낮출 온도를 작성하세요 : ");
        temp = intScanner.nextInt();
        System.out.printf("에어컨의 온도를 %d도로 낮춥니다.\n", temp);
    }

    public void powerDown(){
        System.out.print("높일 온도를 작성하세요 : ");
        temp = intScanner.nextInt();
        System.out.printf("에어컨의 온도를 %d도로 높입니다.\n", temp);
    }

    public boolean getStation(){
        return isDirect;
    }

    public void setStation(boolean f){
        isDirect = f;
    }
}
