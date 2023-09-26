package GridGame;

public class SituationHandler extends FieldOfGame{
    public void isTrapped(int grid, int sight){
        if (sight == 1){
            if(feild[locationX - grid][locationY].equals("🧨")){
                userHp -= 10;
                System.out.println("함정에 빠져들었습니다. hp가 10 감소합니다.");
            }
        }else if(sight == 3){
            if(feild[locationX + grid][locationY].equals("🧨")){
                userHp -= 10;
                System.out.println("함정에 빠져들었습니다. hp가 10 감소합니다.");
            }
        }else if (sight == 2){
            if(feild[locationX][locationY + grid].equals("🧨")){
                userHp -= 10;
                System.out.println("함정에 빠져들었습니다. hp가 10 감소합니다.");
            }
        }else {
            if(feild[locationX][locationY - grid].equals("🧨")){
                userHp -= 10;
                System.out.println("함정에 빠져들었습니다. hp가 10 감소합니다.");
            }
        }
    }

    public void isEscape(int grid, int sight){
        if (sight == 1){
            if(feild[locationX - grid][locationY].equals("🛟"))
                System.out.println("탈출에 성공하였습니다. 게임을 종료합니다.");
        }else if(sight == 3){
            if(feild[locationX + grid][locationY].equals("🛟"))
                System.out.println("탈출에 성공하였습니다. 게임을 종료합니다.");
        }else if (sight == 2){
            if(feild[locationX][locationY + grid].equals("🛟"))
                System.out.println("탈출에 성공하였습니다. 게임을 종료합니다.");
        }else {
            if(feild[locationX][locationY - grid].equals("🛟"))
                System.out.println("탈출에 성공하였습니다. 게임을 종료합니다.");
        }
    }

    public void fight(){

    }

    public void isEncounter(int grid, int sight){
        if (sight == 1){
            if(feild[locationX - grid][locationY].equals("👿"))
                System.out.println("탈출에 성공하였습니다. 게임을 종료합니다.");
        }else if(sight == 3){
            if(feild[locationX + grid][locationY].equals("👿"))
                System.out.println("탈출에 성공하였습니다. 게임을 종료합니다.");
        }else if (sight == 2){
            if(feild[locationX][locationY + grid].equals("👿"))
                System.out.println("탈출에 성공하였습니다. 게임을 종료합니다.");
        }else {
            if(feild[locationX][locationY - grid].equals("👿"))
                System.out.println("탈출에 성공하였습니다. 게임을 종료합니다.");
        }
    }
}
