package _0921;

public class Singleton {
    private static Singleton ss = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return ss;
    }
}
