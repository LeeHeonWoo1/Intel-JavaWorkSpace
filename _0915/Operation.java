package _0915;

import java.util.Arrays;

public class Operation { // 계산을 하기 위한 클래스
    int factorial(int x){ // 팩토리얼을 구해주는 메소드
        int result = 1;
        for (int i = 1; i <= x; i++){
            result *= i;
        }
        return result;
    }

    // 직사각형의 가로 세로 넓이를 구해주는 메소드
    int getArea(int width, int height){ // 두 개의 인자값을 받아서
        return width * height; // 두 개를 곱한 값을 return 해준다.
    }

    float triangleArea(int width, int height){
        return (float) width*height/2;
    }

    int gcd(int x, int y) {
       if (x == y){
           return x;
       } else{
           int[] memArray = new int[x+y];
           int idx = 0;

           for (int i = 1; i < ((x > y) ? y : x); i++) {
               if ((x % i == 0) & (y % i == 0)){
                   memArray[idx] = i;
                   idx++;
               }
           }

           return Arrays.stream(memArray).max().getAsInt();
       }
    }

    int lcm(int x, int y) {
        int Gcd = gcd(x, y);
        return (x * y) / Gcd;
    }

    int[] minMax(String userInput){
        String[] inputArray = userInput.split(",");
        int compare;

        int max = 1;
        int min = 1;
        for (int i = 0; i < inputArray.length; i++) {
            compare = Integer.parseInt(inputArray[i]);
            if (max < compare){
                max = compare;
            }
            if (min > compare){
                min = compare;
            }
        }
        return new int[] {min, max};
    }

//    int lcd(int x, int y){
//        int[] lcdArray = new int[x+y];
//    }

}

