package GridGame;

public class FieldOfGame {
    String[][] feild = new String[30][40];
    static int locationX = 15;
    static int locationY = 0;
    static int userHp = 100;
    String swap;

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
            if (locationX >= feild.length){
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
            if (locationY >= feild[0].length){
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
}
