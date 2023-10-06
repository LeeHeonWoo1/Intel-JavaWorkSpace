package _1006;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadText {
    public static void main(String[] args) {
        try {
            Reader r = null;
            r = new FileReader("./_1006/test3.txt");

            while (true) {
                int data = r.read();
                if (data == -1) break;

                System.out.print((char) (data));
            }

            r.close();


        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
