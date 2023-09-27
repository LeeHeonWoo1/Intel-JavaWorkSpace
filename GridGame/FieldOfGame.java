package GridGame;

public class FieldOfGame {
    static String[][] feild = new String[30][40];
    static int locationX = 15;
    static int locationY = 0;
    static int userHp = 100;
    static int point = 0;

    public void setFeild(){
        for (int i = 0; i < feild.length; i++) {
            for (int j = 0; j < feild[i].length; j++) {
                feild[i][j] = "🟦";
            }
        }
    }

    public int getUserHp(){
        return userHp;
    }

    public void getFeild(){
        System.out.println(getLocation());
        for (int i = 0; i < feild.length; i++) {
            for (int j = 0; j < feild[i].length; j++) {
                System.out.print(feild[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void setLocation(){
        feild[locationX][locationY] = "🟥";
    }

    public String getLocation(){
        return "(" + locationX + ", " + locationY + ")";
    }

    public void moveY(int y, int sight){
        if (sight == 3){
            if (locationX > feild.length){
                System.out.println("벽에 가로막혀 지나갈 수 없습니다.");
            }else{
                feild[locationX][locationY] = "🟦";
                feild[locationX + y][locationY] = "🟥";
                locationX += y;
            }
        }else if (sight == 1){
            if (locationX == 0){
                System.out.println("벽에 가로막혀 지나갈 수 없습니다.");
            }else{
                feild[locationX][locationY] = "🟦";
                feild[locationX - y][locationY] = "🟥";
                locationX -= y;
            }
        }
    }
    public void moveX(int x, int sight){
        if (sight == 2){
            if (locationY > feild[0].length){
                System.out.print("벽에 가로막혀 지나갈 수 없습니다.");
            }else{
                feild[locationX][locationY] = "🟦";
                feild[locationX][locationY + x] = "🟥";
                locationY += x;
            }
        }else if (sight == 4){
            if (locationY == 0){
                System.out.print("벽에 가로막혀 지나갈 수 없습니다.");
            }else{
                feild[locationX][locationY] = "🟦";
                feild[locationX][locationY - x] = "🟥";
                locationY -= x;
            }
        }
    }

    public void getStation(){
        System.out.println("-------------상황발생-------------");
        if (locationY >= feild[0].length){
            System.out.println("전방은 막혀있는 상태입니다.");
        }else if (!(feild[locationX][locationY+1].equals("🟦"))){
            System.out.println("전방에 특별 요인이 존재합니다.");
        }

        if (locationY == 0){
            System.out.println("후방은 막혀있는 상태입니다.");
        }else if (!(feild[locationX][locationY-1].equals("🟦"))){
            System.out.println("후방에 특별 요인이 존재합니다.");
        }

        if (locationX >= feild.length){
            System.out.println("우측은 막혀있는 상태입니다.");
        }else if (!(feild[locationX+1][locationY].equals("🟦"))){
            System.out.println("우측에 특별 요인이 존재합니다.");
        }

        if (locationX == 0){
            System.out.println("좌측은 막혀있는 상태입니다.");
        }else if (!(feild[locationX-1][locationY].equals("🟦"))){
            System.out.println("좌측에 특별 요인이 존재합니다.");
        }
        System.out.println("---------------------------------");
    }
}
