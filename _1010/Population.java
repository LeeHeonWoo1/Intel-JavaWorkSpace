package _1010;

import java.io.*;

public class Population {
    String[][] _2DArray;
    int localMax;
    int localMin;
    String[] age;

    public Population(){
        age = new String[21];

        int a = 0;
        for (int i = 0; i < 20; i++) {
            age[i] = a + "~" + (a+4) + "세";
            a += 5;
        }
        age[20] = "100세 이상";
    }

    public String[][] setData(String filepath){
        String result = "";
        try{
            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"CP949"));

            while(true){
                int data = r.read();
                if (data == -1) break;

                result += (char)data;
            }
            r.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        result = result.replaceAll("[^0-9\\uAC00-\\uD7A3\t\n() ]", "");
        String[] _1DArray = result.replace("\n", "\t").split("\t");
        _2DArray = new String[result.split("\n").length][result.split("\n")[0].split("\t").length];

        int idx = 0;
        for (int i = 0; i < _2DArray.length; i++) {
            for (int j = 0; j < _2DArray[i].length; j++) {
                if (j == 0) {
                    _2DArray[i][j] = _1DArray[idx].substring(0, _1DArray[idx].indexOf("("));
                    if (i == 0)
                        _2DArray[i][j] = "금정구";
                    else
                        _2DArray[i][j] = _2DArray[i][j].substring(_2DArray[i][j].lastIndexOf(" ")).replace(" ", "");
                    idx++;
                } else
                    _2DArray[i][j] = _1DArray[idx++];
            }
        }

        return _2DArray;
    }

    public void getData(){
//        System.out.println("\t\t행정기관\t\t\t");
        for (int i = 0; i < _2DArray.length; i++) {
            for (int j = 0; j < _2DArray[i].length; j++) {
                System.out.printf((_2DArray[i][0].length() < 5) ? "%10s" : "%9s", _2DArray[i][j]);
            }
            System.out.println();
        }
    }

    public void getMinMax() {
        int max = 0;
        int idx = 0;

        for (int i = 1; i < _2DArray.length; i++) {
            if (max < Integer.parseInt(_2DArray[i][1])) {
                max = Integer.parseInt(_2DArray[i][1]);
                idx = i;
            }
        }

        localMax = max;
        int min = localMax;
        int idx2 = 0;
        for (int i = 1; i < _2DArray.length; i++) {
            if (Integer.parseInt(_2DArray[i][1]) < min) {
                min = Integer.parseInt(_2DArray[i][1]);
                idx2 = i;
            }
        }

        localMin = min;
        System.out.println("가장 인구가 많은 곳은 " + _2DArray[idx][0] + "이며, 인구수는 " + max + "명 입니다.");
        System.out.println("가장 인구가 적은 곳은 " + _2DArray[idx2][0] + "이며, 인구수는 " + min + "명 입니다.");
    }

    public void getMinMaxIn(){
        System.out.println("지역\t\t\t   최대\t\t\t최소\t\t   최대연령대\t\t  최소연령대");
        for (int i = 1; i < _2DArray.length; i++) {
            int max = 0;
            int min = 0;
            int maxIdx = 0;
            int minIdx = 0;

            for (int j = 3; j < _2DArray[i].length; j++) {
                if(max < Integer.parseInt(_2DArray[i][j])) {
                    max = Integer.parseInt(_2DArray[i][j]);
                    maxIdx = j;
                }
            }

            for (int l = 3; l < _2DArray[i].length; l++) {
                if(Integer.parseInt(_2DArray[i][l-1]) > Integer.parseInt(_2DArray[i][l])) {
                    min = Integer.parseInt(_2DArray[i][l]);
                    minIdx = l;
                }
            }

            String local = (_2DArray[i][0].length() < 5) ? _2DArray[i][0] + "\t" : _2DArray[i][0];
            String localMax = (max > 999) ? max+"" : max + " ";
            System.out.println(local + "\t:  " +  localMax + "명        " + min + "명        " + age[maxIdx - 3] + "        " + age[minIdx-3]);
        }
    }

    public void minMaxPerAge(){
        int[] minIdx = new int[age.length];
        int[] maxIdx = new int[age.length];

        for (int i = 0; i < age.length; i++) {
            // 열 고정, 행을 달리하면서
            int min;
            int max = 0;

            for (int j = 1; j < _2DArray.length; j++) {
                if (max < Integer.parseInt(_2DArray[j][i+3])){
                    max = j;
                }
            }
            maxIdx[i] = max;

            min = max;
            for (int j = 1; j < _2DArray.length; j++) {
                if (Integer.parseInt(_2DArray[j-1][i+3]) > Integer.parseInt(_2DArray[j][i+3])){
                    min = j;
                }
            }
            minIdx[i] = min;
        }

        System.out.println("연령\t\t\t최소\t\t최대");
        for (int i = 0; i < age.length; i++) {
            String ageLocal = (age[i].length() < 6) ? age[i] + "       " : age[i] + "    ";
            System.out.println(ageLocal + _2DArray[minIdx[i]][0] + "\t\t" + _2DArray[maxIdx[i]][0]);
        }
    }
}
