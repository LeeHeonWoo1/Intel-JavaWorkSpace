package _1005;

public class Transformer {
    public void transform(int x, int userInput){
        String result = "";

        while(userInput >= 1){
            result += userInput % x;
            userInput /= x;
        }

        char[] arr = result.toCharArray();
        for (int i = arr.length - 1; i >=0  ; i--)
            System.out.print(arr[i]);
    }
}
