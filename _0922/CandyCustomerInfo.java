package _0922;

public class CandyCustomerInfo extends CandyStoreData{
    private int point;
    private String grade = "실버";

    public void getPoint(int price){
        point += price/100;

        if (point >= 100){
            grade = "골드";
        }else if (point >= 1000){
            grade = "플래티넘";
        }else if (point >= 10000){
            grade = "VIP";
        }

        System.out.println("구매가 완료되었습니다. 현재 고객님의 등급은 " + grade + "입니다.");
    }
}
