package _1006;

import java.io.FileInputStream; // 아래의 super class를 상속한 sub class. OutputStream도 동일.
import java.io.InputStream; // super class
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadByte {
    public static void main(String[] args) {
        try{
            InputStream fis = new FileInputStream("./_1006/test.md");

            byte[] data = new byte[100];
            while(true){
                int num = fis.read(data);
                if (num == -1) break; // -1은 파일의 끝을 의미한다.

                for (int i = 0; i < num; i++)
                    System.out.println(data[i]);
            }

            fis.close();
        }catch(FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
