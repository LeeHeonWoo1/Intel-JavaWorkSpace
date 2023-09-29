package _0927;

import _0918.MatrixMachine;

public class VectorMachine {
    double[] vector; // 벡터 정의

    VectorMachine(int size) { // 생성자에서는 인자값으로 정수를 넘겨주면
        this.vector = new double[size]; // 인자값에 해당하는 사이즈만큼 벡터 배열을 생성한다.
    }

    VectorMachine(String str){ // 생성자 오버로딩을 통해 사용자에게서 입력을 받은 문자열을

        String[] strV = str.replaceAll("[^0-9,]", "").split(","); // 숫자와 콤마를 제외하고 모두 제거하여 ,를 기준으로 split을 하고
        this.vector = new double[strV.length];

        for(int i=0;i<this.vector.length;i++) // 벡터 배열의 길이만큼 순회하면서
            this.vector[i] = Double.parseDouble(strV[i]); // Double로 형전환한 값으로 값을 채운다.
    }

    public void setVector(VectorMachine x) { // setVector 메소드에서는
        System.arraycopy(x.vector, 0, this.vector, 0, x.vector.length); // class객체를 받아 카피를 진행하고

    }

    void showVector() { //벡터 출력
        for(int i=0;i < this.vector.length;i++)
            System.out.print(this.vector[i] + " ");
        System.out.println();
    }

    double getVectorLen() { //벡터 크기
        int sum = 0;
        for(int i=0;i < this.vector.length;i++)
            sum += this.vector[i] * this.vector[i];

        return Math.sqrt(sum);
    }

    VectorMachine getUnitVertor() { //단위벡터
        VectorMachine result = new VectorMachine(this.vector.length);

        for(int i=0;i < this.vector.length;i++) {
            result.vector[i] = this.vector[i] / this.getVectorLen();
        }

        return result;
    }

    public double getDotProduct(VectorMachine vm) { //내적

        double result = 0;

        for(int i=0;i < this.vector.length;i++)
            result += this.vector[i]*vm.vector[i];

        return result;
    }

    public double getAngle(VectorMachine vm) {

        double result = this.getDotProduct(vm) / (this.getVectorLen()*vm.getVectorLen());

        return Math.toDegrees(Math.acos(result)) ;
    }

    VectorMachine MulVector(double v) {
        VectorMachine result = new VectorMachine(this.vector.length);

        for(int i=0;i < result.vector.length;i++)
            result.vector[i] = this.vector[i] * v;

        return result;
    }

    VectorMachine projection(VectorMachine vm) { //정사영
        return vm.MulVector(this.getDotProduct(vm)/vm.getDotProduct(vm));
    }

    VectorMachine getFirstTrans(String op) {

        VectorMachine res = new VectorMachine(this.vector.length);
        switch(op) {
            case "origin" :
                res.setVector(this);
                res.vector[0] *= -1;
                res.vector[1] *= -1;
                break;
            case "x" :
                res.setVector(this);
                res.vector[1] *= -1;
                break;
            case "y" :
                res.setVector(this);
                res.vector[0] *= -1;
                break;
        }
        return res;
    }
}
