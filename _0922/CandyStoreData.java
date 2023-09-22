package _0922;

public class CandyStoreData {
    private static int id = 0;
    private int cnt;
    private String name;
    private String date;
    private String phone;
    private int age;
    private String account;

    public void setCusData(String name, String date, String phone, int age, String account){
        this.cnt = ++id;
        this.name = name;
        this.date = date;
        this.phone = phone;
        this.age = age;
        this.account = account;
    }

    public String getAllCusData(){
        return cnt + "\t\t" + name + "\t" + date + "\t" + phone + "\t" + age + "\t" + account;
    }

    public String getName(){
        return name;
    }
}
