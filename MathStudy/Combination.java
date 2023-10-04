package MathStudy;

public class Combination implements Percentage{
    Permutation per = new Permutation();

    public int oper(int x, int y){
        int result;
        int r = 1;

        for (int i = y; i >= 1 ; i--)
            r *= i;

        result = per.oper(x, y) / r;

        return result;
    }
}
