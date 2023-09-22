package _0921;

public class CandyStoreBudget {
    // 외부에서 접근 불가능한 멤버변수
    private int TotalAmount = 10000000;

    // Singleton pattern : 외부에서 접근할 수 없고 생성할 수 없지만 내부에서 자체적으로 생성을 함으로 인해
    // 메모리를 절감할 수 있다. 참조를 복사해서 사용한다는 의미이다.
    private static CandyStoreBudget csb = new CandyStoreBudget();

    private CandyStoreBudget() {

    }

    // 객체 자체를 리턴하는 메소드이다.
    public static CandyStoreBudget getInstance() {
        return csb;
    }

    // 입금을 하는 메소드로 현재 잔고를 입력받는 정수형 인자값만큼 증가시킨다.
    public void doDeposit(int m) {
        this.TotalAmount += m;
    }

    // 출금을 하는 메소드로 현재 잔고를 입력받는 정수형 인자값만큼 감소시킨다.
    public void doWithdraw(int m) {
        this.TotalAmount -= m;
    }

    // 현재 잔고를 리턴하는 메소드이다.
    public int getBalance() {
        return this.TotalAmount;
    }

}