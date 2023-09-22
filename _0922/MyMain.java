package _0922;

import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        Scanner strScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);

        boolean flag = true;

        CandyCustomerInfo[] csd = new CandyCustomerInfo[5];
        CandyStoreEmployee[] cse = new CandyStoreEmployee[5];
        Inventory inv = new Inventory();
        CandyStoreBudget csb = new CandyStoreBudget();

        for (int i = 0; i < csd.length; i++)
            csd[i] = new CandyCustomerInfo();
        for (int i = 0; i < cse.length; i++)
            cse[i] = new CandyStoreEmployee();

        csd[0].setCusData("이헌우", "2023/08/12", "010-1234-5678", 24, "123-12345");
        csd[1].setCusData("주재원", "2023/08/15", "010-1234-3214", 24, "123-31245");
        csd[2].setCusData("박희민", "2023/08/21", "010-3214-1234", 24, "123-12112");
        csd[3].setCusData("손지혜", "2023/08/27", "010-1123-1111", 24, "123-66894");
        csd[4].setCusData("박현석", "2023/09/01", "010-1231-1232", 24, "123-11297");

        cse[0].setEmpData(981002,"김성범", "2023/08/12", "010-1234-5678", 24, "대리", "카운터");
        cse[1].setEmpData(980516, "오령엽", "2023/08/15", "010-1234-3214", 24, "인턴", "매장청소");
        cse[2].setEmpData(981207, "강종영", "2023/08/21", "010-3214-1234", 24, "과장", "제조");
        cse[3].setEmpData(981021,"김승윤", "2023/08/27", "010-1123-1111", 24, "팀장", "매장관리");
        cse[4].setEmpData(990123, "오현서", "2023/09/01", "010-1231-1232", 24, "부장", "재고관리");

        while(flag){
            System.out.print("codeInput >> ");
            String code = strScanner.nextLine();

            switch (code){
                case "get_all_code":
                    System.out.println("=====================코드 목록=====================");
                    System.out.println("get_all_customer : 고객 정보를 모두 반환합니다.");
                    System.out.println("get_all_emp : 사원 정보를 모두 반환합니다.");
                    System.out.println("perchase : 구매 프로세스를 진행합니다.");
                    System.out.println("set_store : 입고된 재고를 기반으로 재고를 업데이트합니다.");
                    System.out.println("get_store : 현재 재고를 확인합니다");
                    System.out.println("exit : 프로그램을 종료합니다.");
                    System.out.println("get_budget : 현재 예산을 반환합니다.");
                    System.out.println("get_cell_cnt : 해당 직원의 판매 실적을 확인합니다.");
                    System.out.println("input_new_cus : 새로운 회원들을 등록합니다.");
                    System.out.println("=================================================");
                    break;

                case "get_all_customer":
                    System.out.println("=============================================================");
                    System.out.println("회원번호\t회원명\t가입일자\t\t전화번호\t\t\t나이\t계좌번호");
                    System.out.println("=============================================================");
                    for(CandyStoreData data:csd)
                        System.out.println(data.getAllCusData());
                    System.out.println("=============================================================");
                    break;

                case "get_all_emp":
                    System.out.println("=============================================================");
                    System.out.println("사번\t\t사원명\t입사일자\t\t전화번호\t\t\t나이\t직급\t담당업무");
                    System.out.println("=============================================================");
                    for(CandyStoreEmployee data : cse)
                        System.out.println(data.getAllEmpData());

                    System.out.println("=============================================================");
                    break;

                case "perchase":
                    System.out.print("응대하는 직원의 이름을 입력하세요 : ");
                    String key = strScanner.nextLine();
                    System.out.print("구매하시는 고객님의 성함을 입력하세요 : ");
                    String cus = strScanner.nextLine();
                    System.out.print("딸기의 개수를 입력하세요 : ");
                    int straw1 = intScanner.nextInt();
                    System.out.print("포도의 개수를 입력하세요 : ");
                    int shine1 = intScanner.nextInt();
                    System.out.print("샤인 머스켓의 개수를 입력하세요 : ");
                    int grape1 = intScanner.nextInt();
                    System.out.print("귤의 개수를 입력하세요 : ");
                    int tanger1 = intScanner.nextInt();

                    for (int i = 0; i < cse.length; i++) {
                        if (cse[i].getAllEmpData().contains(key)) {
                            int price = csb.perchase(straw1, shine1, grape1, tanger1);
                            cse[i].countCell();
                            if (price != 0 && csd[i].getName().equals(cus)){
                                csd[i].getPoint(price);
                            }
                        }
                    }

                    break;

                case "set_store":
                    System.out.print("입고된 딸기의 개수를 입력하세요 : ");
                    int straw = intScanner.nextInt();
                    System.out.print("입고된 포도의 개수를 입력하세요 : ");
                    int shine = intScanner.nextInt();
                    System.out.print("입고된 샤인 머스켓의 개수를 입력하세요 : ");
                    int grape = intScanner.nextInt();
                    System.out.print("입고된 귤의 개수를 입력하세요 : ");
                    int tanger = intScanner.nextInt();

                    inv.setStore(straw, shine, grape, tanger);

                    break;

                case "get_store":
                    inv.getStore();
                    break;

                case "get_budget":
                    System.out.println(csb.getBudget());
                    break;

                case "get_cell_cnt":
                    System.out.print("조회하려는 직원의 이름을 입력하세요 : ");
                    String nameKey = strScanner.nextLine();
                    for (CandyStoreEmployee csee : cse){
                        if (csee.getAllEmpData().contains(nameKey)){
                            csee.getCellCnt();
                        }
                    }
                    break;

                case "input_new_cus":
                    System.out.print("신규 등록하려는 회원의 수를 입력하세요 : ");
                    int newCusCnt = intScanner.nextInt();

                    // 기존 회원 명수 + 신규 추가자 수로 새로운 공간 확보(reference : null)
                    CandyCustomerInfo[] newCsd = new CandyCustomerInfo[csd.length + newCusCnt];
                    for (int i = 0; i < newCsd.length; i++) {
                        newCsd[i] = new CandyCustomerInfo(); // 레퍼런스를 할당하되
                        if (i < csd.length) // 기존 회원 명수 까지의 인덱스에 할당될 레퍼런스는
                            newCsd[i] = csd[i]; // 기존 레퍼런스를 그대로 사용한다.
                    }
                    int idx = csd.length; // 새로운 레퍼런스가 들어갈 시작 인덱스
                    while(idx < newCsd.length){ // 새로운 회원 수만큼 반복하면서
                        // 값들을 입력받고
                        System.out.println("-------------------------------------");
                        System.out.print("이름을 입력하세요 : ");
                        String name = strScanner.nextLine();

                        System.out.print("등록 일자를 입력하세요 : ");
                        String date = strScanner.nextLine();

                        System.out.print("휴대폰 번호를 입력하세요 : ");
                        String phoneNum = strScanner.nextLine();

                        System.out.print("나이를 입력하세요 : ");
                        int age = intScanner.nextInt();

                        System.out.print("계좌번호를 입력하세요 : ");
                        String account = strScanner.nextLine();

                        newCsd[idx].setCusData(name, date, phoneNum, age, account); // 새로운 값으로 업데이트
                        idx++; // idx 증가
                    }

                    csd = newCsd; // 같은 CandyCustomerInfo의 배열 형태인 newCsd로 바꾸며 값 업데이트
                    System.out.println("-------------------------------------");
                    System.out.println("회원 등록을 완료했습니다.");
                    break;

                case "exit":
                    flag = false;
                    break;

                default:
                    System.out.println("등록되지 않은 명령어입니다.");
            }
        }

    }
}
