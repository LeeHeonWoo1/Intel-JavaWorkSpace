package GridGame;

import java.util.Random;

public class SetEnvironment extends FieldOfGame{
    public void setEscape(){
        Random random = new Random();

        int randomX = random.nextInt(feild.length);
        int randomY = random.nextInt(feild[0].length);
        feild[randomX][randomY] = "🛟";
    }

    public void setTrap(int cnt){
        Random random = new Random();
        for (int i = 0; i < cnt; i++) {
            int randomX = random.nextInt(feild.length);
            int randomY = random.nextInt(feild[0].length);

            feild[randomX][randomY] = "🧨";
        }
    }

    public void setBossLocation(int cnt){
        Random random = new Random();
        for (int i = 0; i < cnt; i++) {
            int randomX = random.nextInt(feild.length);
            int randomY = random.nextInt(feild[0].length);

            feild[randomX][randomY] = "👿";
        }
    }
}
