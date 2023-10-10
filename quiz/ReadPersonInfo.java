package quiz;

import java.io.*;
import java.util.Scanner;

public class ReadPersonInfo {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);

        boolean flag = true;

        while(flag){
            System.out.println("--------------실행화면--------------");
            System.out.print("1. 입력\n2. 전체출력\n3. 검색\n4. 삭제\n5. 종료\n\n실행할 메뉴의 번호를 입력하세요 >> ");
            int menu = intScanner.nextInt();
            switch (menu){
                case 1:
                    System.out.print("등록할 사람의 수를 입력하세요 : ");
                    int personCnt = intScanner.nextInt();
                    String info = "";

                    while(personCnt > 0){
                        System.out.println("--------------회원 등록을 시작합니다.--------------");
                        System.out.print("이름을 입력하세요 : ");
                        String name = strScanner.nextLine();

                        System.out.print("전화번호를 -를 포함하여 입력하세요 : ");
                        String phone = strScanner.nextLine();

                        System.out.print("주소를 입력하세요 : ");
                        String address = strScanner.nextLine();

                        info += name + "," + phone + "," + address + "\n";
                        personCnt--;
                    }

                    System.out.println("---------------입력을 완료했습니다.---------------");
                    try{
                        Writer os = new FileWriter("quiz/person_info.txt", true);

                        os.write(info);
                        os.flush();
                        os.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try{
                        Reader r = new FileReader("quiz/person_info.txt");
                        String infoData = "";

                        while(true){
                            int data = r.read();
                            if (data == -1) break;

                            infoData += (char)data;
                        }

                        r.close();
                        infoData = infoData.replace(",", " ");
                        int dataCnt = infoData.split("\n").length;
                        System.out.println("이름" + "\t  " + "전화번호" + "\t\t" + "주소");
                        System.out.print(infoData);
                        System.out.println();
                        System.out.println(dataCnt + "개의 자료를 출력했습니다.");

                    }catch (FileNotFoundException f){
                        f.printStackTrace();
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                    break;

                case 3:
                    System.out.print("조회할 인원의 이름을 입력하세요 : ");
                    String name = strScanner.nextLine();

                    try{
                        Reader r1 = new FileReader("quiz/person_info.txt");
                        String infoData2 = "";

                        while(true){
                            int data = r1.read();
                            if (data == -1) break;

                            infoData2 += (char)data;
                        }

                        r1.close();
                        String[] _1dArray = infoData2.replace("\n", ",").split(","); // 1차원 배열을 생성하고
                        String[][] _2dArray = new String[_1dArray.length/3][3]; // 각 회차별로 쪼개기 위해 2차원 배열 생성

                        int idx = 0;                                            // 인덱스값을 위한 초기값
                        for (int i = 0; i < _2dArray.length; i++) {             // 행의 길이만큼 순회하고
                            for (int j = 0; j < _2dArray[i].length; j++) {      // 열의 길이만큼 순회하면서
                                _2dArray[i][j] = _1dArray[idx++];               // 각 행의 열에 값을 채워넣되, idx를 지속적으로 증가시킨다.
                            }
                        }

                        String result2 = "";                                      // 결과를 담을 초기값 생성
                        for (int i = 0; i < _2dArray.length; i++) {              // 행의 길이만큼 순회하고
                            for (int j = 0; j < _2dArray[i].length; j++) {       // 열의 길이만큼 순회하면서
                                if (_2dArray[i][0].equals(name)) {   // 각 열의 첫 번째 값이 회차이므로, 그 회차가 사용자가 입력한 값과 같다면
                                    for (int k = 0; k < _2dArray[i].length; k++) // 해당 행의 모든 열을 순회하면서
                                        result2 += (k < _2dArray[i].length - 1) ? _2dArray[i][k] + " " : _2dArray[i][k]; // 초기값에 각 값을 더한다.
                                    break; // 그리고 찾았다면 더이상 반복문을 돌 필요가 없기에 break
                                }
                            }
                        }

                        if (result2.equals(""))
                            System.out.println("❌ 존재하지 않는 회원입니다. ❌");
                        else {
                            System.out.println("----------------------------------");
                            System.out.println(result2);
                            System.out.println("----------------------------------");
                        }
                    }catch (FileNotFoundException f){
                        f.printStackTrace();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    System.out.print("삭제하려는 인원의 이름을 입력하세요 : ");
                    String key = strScanner.nextLine();

                    try{
                        Reader reader = new FileReader("quiz/person_info.txt");

                        String result = "";
                        String newData = "";

                        while(true){
                            int data = reader.read();
                            if (data == -1) break;

                            result += (char)data;
                        }
                        reader.close();

                        if (result.contains(key)) {
                            Writer writer = new FileWriter("quiz/person_info.txt");
                            int keysIndex = result.indexOf(key);
                            result = result.replace(result.substring(keysIndex, result.indexOf("\n", keysIndex) + 1), "");
                            result = result.substring(0, result.lastIndexOf("\n") + 1);

                            writer.write(result);
                            System.out.println("삭제를 완료했습니다.");
                            writer.flush();
                            writer.close();
                        }else{
                            System.out.println("찾고자 하는 인원의 정보가 없습니다.");
                        }

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                break;

                case 5:
                    flag = false;
                    break;

            }
        }
    }
}
