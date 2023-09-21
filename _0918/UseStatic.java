package _0918;

public class UseStatic {
    public static void main(String[] args) {
        // 정적 멤버이기에 객체를 생성하지 않아도 바로 사용할 수 있다.
        double result = 10 * 10 * AboutStatic.pi;

        AboutStatic.pi = 2.1; // 정적 멤버 변수는 수정할 수 없다.
        // 이를 활용하면 여러 클래스에서 한 변수를 공유할 수 있다는 장점이 생긴다.

        // 일반적인 경우와 달리, 정적 멤버는 클래스 로더를 이용해서 클래스를 메소드 영역에 저장하고 사용한다.
        // Static의 경우 스태틱 공간에 따로 할당하기 때문에 여러 지점에서 참조할 수 있다는 장점이 있다.
        // 하지만 이는 Java 내부에서 자동적으로 처리해주지 않기 때문에 남용하면 메모리가 과하게 할당될 수 있다.
        System.out.println(result);

        // 클래스들의 경우 생성될 때 메모리에 클래스 구조를 한번 올리고 이후에 다시 정의될 때는 전체적으로 실행되지는 않는다.
        AboutStatic aStatic = new AboutStatic(21, 65);
        AboutStatic aStatic2 = new AboutStatic(1, 6);
        AboutStatic aStatic3 = new AboutStatic(6, 1);

        System.out.println(aStatic.add());
        System.out.println(aStatic.add());
        System.out.println(aStatic2.add());
        System.out.println(aStatic2.add());
        System.out.println(aStatic3.add());
        System.out.println(aStatic3.add());

        System.out.println(AboutStatic.count);
        System.out.println(AboutStatic.plusCount);

        System.out.println(AboutStatic.info);
        AboutStatic.company = "인텔 코리아";

        AboutStatic aStatic4 = new AboutStatic(7, 12);
        System.out.println(AboutStatic.info);
    }
}
