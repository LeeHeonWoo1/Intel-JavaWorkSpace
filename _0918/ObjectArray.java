package _0918;

public class ObjectArray {
    public static void main(String[] args) {
        // 아래와 같이 실행할 때는 nullPointerException이 발생한다.
        // 이는 객체를 생성할 때 5개의 "비어있는" 참조 공간을 만들고,
        // 레퍼런스가 비어있는 상태이기 때문에 nullPointerException이 발생한다.

//        MyClass[] bi = new MyClass[5];
//
//        bi[0].bookName = "호랑수월가";
//        System.out.println(bi[0].bookName);
//        MyClass[] bi = new MyClass[5];
//        for (int i = 0; i < bi.length; i++) {
//            bi[i] = new MyClass(); // 이렇게 해야 비로소 각 배열값에 대한 참조를 만들게 되고, 정상적으로 돌아간다.
//        }
//        bi[0].bookName = "호랑수월가";
//        System.out.println(bi[0].bookName);
    }
}