package _0920;

public class CandyStoreData {
    private static int cusCnt = 0;
    private int cusNum;
    private String name;
    private String joinDate;
    private String telNum;
    private int age;
    private String accNum;

    public void setData(String name, String date,
                        String tel, int age, String acc) {
        this.cusNum = ++cusCnt;
        this.name = name;
        this.joinDate = date;
        this.telNum = tel;
        this.age = age;
        this.accNum = acc;
    }

    public String getAllData() {
        return this.cusNum + "\t" + this.name + "\t" + this.joinDate
                + "\t" + this.telNum + "\t" + this.age + "\t" + this.accNum;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setJoinDate(String date) {
        this.joinDate = date;
    }
    public String getJoinDate() {
        return this.joinDate;
    }
    public void setTelNum(String tel) {
        this.telNum = tel;
    }
    public String getTelNum() {
        return this.telNum;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }
    public String getAccNum() {
        return this.accNum;
    }
}
