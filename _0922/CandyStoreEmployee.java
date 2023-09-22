package _0922;

public class CandyStoreEmployee extends CandyStoreData{
    private int empID;
    private String name;
    private String date;
    private String phone;
    private int age;
    private String rank;
    private String part;
    private int cellCnt;

    public void setEmpData(int empID, String name, String date, String phone, int age, String rank, String part){
        this.empID = empID;
        this.name = name;
        this.date = date;
        this.phone = phone;
        this.age = age;
        this.rank = rank;
        this.part = part;
    }

    public void countCell(){
        cellCnt += 1;
    }

    public void getCellCnt(){
        System.out.println(name + "은 총 " + cellCnt + "회의 판매를 진행했습니다." );
    }

    public String getAllEmpData(){
        return empID + "\t" + name + "\t" + date + "\t" + phone + "\t" + age + "\t" + rank + "\t" + part;
    }


}
