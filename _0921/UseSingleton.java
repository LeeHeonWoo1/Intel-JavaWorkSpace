package _0921;

public class UseSingleton {
    public static void main(String[] args) {
//        Singleton ss = new Singleton();

        Singleton ss1 = Singleton.getInstance(); // 외부에서 필드를 참조하지 못하게 클래스 내부에서 생성자를 실행하기에
        Singleton ss2 = Singleton.getInstance(); // 같은 참조값을 가지게 된다.

        if(ss1 == ss2){
            System.out.println("참조가 같습니다");
        }else{
            System.out.println("참조가 다릅니다");
        }
    }
}
