package _1006;

import java.io.FileOutputStream;
import java.io.IOException;

public class HandlingFiles {
    public static void main(String[] args) {
        // DB든 파일처리든 예외처리를 자주 사용한다.
        // 내부장치에서 외부장치로 연결 시 스트림이 열리고, 연결 후 작업이 완료되면 스트림을 닫아야하는데,
        // 닫기 전에 예외가 발생하여 오류가 발생하면 스트림이 계속 열린 상태로 유지된다.
        // 이렇게되면 보안에도 취약하지만, 메모리를 지속적으로 잡아먹기에 예외처리는 거의 필수이다.

        // 스트림을 통해 데이터를 주고받을때는 버퍼 메모리에 저장된다.
        try{
            FileOutputStream fos = new FileOutputStream("./_1006/test.md");

            byte a = 10;
            byte b = 20;
            byte c = 30;

            fos.write(a);
            fos.write(b);
            fos.write(c);

            fos.flush(); // 버퍼 메모리에 담긴 데이터들을 모두 전송하고 비운다.
            fos.close(); // 연결을 해제하고

        }catch (IOException e){ // 만약 에러가 발생하면
            e.printStackTrace(); // 발생한 내역을 확인할 수 있다.
        }
    }
}
