package _0918;

public class MyClass {
    // 생성자 선언과 호출
    // new 연산자는 객체를 생성한 후 연이어 생성자를 호출해서 초기화하는 역할을 한다.
    // 근데 딱히 굳이 필수적인 요소는 아니다. 왜 필요할까? : 파라미터를 다양하게 주기 위해서 사용한다.

    // 필드 : 클래스 내부에서 사용할 변수들을 지정하는 구역
    // static / instance
    // instance : 객체 의존 멤버 : 객체가 사라지면 같이 사라진다
    // static : 클래스 의존 멤버 : 객체가 사라져도 사라지지 않는다
    String bookName;
    String author;
    String translator = "박현우";
    String pubDate = "2023.09.18";
    String publisher = "고누아이";
    int price;

    // 다형성 : 다양한 형태로 클래스를 생성할 수 있게 생성자를 여러 방법으로 정의한다.
    // 아래와 같은 형태를 생성자 오버로딩이라고 한다.
    // 이 때 주의해야할 점으로는, 매개변수의 타입, 개수, 순서가 다르게 여러 개의 생성자를 선언해야한다. 아래와 같은 경우를 보자.
    // public MyClass(String name, String color){}
    // public MyClass(String color, String name){}
    // 위 경우 순서는 다를지언정 개수가 같기 때문에 컴파일 에러가 발생한다.

    // 생성자 영역
    public MyClass(String inputName, String inputAuthor){
        this(inputName, inputAuthor, "", "", "", 0);
    }

    public MyClass(String inputName){
        this.bookName = inputName;
    }

    public MyClass(String inputName, String inputAuthor, String inputPublisher){
        this(inputName, inputAuthor, "", "", inputPublisher, 0);
    }

    // 다른 생성자 호출
    // 생성자 오버로딩 시 생각보다 불편한 점이 생긴다. 코드가 중복되는 부분인데, 이러한 부분을 다른 생성자를 호출하면서 해결할 수 있다.
    public MyClass(String name, String author, String translator, String pub){
        this(name, author, translator, "", pub, 0);
    }

    // this는 인스턴스 자기 자신을 의미한다. 생성자 내부에 정의하는 파라미터와 멤버변수의 이름이 겹칠 때 중복을 피하기 위해서 사용한다.
    public MyClass(String name, String author, String translator, String pub, int price){
        this(name, author, translator, "2023.09.23", pub, price);
    }
    // 인자값 6개를 받아서 필드에 있는 값들에다가 업데이트 하는 생성자.
    public MyClass(String name, String author, String translator, String pubDate, String pub, int price){
        // this ?

        bookName = name;
        this.author = author;
        this.translator = translator;
        this.pubDate = pubDate;
        publisher = pub;
        this.price = price;
    }

    // 메소드 영역
    void showBookName(){ // 책 이름을 출력하는 메소드
        System.out.printf("현재 클래스 내부에 할당되어 있는 책 이름은 %s 입니다.",this.bookName);
    }

    void showAllInfo(){
        System.out.printf(
                "책 이름 : %s\n저자 : %s\n엮은 이 : %s\n출판사 : %s\n출판일 : %s\n가격 : %d원",
                this.bookName,
                this.author,
                this.translator,
                this.publisher,
                this.pubDate,
                this.price
        );
    }
}
