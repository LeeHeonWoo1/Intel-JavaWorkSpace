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

            str = str.replace("\n", "").replaceAll("[^0-9,]", ",");
            String[] _1dArray = str.split(",");
            String[][] _2dArray = new String[_1dArray.length/8][8];

            int idx = 0;
            for (int i = 0; i < _2dArray.length; i++) {
                for (int j = 0; j < _2dArray[i].length; j++)
                    _2dArray[i][j] = _1dArray[idx++];
            }

            String result = "";
            for (int i = 0; i < _2dArray.length; i++) {
                for (int j = 0; j < _2dArray[i].length; j++) {
                    if (Integer.parseInt(_2dArray[i][0]) == num) {
                        for (int k = 1; k < _2dArray[i].length; k++)
                            result += (k < _2dArray[i].length - 1) ? _2dArray[i][k] + ", " : _2dArray[i][k];
                        break;
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
