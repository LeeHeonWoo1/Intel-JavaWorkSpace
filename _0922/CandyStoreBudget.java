package _0922;

public class CandyStoreBudget extends Inventory{
    private int budget = 1_000_000_000;
    private int strawPrice = 3000;
    private int shinePrice = 4500;
    private int grapePrice = 3000;
    private int tangerPrice = 4000;

    public int getBudget(){
        return budget;
    }

    public void lossBudget(int ... values){
        int sum = 0;
        int[] priceList = this.getPriceList();
        for (int i = 0; i < values.length; i++) {
            sum += priceList[i]*values[i];
        }

        budget -= sum;
    }

    private int[] getPriceList(){
        return new int[]{strawPrice, shinePrice, grapePrice, tangerPrice};
    }

    public int perchase(int ... fruitCnt){
        String[] fruits = new String[]{"딸기", "샤인머스켓", "포도", "귤"};
        int[] result = new int[fruitCnt.length];
        int[] storeArr = this.getFruitCntArr();

        for (int i = 0; i < fruitCnt.length; i++)
            if (fruitCnt[i] != 0 && fruitCnt[i] < storeArr[i]){
                result[i] = i+1;
            }else{
                result[i] = 0;
                System.out.println("죄송합니다 "+fruits[i]+"은(는) 현재 품절로, 구매하실 수 없습니다.");
            }

        int[] priceList = this.getPriceList();
        int totalPrice = 0;
        System.out.println("----------------------------------------------");
        System.out.println("                    거래전표                    ");
        System.out.println("----------------------------------------------");
        System.out.println("상품명\t\t가격\t\t\t\t상품수량\t\t가격");
        System.out.println("----------------------------------------------");

        for(int i : result){
            if (i-1 != -1){
                if(fruits[i-1].equals("샤인머스켓")){
                    System.out.printf("%s\t%d\t\t\t%d\t\t\t%d\n", fruits[i-1], priceList[i-1], fruitCnt[i-1], priceList[i-1]*fruitCnt[i-1]);
                }else{
                    System.out.printf("%s\t\t\t%d\t\t\t%d\t\t\t%d\n", fruits[i-1], priceList[i-1], fruitCnt[i-1], priceList[i-1]*fruitCnt[i-1]);
                }
                totalPrice += priceList[i-1]*fruitCnt[i-1];
            }
        }

        System.out.println("----------------------------------------------");
        System.out.println("                    구매금액                    ");
        System.out.println("----------------------------------------------");
        System.out.printf("                     %d                    \n", totalPrice);
        System.out.println("----------------------------------------------");

        budget += totalPrice;

        return totalPrice;
    }
}
