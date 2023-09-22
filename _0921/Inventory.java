package _0921;

public class Inventory extends CandyCustomerInfo {

    private int stawberry = 10;
    private int shineMusket = 10;
    private int grape = 10;
    private int tangerine = 10;

    CandyStoreBudget budget = CandyStoreBudget.getInstance(); // 참조 레퍼런스 복사
    private static Inventory inven = new Inventory(); // Singleton pattern

    private Inventory() {

    }

    // 참조값 리턴
    public static Inventory getInstance() {
        return inven;
    }

    // 재고를 추가하는 메소드
    public void store(String fruit, int num) {
        switch (fruit) {
            case "딸기" :
                if(checkBalance(num))
                    this.stawberry += num;
                break;
            case "샤인머스킷" :
                if(checkBalance(num))
                    this.shineMusket += num;
                break;
            case "포도" :
                if(checkBalance(num))
                    this.grape += num;
                break;
            case "귤" :
                if(checkBalance(num)) {
                    this.tangerine += num;
                }
                break;
            default :
                System.out.println("잘못입력하셨습니다.");
        }
    }

    // 입고하는 수량에 따라 예산을 차감하는 메소드
    private boolean checkBalance(int x) {
        budget.doWithdraw(x * 2000);
        if(budget.getBalance() > 0) {
            budget.doWithdraw(x * 2000);
            return true;
        }
        else {
            System.out.println("입고 실패 : 예산부족");
            budget.doDeposit(x);
            return false;
        }
    }

    // 딸기 개수 반환 메소드
    public int getStawberry() {
        return this.stawberry;
    }

    // 샤인머스켓 개수 반환 메소드
    public int getShineMusket() {
        return this.shineMusket;
    }

    // 포도 개수 반환 메소드
    public int getGrape() {
        return this.grape;
    }

    // 귤 개수 반환 메소드
    public int getTangerine() {
        return this.tangerine;
    }

    public boolean doPurchase(String fruit, int cnt){
        boolean result = true;
        switch (fruit){
            case "딸기":
                if (stawberry != 0 && stawberry >= cnt){
                    this.stawberry -= cnt;
                }else{
                    result = false;
                }
                break;
            case "샤인머스킷":
                if (shineMusket != 0 && shineMusket >= cnt){
                    shineMusket -= cnt;
                }else{
                    result = false;
                }
                break;
            case "포도":
                if (grape != 0 && grape >= cnt){
                    grape -= cnt;
                }else{
                    result = false;
                }
                break;
            case "귤":
                if (tangerine != 0 && tangerine >= cnt){
                    tangerine -= cnt;
                }else{
                    result = false;
                }
                break;
        }

        return result;
    }
}
