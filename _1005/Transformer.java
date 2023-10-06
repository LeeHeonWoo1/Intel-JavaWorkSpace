package _1005;

public class Transformer {
    public char[] transform(int x, int userInput) {
        String result = "";

        if (x == 2 || x == 8) {
            while (userInput >= 1) {
                result += userInput % x;
                userInput /= x;
            }
        } else {
            while (userInput >= 1) {
                int remain = userInput % 16;

                if (remain >= 10)
                    result += (char) (remain + 55);
                else
                    result += remain;

                userInput /= 16;
            }
        }

        char[] arr = result.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--)
            System.out.print(arr[i]);

        return arr;
    }

    public int power(int x, int y) {
        int result = 1;

        if (y == 0)
            return 1;

        for (int i = 0; i < y; i++)
            result *= x;

        return result;
    }

    public void inverseTransform(int x, String userInput) {
        int result = 0;
        char[] arr = userInput.toCharArray();

        int idx = arr.length - 1;

        if (x == 2 || x == 8) {
            for (int i = 0; i < arr.length; i++) { // 배열의 길이만큼 순회하면서
                if ((int)(arr[idx]) - 48 != 0)
                    result += power(x, i) * ((int)(arr[idx]) - 48);

                idx--;
            }
        }else{
            for (int i = 0; i < arr.length; i++) { // 배열의 길이만큼 순회하면서
                if ((int) (arr[idx]) >= 65) {
                    result += power(x, i) * ((int) (arr[idx]) - 55);
                    idx--;
                }else{
                    result += power(x, i) * ((int) (arr[idx]) - 48);
                    idx--;
                }
            }
        }

        System.out.println(result);
    }
}
