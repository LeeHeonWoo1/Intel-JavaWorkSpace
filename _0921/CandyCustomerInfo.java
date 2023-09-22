package _0921;

public class CandyCustomerInfo extends CandyStoreData{
    // 필드 정의
    private int point=0;
    private String CusLevel = "일반";
    CandyStoreBudget budget = CandyStoreBudget.getInstance(); // Singleton pattern 참조 복사

    // 구매하게 되면 포인트를 적립하고, 포인트에 따라 등급을 올린다.
    public void doPurchase(boolean result) {
        if (result){
            this.point += 10;
            System.out.println("구매완료");
            if(point > 100)
                this.CusLevel = "VIP";
        }else{
            System.out.println("재고가 부족하여 판매할 수 없습니다.");
        }
    }

    // 고객의 현재 등급 정보를 출력한다.
    public void ShowLevel(String key) {
        if(this.getName().equals(key))
            System.out.println(this.CusLevel);
    }

    // 고객의 잔여 포인트를 반환한다.
    public int getPoint() {
        return this.point;
    }

    // 고객의 등급을 반환한다.
    public String getLevel() {
        return this.CusLevel;
    }

}

