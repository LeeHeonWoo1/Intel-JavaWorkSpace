package _0922;

public class Inventory {
    private static int starwberry = 0;
    private static int shineMusket = 0;
    private static int grape = 0;
    private static int tangerine = 0;

    public void setStore(int starw, int shine, int grap, int tanger){
        starwberry += starw;
        shineMusket += shine;
        grape += grap;
        tangerine += tanger;

        System.out.println("입고 완료");
    }
    public void getStore(){
        System.out.println("--------------------------------");
        System.out.println( "딸기 : " + starwberry + "개\n" + "샤인 머스켓 : " + shineMusket + "개\n" + "포도 : " +
                grape + "개\n" + "귤 : " + tangerine + "개");
        System.out.println("--------------------------------");
    }

    public int getStarwberryCnt(){
        return starwberry;
    }
    public int getShineMusketCnt(){
        return shineMusket;
    }
    public int getGrapeCnt(){
        return grape;
    }
    public int getTangerineCnt(){
        return tangerine;
    }

    public int[] getFruitCntArr(){
        return new int[]{starwberry, shineMusket, grape, tangerine};
    }
}
