package _1006;

import java.io.*;

public class WriteByteArray {
    public static void main(String[] args) {
        try{
            OutputStream os = new FileOutputStream("./_1006/test2.db.bak");

            byte[] arr = {10, 20, 30};

            os.write(arr);
            os.flush();
            os.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
