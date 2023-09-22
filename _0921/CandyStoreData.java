package _0921;

public class CandyStoreData {

    // 필드 선언
    private static int cusCnt = 0;
    private int cusNum;
    private String name;
    private String joinDate;
    private String telNum;
    private int age;
    private String accNum;

    // 인자값들을 받아 멤버들을 업데이트하는 메소드
    public void setInfo(String name, String date,
                        String tel, int age, String acc) {
        this.cusNum = ++cusCnt;
        this.name = name;
        this.joinDate = date;
        this.telNum = tel;
        this.age = age;
        this.accNum = acc;
    }

    // 멤버들을 모두 더한 문자열을 반환하는 메소드
    public String getAllInfo() {
        return this.cusNum + "\t" + this.name + "\t" + this.joinDate
                + "\t" + this.telNum + "\t" + this.age + "\t" + this.accNum;
    }

    // 아래 메소드들은 전부 멤버 하나씩을 가져오거나 멤버를 수정할 때 사용하는 메소드이다.
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