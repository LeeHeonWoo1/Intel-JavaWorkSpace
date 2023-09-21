package _0920;

public class FinalStatic {
    final String myName; // 선언 시에 초기값을 넣거나, 생성자에서 넣을 수 있는데 생성자에서 넣으려면 타입변수로 둬도 된다.
    String myName2 = "카리나";

    // final 키워드 자체가 상수인 것이 아님. final키워드가 가지는 특징점은 외부에서 수정이 불가한 멤버라는 것이고,
    // static 키워드가 가지는 특징점은 여러 파일에서 공유할 수 있다는 점이었다.
    // 이 두 특징이 합쳐지면 "상수"가 되는 것이다.
    final static double PI = 3.141592; // 상수화

    public FinalStatic(String x){
        myName = x;
    }


}
