package _0915;

// 같은 패키지 내에 있는 클래스들에 대해서는 import단이 없어도 자유롭게 사용 가능하다.
public class useClass {
    public static void main(String[] args) {
        BookInfo info = new BookInfo();
        info.bookName = "토끼와 거북이";
        info.author = "작가 미상";
        info.price = 15000;

        System.out.println(info.bookName);
        System.out.println(info.author);
        System.out.println(info.price);
    }
}
