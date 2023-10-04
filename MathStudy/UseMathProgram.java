package MathStudy;

public class UseMathProgram {
    public static void main(String[] args) {
        Percentage oper;

        oper = new Combination();
        System.out.println(oper.oper(4, 2));;

        oper = new Permutation();
        System.out.println(oper.oper(4, 4));

        oper = new DupPermutation();
        System.out.println(oper.oper(4, 4));
    }
}
