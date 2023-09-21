package _0918;

public class AboutStatic {
    // static? : 객체에 의존하지 않는, 클래스에 의존하는 타입을 이야기한다.
    // static이란 키워드가 붙지 않는 인스턴스 멤버들은 객체가 사라지면 소멸하지만, static 키워드가 붙은 스태틱 멤버들은
    // 객체가 사라져도 소멸하지 않는다.

    // 정적 멤버, 정적 메소드 활용
    static double pi = 3.141592;
    static int count = 0;
    static int plusCount = 0;
    int x;
    int y;
    static String company = "고누아이";
    static String job = "개발자";
    static String info;

    static {
        info = company + "-" + job;
    }


    public AboutStatic(int x, int y){
        count ++;
        this.x = x;
        this.y = y;
    }

     int add(){
        plusCount++;
        return this.x + this.y;
    }

     int sub(){
        return this.x - this.y;
    }
}
