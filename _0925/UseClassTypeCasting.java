package _0925;

import com.sun.jdi.ClassType;

public class UseClassTypeCasting {
    public static void main(String[] args) {
        ClassTypeCasting2 child = new ClassTypeCasting2(); // 자식 객체를 만들고
        ClassTypeCasting parent = child; // 부모 클래스에 자식 클래스의 레퍼런스를 할당한다

        // 부모 클래스에 자식 클래스의 레퍼런스를 할당했기에
        parent.method1(); // 이는 당연히 부모클래스에 있는 메소드가 실행되고
        parent.method2(); // 이는 자식 클래스에 있는 메소드가 실행된다.
    //  parent.method3(); // 이는 실행이 되지 않았다. 왜?

        // 클래스 자동 형변환
        // 클래스 타입 캐스팅에는 업캐스팅과 다운캐스팅이 있다.
        // 업캐스팅 : 상속 트리의 위쪽 방향으로 하위 유형을 상위 유형으로 캐스팅하는 행위를 일컫는다.
        // 하위 클래스 객체가 상위 클래스 참조 변수에 의해 참조되는 경우 별도의 과정 필요없이 자동으로 형전환 된다.
        // 동적 다형성과 연관시킬 수 있다.
        // 암시적 캐스팅은 캐스팅 구문 없이 컴파일러에서 수행되는 클래스 타입 캐스팅을 의미한다.
        // 명시적 캐스팅은 프로그래머가 캐스팅 구문을 사용하여 수행하는 클래스 타입 캐스팅을 의미한다.

        // 명시적 캐스팅 예시
        ClassTypeCasting parent1 = (ClassTypeCasting2) child;
        parent1.method1();
        parent1.method2(); // 클래스 업캐스팅 시 캐스팅된 클래스 내부에 overriding된 메소드가 있으면 그대로를 가져오는 성질이 있다.

        // 다운캐스팅 : 하위 클래스 유형이 상위 클래스의 객체를 참조하는 절차를 다운캐스팅이라고 한다.
    }
}
