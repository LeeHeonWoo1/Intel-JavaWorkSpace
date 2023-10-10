package quiz;

import java.io.*;
import java.util.Scanner;

public class HandlePersonInfo {
    String name;
    String phone;
    String address;
    Scanner intScanner = new Scanner(System.in);
    Scanner strScanner = new Scanner(System.in);

    public void modData(){
        String info2 = "";
        try{
            Reader r3 = new FileReader("quiz/person_info.txt");

            while(true){
                int data = r3.read();
                if(data == -1) break;

                info2 += (char)data;
            }

            r3.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.print("수정할 속성을 입력하세요\n1. 이름\n2. 전화번호\n3. 주소\n\n >> ");
        int propNum = intScanner.nextInt();

        System.out.print("수정 대상의 값을 입력하세요 : ");
        String originValue = strScanner.nextLine();

        System.out.print("변경할 속성값을 입력하세요 : ");
        String newValue = strScanner.nextLine();

        String[] _1DArray = info2.replace("\n", ",").split(",");
        String[][] personInfos = new String[info2.split("\n").length][3];

        int idx = 0;
        for (int i = 0; i < personInfos.length; i++)
            for (int j = 0; j < personInfos[i].length; j++)
                personInfos[i][j] = _1DArray[idx++];

        for (int i = 0; i < personInfos.length; i++)
            for (int j = 0; j < personInfos[i].length; j++)
                if (personInfos[i][propNum-1].equals(originValue))
                    personInfos[i][propNum-1] = newValue;

        String newData = "";
        for (int i = 0; i < personInfos.length; i++) {
            for (int j = 0; j < personInfos[i].length; j++) {
                newData += (j < personInfos[i].length - 1) ? personInfos[i][j] + "," : personInfos[i][j];
            }
            newData += "\n";
        }

        try{
            Writer w2 = new FileWriter("quiz/person_info.txt");

            w2.write(newData);
            w2.flush();
            w2.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void delData(String key){
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
    }

    public void searchData(String key){
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

            String result2 = "";                                     // 결과를 담을 초기값 생성
            for (int i = 0; i < _2dArray.length; i++) {              // 행의 길이만큼 순회하고
                for (int j = 0; j < _2dArray[i].length; j++) {       // 열의 길이만큼 순회하면서
                    if (_2dArray[i][0].equals(key)) {   // 각 열의 첫 번째 값이 이름이므로, 그 이름이 사용자가 입력한 값과 같다면
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
    }

    public void readAllData(){
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
    }

    public void writeData(int personCnt){
        String info = "";

        while(personCnt > 0){
            System.out.println("--------------회원 등록을 시작합니다.--------------");
            System.out.print("이름을 입력하세요 : ");
            name = strScanner.nextLine();

            System.out.print("전화번호를 -를 포함하여 입력하세요 : ");
            phone = strScanner.nextLine();

            System.out.print("주소를 입력하세요 : ");
            address = strScanner.nextLine();

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
    }

}
