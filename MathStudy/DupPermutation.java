package MathStudy;

public class DupPermutation implements Percentage{
    public int oper(int x, int y){
        int result = 1;
        for (int i = 0; i < y; i++)
            result *= x;

        return result;
    }
}
