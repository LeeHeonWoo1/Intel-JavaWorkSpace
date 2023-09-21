package _0920;

public class CandyStoreCustomer extends CandyStoreData{
    private int point = 0;
    private int grade = 0;

    public void getPoint(){
        System.out.printf("감사합니다 현재 포인트는 %d원이십니다 ! \n", point);
    }

    public void setPoint(int price){
        point += price/10;

        if(point >= 10000){
            grade += 1;
        }
    }
}
