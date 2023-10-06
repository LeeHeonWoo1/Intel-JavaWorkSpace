package _1006;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class SearchLotteryData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = "";

        System.out.print("검색할 회차의 번호를 입력하세요 : ");
        int num = scan.nextInt();

        try{
            Reader r = new FileReader("C:/Users/OWNER/Desktop/lotteryData.csv");

            while(true){
                int data = r.read();
                if (data == -1) break;

                str += (char)data;
            }

            // 1차적으로 줄바꿈 기호를 제거하고, 숫자와 콤마를 제외한 문자들은 ,로 split하기 위해서 ,로 변경
            str = str.replace("\n", "").replaceAll("[^0-9,]", ",");
            String[] _1dArray = str.split(",");               // 1차원 배열을 생성하고
            String[][] _2dArray = new String[_1dArray.length/8][8]; // 각 회차별로 쪼개기 위해 2차원 배열 생성

            int idx = 0;                                            // 인덱스값을 위한 초기값
            for (int i = 0; i < _2dArray.length; i++) {             // 행의 길이만큼 순회하고
                for (int j = 0; j < _2dArray[i].length; j++)        // 열의 길이만큼 순회하면서
                    _2dArray[i][j] = _1dArray[idx++];               // 각 행의 열에 값을 채워넣되, idx를 지속적으로 증가시킨다.
            }

            String result = "";                                      // 결과를 담을 초기값 생성
            for (int i = 0; i < _2dArray.length; i++) {              // 행의 길이만큼 순회하고
                for (int j = 0; j < _2dArray[i].length; j++) {       // 열의 길이만큼 순회하면서
                    if (Integer.parseInt(_2dArray[i][0]) == num) {   // 각 열의 첫 번째 값이 회차이므로, 그 회차가 사용자가 입력한 값과 같다면
                        for (int k = 1; k < _2dArray[i].length; k++) // 해당 행의 모든 열을 순회하면서
                            result += (k < _2dArray[i].length - 1) ? _2dArray[i][k] + ", " : _2dArray[i][k]; // 초기값에 각 값을 더한다.
                        break; // 그리고 찾았다면 더이상 반복문을 돌 필요가 없기에 break
                    }
                }
            }

            if (result.equals(""))
                System.out.println("해당 회수에 대한 번호를 찾지 못했습니다.");
            else
                System.out.println(num+"회의 당첨 번호는 [" + result + "]입니다.");

            r.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
