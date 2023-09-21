package _0915;

public class myFunctions {
    // 함수 정의하기
    public static void main(String[] args) {
        int a = 5, b = 3;

        System.out.println(twoSum(a, b));

    }

    // 자바의 메모리 영역 : https://kotlinworld.com/3

    // 함수를 정의할 때는 함수가 반환하는 자료형, 함수의 이름, 인자값으로 구성된다.
    // static ?
    // Static을 이용해서 static변수와 static 메소드를 생성할 수 있는데, 다른 말로는 정적 필드와 정적 메소드라고 하며
    // 이 둘을 합쳐서 정적 멤버라고 합니다. 정적 필드와 정적 메소드는 객체에 소속된 멤버가 아니라 클래스에 고정된 멤버입니다.
    // 그렇기에 클래스 로더가 클래스를 로딩해서 메소드 메모리 영역에 적재할 때, 클래스별로 관리됩니다. 따라서 클래스의 로딩이 끝나면 사용할 수 있습니다.
    // static 키워드를 통해서 생성된 정적 멤버들은 Heap영역이 아닌 Static영역에 할당됩니다. Static영역에 할당된 메모리는 모든 객체가 공유하여
    // 하나의 멤버를 어디서든지 참조할 수 있는 장점을 가지지만 Garbage Collector의 관리 영역 밖에 존재하기에 Static영역에 있는 멤버들은
    // 프로그램의 종료시 까지 메모리가 할당된 채로 존재하게 됩니다. Static을 너무 남발하면 좋지 않겠죠?

    static int twoSum(int x, int y){
        return x + y;
    }
}
