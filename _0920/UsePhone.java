package _0920;

public class UsePhone {

    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone("아이폰13", "스페이스 그레이");

        System.out.println("모델 :" + sp.model);
        System.out.println("색상 :" + sp.color);

        System.out.println("와이파이 상태 :" + sp.wifi);

        sp.bell();
        sp.sendVoice("여보세요?");
        sp.receiveVoice("나야 나 !");
        sp.sendVoice("하이하이~");
        sp.hangUp();

        sp.setWifi(true);
        System.out.println("와이파이 상태 :" + sp.wifi);
        sp.internet();
    }

}
