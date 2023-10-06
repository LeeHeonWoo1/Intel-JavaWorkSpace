package _1006;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteText {
    public static void main(String[] args) {
        try{
            Writer w = new FileWriter("./_1006/test3.txt");
            char a = 'A';
            w.write(a);
            char b = 'B';
            w.write(b);

            char[] arr =  {'C', 'D', 'E'};
            w.write(arr);

            w.write("안녕하세요!");

            w.flush();
            w.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
