package _0920;

public class CandyStoreEmployee extends CandyStoreData{
    private static int empCnt = 0;
    private int cmpNum;
    private String position; //직책
    private String respon;  //담당업무
    private int salePerform = 0; //판매실적

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

    public String getAllInfo() {
        String outputData = this.cmpNum + "\t" + this.getName() + "\t"
                + this.getJoinDate() + "\t" + this.getTelNum() + "\t"
                + this.getAge() + "\t" + this.getAccNum() + "\t"
                + this.position + "\t" + this.respon;

        return outputData;
    }

    public void doSale() {
        this.salePerform++;
        System.out.println(this.getName() + "가 판매하였습니다.");
    }
    public int getSalePerform() {
        return this.salePerform;
    }

    public void showSalePerform() {
        System.out.println(this.getName() + "는 " + this.salePerform + "개 판매하였습니다.");
    }

}
