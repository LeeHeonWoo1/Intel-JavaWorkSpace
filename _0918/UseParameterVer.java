package _0918;

public class UseParameterVer {
    int[] arr;

    public UseParameterVer(String inputData){
        inputData = inputData.replaceAll("[^0-9,]", "");
        String[] inputArray = inputData.split(",");
        arr = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            arr[i] = Integer.parseInt(inputArray[i]);
        }
    }

    void printArray(){
        System.out.print("생성된 배열 : ");
        for(int i : this.arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

    // 메소드 오버로딩
    // 아래의 경우 매개변수가 늘어날 수록 계속해서 오버로딩을 진행해야 한다.
    // 이런 경우 가변인자를 사용하면 편하게 정의할 수 있다.
    int sum(int x, int y){
        return x + y;
    }
    int sum(int x, int y, int z){
        return x + y + z;
    }
    double sum(double ... values){ // 주의할 점으로는, 가변인자로 들어가게 되면 배열로 들어가게 된다.
        double result = 0;
        for (double i : values){
            result += i;
        }

        return result;
    }


    int arraySum(){
        int result = 0;
        for(int i : this.arr){
            result += i;
        }

        return result;
    }
}
