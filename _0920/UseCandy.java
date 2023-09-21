package _0920;

import java.util.Scanner;

public class UseCandy {
    public static void main(String[] args) {
        CandyStoreCustomer[] cd = new CandyStoreCustomer[5];
        CandyStoreEmployee[] ce = new CandyStoreEmployee[3];
        int inputCnt = 0;

        for (int i = 0; i < cd.length; i++)
            cd[i] = new CandyStoreCustomer();
        for (int i = 0; i < ce.length; i++)
            ce[i] = new CandyStoreEmployee();


        cd[0].setData("이헌우", "2010/05/01", "010-1111-2222", 24, "121212-34343434");
        cd[1].setData("주재원", "2009/07/03", "010-1234-5678", 24, "765455-99887766");
        cd[2].setData("이유환", "2007/04/11", "010-3232-8787", 25, "635675-22554433");
        cd[3].setData("박현우", "2004/12/08", "010-7766-4422", 24, "385451-54638991");
        cd[4].setData("신성영", "2003/06/22", "010-7755-6543", 28, "325648-94684681");

        ce[0].setInfo("박현우", "2020/06/12", "010-5555-6666", 24, "123123-11223344", "사장", "경영");
        ce[1].setInfo("카리나", "2000/01/02", "010-5422-8764", 22, "653544-9876346", "부장", "카운터");
        ce[2].setInfo("김민정", "2000/02/04", "010-3426-8637", 22, "876546-2332329", "직원", "매장관리");
        Scanner intScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);

        boolean flag = true;
        while(flag){
            System.out.println("=================================================================");
            System.out.print("1. 회원조회\n2. 회원검색\n3. 종료\n4. 추가 등록\n5. 상품구매\n6. 포인트 조회" +
                    "\n\n실행하고자 하는 메뉴의 번호를 입력하세요 : ");
            int menuNum = intScanner.nextInt();
            System.out.println("=================================================================");

            switch(menuNum){
                case 1:
                    System.out.println("고객번호\t고객이름\t가입날짜\t\t전화번호\t\t\t나이\t계좌번호");
                    for(int i = 0;i < cd.length;i++)
                        System.out.println(cd[i].getAllData());

                    break;
                case 2:
                    System.out.print("조회하고자 하는 회원의 이름을 입력하세요 : ");
                    String key = strScanner.nextLine();
                    System.out.println("=================================================================");
                    for(int i = 0;i < cd.length;i++) {
                        if (cd[i].getAllData().contains(key)) {
                            System.out.println(cd[i].getAllData());
                        }
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                case 4:
                    System.out.print("추가로 등록하고자 하는 회원수를 입력해주세요 : ");
                    int addCusNum = intScanner.nextInt();

                    CandyStoreCustomer[] newCd = new CandyStoreCustomer[cd.length + addCusNum];
                    for (int i = 0; i < newCd.length; i++) {
                        newCd[i] = new CandyStoreCustomer();
                        if (i < cd.length){
                            newCd[i] = cd[i];
                        }
                    }

                    int idx = cd.length;
                    while(idx < newCd.length ){
                        System.out.print("이름을 입력하세요 : ");
                        String name = strScanner.nextLine();

                        System.out.print("등록 일자를 입력하세요 : ");
                        String date = strScanner.nextLine();

                        System.out.print("나이를 입력하세요 : ");
                        int age = intScanner.nextInt();

                        System.out.print("휴대폰 번호를 입력하세요 : ");
                        String phoneNum = strScanner.nextLine();

                        System.out.print("계좌번호를 입력하세요 : ");
                        String account = strScanner.nextLine();
                        newCd[idx].setData(name, date, phoneNum, age, account);
                        idx++;
                    }

                    cd = newCd;
                    System.out.println("==============신규등록이 완료되었습니다.==============");
                    break;
                case 5:
                    System.out.print("구매하시는 고객님의 성함이 어떻게 되시나요 ? : ");
                    String cusName = strScanner.nextLine();

                    System.out.print("구매하시는 물품의 가격을 입력 : ");
                    int price = intScanner.nextInt();

                    for (int i = 0; i < cd.length; i++) {
                        if (cd[i].getAllData().contains(cusName)){
                            cd[i].setPoint(price);
                        }
                    }
                    break;
                case 6:
                    System.out.println("=================================================================");
                    System.out.print("조회하려는 고객의 이름을 입력하세요 : ");
                    String cusName2 = strScanner.nextLine();
                    for (int i = 0; i < cd.length; i++) {
                        if (cd[i].getAllData().contains(cusName2)){
                            cd[i].getPoint();
                        }
                    }
                    break;
            }
        }
    }
}

