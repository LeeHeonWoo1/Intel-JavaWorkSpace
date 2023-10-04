package MathStudy;

public class Permutation implements Percentage{
    public int oper(int x, int y){
        int result = 1;
        if (x == y){
            for (int i = x; i >= 1; i--)
                result *= i;

        }else if (x == 0 || y == 0){
            result = 1;
        } else {
            int n = 1, r = 1;

            for (int i = x; i >= 1 ; i--)
                n *= i;

            for (int i = x - y; i >= 1 ; i--)
                r *= i;

            result = n/r;
        }

        return result;
    }
}
