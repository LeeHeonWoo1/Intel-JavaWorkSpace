package _1004;

public class MultiImplements implements NewInterface, NewInterFace2{
    // 인터페이스가 가지는 클래스와의 가장 큰 차이점은
    // 클래스는 다중 상속이 불가능한 반면
    // 인터페이스는 다중 구현이 가능하다.

    public void add(int x, int y){
        System.out.printf("%d + %d = %d\n", x, y, x+y);
    }
    public void sub(int x, int y){
        System.out.printf("%d - %d = %d\n", x, y, x-y);
    }
    public void mul(int x, int y){
        System.out.printf("%d x %d = %d\n", x, y, x*y);
    }
    public void div(int x, int y){
        System.out.printf("%d / %d = %d\n", x, y, x/y);
    }
}
