package _0921;

public class CandyStoreEmployee extends CandyStoreData{

    private static int empCnt = 0;
    private int cmpNum;
    private String position; //직책
    private String respon;  //담당업무
    private int salePerform = 0; //판매실적

    CandyStoreBudget budget = CandyStoreBudget.getInstance(); // 참조 복사

    // 직원 정보 업데이트 메소드
    public void setInfo(String name, String date, String tel, int age,
                        String acc, String position, String respon) {
        this.cmpNum = ++empCnt;
        this.setName(name);
        this.setJoinDate(date);
        this.setTelNum(tel);
        this.setAge(age);
        this.setAccNum(acc);
        this.position = position;
        this.respon = respon;
    }

    // 모든 정보를 담은 문자열 반환 메소드
    public String getAllInfo() {
        return this.cmpNum + "\t" + this.getName() + "\t"
                + this.getJoinDate() + "\t" + this.getTelNum() + "\t"
                + this.getAge() + "\t" + this.getAccNum() + "\t"
                + this.position + "\t" + this.respon;
    }

    // 판매한 직원의 판매실적 카운트 메소드
    public void doSale() {
        this.salePerform++;
        System.out.println(this.getName() + "가 판매하였습니다.");
    }

    // 판매 실적을 반환하는 메소드
    public int getSalePerform() {
        return this.salePerform;
    }

    // 직급을 반환하는 메소드
    public String getPosition() {
        return this.position;
    }

    // 해당 직원의 판매 실적을 출력하는 메소드
    public void showSalePerform() {
        System.out.println(this.getName() + "는 " + this.salePerform + "개 판매하였습니다.");
    }

    // 직급에 따라 각 급여에 맞춰서 급여 지급 메소드 실행
    public void giveSalary() {
        if(this.position.equals("부장"))
            this.checkBalance(5000000);
        else if(this.position.equals("대리")) {
            this.checkBalance(3000000);
        }else if(this.position.equals("직원")) {
            this.checkBalance(1500000);
        }
    }

    // 직급을 변경하는 메소드
    public void setPosition(String x) {
        this.position = x;
    }

    // 예산 내에서 급여를 지급하는 메소드
    private void checkBalance(int x) {
        budget.doWithdraw(x);
        if(budget.getBalance() > 0)
            System.out.println(this.getName() + "에게 월급 지급 완료!!");
        else {
            System.out.println("지급 실패 : 잔액부족");
            budget.doDeposit(x);
        }
    }
}