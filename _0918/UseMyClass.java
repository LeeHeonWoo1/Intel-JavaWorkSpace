package _0918;

import _0918.MyClass;

public class UseMyClass {
    public static void main(String[] args) {
        // 클래스명 객체명 = new 클래스명(인자값);
        MyClass myclass = new MyClass("호랑수월가", "이헌우"); // 클래스 객체 선언부
        // 메소드나 필드에 있는 값들에 접근하려 한다면
        // 객체명.메소드이름(인자값);
        // 객체명.필드변수이름;
        System.out.println(myclass.bookName + " " + myclass.author);

        MyClass myclass2 = new MyClass("호랑수월가", "이헌우", "고누아이 출판사");
        System.out.println(myclass2.bookName + " " + myclass2.publisher + " " + myclass2.author);
//        myclass2.showBookName();

        MyClass myclass3 = new MyClass("별주부전", "이헌우", "박현우", "2023.09.18", "고누아이 출판사", 18000);
        myclass3.showAllInfo();
    }
}
