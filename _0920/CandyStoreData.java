package _0920;

public class CandyStoreData {
    private static int id = 0;
    private int cusNum;
    private String name;
    private String date;
    private int age;
    private String phoneNum;
    private String account;

    public void setData(String name, String date, String phoneNum, int age, String account){
        this.cusNum = ++id;
        this.name = name;
        this.date = date;
        this.age = age;
        this.phoneNum = phoneNum;
        this.account = account;
    }

    public String getData(){
        String newVal = cusNum + "\t\t" + name + "\t" + date + "\t" + phoneNum + "\t" + age + "\t" + account;
        return newVal;
    }
}
