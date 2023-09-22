package _0921;

import java.util.Scanner;

public class CandyStoreDataPlay {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CandyStoreBudget budget = CandyStoreBudget.getInstance();
        Inventory inv = Inventory.getInstance();
        CandyCustomerInfo[] cc = new CandyCustomerInfo[5];
        CandyStoreEmployee[] cse = new CandyStoreEmployee[3];
        String op;
        String key;
        boolean runFlag = true;
        boolean noData = true;
        int sum;

        // 위에서 생성한 빈 레퍼런스들을 채운다.
        for (int i = 0; i < cc.length; i++)
            cc[i] = new CandyCustomerInfo();
        for (int i = 0; i < cse.length; i++)
            cse[i] = new CandyStoreEmployee();

        // 고객 정보 초기값 생성
        cc[0].setInfo("이헌우", "2010/05/01", "010-1111-2222", 60, "121212-34343434");
        cc[1].setInfo("주재원", "2009/07/03", "010-1234-5678", 65, "765455-99887766");
        cc[2].setInfo("박희민", "2007/04/11", "010-3232-8787", 70, "635675-22554433");
        cc[3].setInfo("손지혜", "2004/12/08", "010-7766-4422", 69, "385451-54638991");
        cc[4].setInfo("박현석", "2003/06/22", "010-7755-6543", 77, "325648-94684681");

        // 직원 정보 초기값 생성
        cse[0].setInfo("박진영", "2000/01/01", "010-0000-0000", 50, "432311-7647653", "사장", "경영");
        cse[1].setInfo("류진", "2000/01/02", "010-5422-8764", 49, "653544-9876346", "부장", "카운터");
        cse[2].setInfo("예지", "2000/02/04", "010-3426-8637", 44, "876546-2332329", "직원", "매장관리");

        // while 문 내에서 서비스가 계속 동작할 수 있게 하고
        while (runFlag) {
            System.out.print(">>");
            op = scan.next();

            switch (op) {
                case "종료":
                    runFlag = false;
                    break;

                case "명령어조회":
                    System.out.println("고객전체조회 직원전체조회 고객검색 직원검색 구매 판매 포인트조회 직원별실적조회 전체판매실적조회 직급변경");
                    break;

                case "고객전체조회":
                    System.out.println("고객번호\t고객이름\t가입날짜\t\t전화번호\t\t나이\t계좌번호");
                    for (int i = 0; i < cc.length; i++)
                        System.out.println(cc[i].getAllInfo());
                    break;

                case "직원전체조회":
                    System.out.println("직원번호\t직원이름\t입사날짜\t\t전화번호\t\t나이\t계좌번호\t\t직급\t당당업무");
                    for (int i = 0; i < cse.length; i++)
                        System.out.println(cse[i].getAllInfo());
                    break;

                case "고객검색":
                    System.out.print("고객이름 : ");
                    key = scan.next();
                    for (int i = 0; i < cc.length; i++)
                        if (cc[i].getName().equals(key)) {
                            System.out.println(cc[i].getAllInfo());
                            noData = false;
                        }
                    if (noData)
                        System.out.println("대상이 없습니다.");
                    noData = true;

                    break;

                case "직원검색":
                    System.out.print("직원이름 : ");
                    key = scan.next();
                    for (int i = 0; i < cse.length; i++)

                        if (cse[i].getName().equals(key)) {
                            System.out.println(cse[i].getAllInfo());
                            noData = false;
                        }
                    if (noData)
                        System.out.println("대상이 없습니다.");
                    noData = true;
                    break;

                case "거래":
                    System.out.print("판매한 직원이름 : ");
                    key = scan.next();
                    for (int i = 0; i < cse.length; i++)
                        if (cse[i].getName().equals(key))
                            cse[i].doSale();

                    System.out.print("구매한 고객이름 : ");
                    key = scan.next();
                    System.out.print("구매한 과일 이름 : ");
                    String fruit = scan.next();
                    System.out.print("구매한 과일 개수 : ");
                    int cnt = scan.nextInt();
                    for (int i = 0; i < cc.length; i++)
                        if (cc[i].getName().equals(key)) {
                            boolean result = inv.doPurchase(fruit, cnt);
                            cc[i].doPurchase(result);
                        }
                    budget.doDeposit(4000);
                    break;

                case "포인트조회":
                    System.out.print("고객이름 : ");
                    key = scan.next();
                    for (int i = 0; i < cc.length; i++)
                        if (cc[i].getName().equals(key))
                            System.out.println(cc[i].getPoint() + "점 입니다.");
                    break;

                case "전체고객등급조회":
                    for (int i = 0; i < cc.length; i++)
                        System.out.println(cc[i].getName() + "\t" + cc[i].getLevel());
                    break;

                case "직원별실적조회":
                    System.out.print("직원이름 : ");
                    key = scan.next();
                    for (int i = 0; i < cse.length; i++)
                        if (cse[i].getName().equals(key))
                            cse[i].showSalePerform();
                    break;

                case "전체판매실적조회":
                    sum = 0;
                    for (int i = 0; i < cse.length; i++) {
                        sum += cse[i].getSalePerform();
                        cse[i].showSalePerform();
                    }
                    System.out.println("전체 " + sum + "개 판매하였습니다.");
                    break;

                case "잔고조회":
                    System.out.println(budget.getBalance() + "원 입니다.");
                    break;

                case "월급지급":
                    System.out.print("직원이름 : ");
                    key = scan.next();
                    for (int i = 0; i < cse.length; i++)
                        if (cse[i].getName().equals(key))
                            cse[i].giveSalary();
                    break;

                case "직급변경":
                    System.out.print("직원이름 : ");
                    key = scan.next();
                    for (int i = 0; i < cse.length; i++)
                        if (cse[i].getName().equals(key)) {
                            System.out.print("변경할 직급 : ");
                            String pos = scan.next();
                            cse[i].setPosition(pos);
                            System.out.println(cse[i].getName() + "의 직급이 " + cse[i].getPosition() + "으로 변경되었습니다.");
                        }
                    break;

                case "재고조회":
                    System.out.println("딸기 : " + inv.getStawberry() + "개");
                    System.out.println("샤인머스킷 : " + inv.getShineMusket() + "개");
                    System.out.println("포도 : " + inv.getGrape() + "개");
                    System.out.println("귤 : " + inv.getTangerine() + "개");
                    break;

                case "재고입고":
                    System.out.println("과일 :");
                    key = scan.next();
                    System.out.println("수량 :");
                    sum = scan.nextInt();
                    inv.store(key, sum);
                    break;

                case "":

                default:
                    System.out.println("이해할 수 없는 명령입니다.");
            }
        }

        System.out.println("종료되었습니다.");
    }
}
