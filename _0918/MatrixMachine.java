package _0918;

public class MatrixMachine {
    int[][] matrix;
    int rowCnt;
    int colCnt;
    final int[][] idenMat; // 행렬을 축을 기준으로 변환할 때 단위행렬을 사용한다.

    public MatrixMachine(String userInput){
        /*
          {{1, 2, 3}, {4, 5, 6}} 등의 형태의 문자열을 받아 행렬로 전환하는 클래스입니다.
         */
        this.rowCnt = userInput.split("}").length;
        this.colCnt = userInput.substring(1, userInput.indexOf("}") + 1).split(",").length;

        if (rowCnt != colCnt){
            System.out.println("정방행렬이 아니기에 단위 행렬을 생성할 수 없습니다.");
        }

        idenMat = new int[rowCnt][colCnt];
        for (int i = 0; i < rowCnt; i++) {
            for (int j = 0; j < colCnt; j++) {
                if (i == j) {
                    idenMat[i][j] = 1;
                } else {
                    idenMat[i][j] = 0;
                }
            }
        }

        matrix = new int[rowCnt][colCnt];
        String[] onlyInt = userInput.replaceAll("[^0-9,-]", "").split(",");

        int idx = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(onlyInt[j + idx]);
            }
            idx += colCnt;
        }
    }

    public MatrixMachine(int[][] userInput){
        matrix = new int[userInput.length][userInput[0].length];

        System.arraycopy(userInput, 0, matrix, 0, userInput.length);

        idenMat = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    idenMat[i][j] = 1;
                } else {
                    idenMat[i][j] = 0;
                }
            }
        }
    }

    void showMatrix(){
        for (int i = 0; i < matrix.length; i++) {
            System.out.print((i == 0 ? "┌" : (i < matrix.length - 1 ? "|" : "└")));
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("\t" + matrix[i][j] + "\t");
            }
            System.out.print((i == 0 ? "┐" : (i < matrix.length - 1 ? "|" : "┘")));
            System.out.println();
        }
    }

    void showIdenMat(){
        for (int i = 0; i < idenMat.length; i++) {
            System.out.print((i == 0 ? "┌" : (i < idenMat.length - 1 ? "|" : "└")));
            for (int j = 0; j < idenMat[i].length; j++) {
                System.out.print("\t" + idenMat[i][j] + "\t");
            }
            System.out.print((i == 0 ? "┐" : (i < idenMat.length - 1 ? "|" : "┘")));
            System.out.println();
        }
    }

    int[][] addMatrix(MatrixMachine x){
        if (this.rowCnt != x.rowCnt || this.colCnt != x.colCnt) {
            System.out.println("두 행렬간의 형상이 달라 연산을 수행할 수 없습니다..");
            return null;
        }
        int[][] result = new int[x.rowCnt][x.colCnt];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[i][j] + x.matrix[i][j];
            }
        }
        return result;
    }

    int[][] mulMatrix(int userInput){
        int[][] result = new int[this.rowCnt][this.colCnt];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = userInput * matrix[i][j];
            }
        }
        return result;
    }

    // 내가 풀었던 방식
    int[][] mulMatrix(MatrixMachine x){
        if (this.colCnt != x.rowCnt){
            System.out.println("입력한 행렬1의 열의 수와 행렬2의 행의 개수는 같아야 합니다.");
            return null;
        }
        int[][] result = new int[this.rowCnt][x.colCnt];

        for (int i = 0; i < this.rowCnt; i++) {
            int idx = 0; // 인덱스 증감을 위한 변수
            for (int j = 0; j < x.colCnt; j++) {
                int value = 0; // 합계를 담을 변수

                for (int k = 0; k < this.colCnt; k++) { // 행렬1의 열 개수만큼 연산 시행
                    value += matrix[i][k] * x.matrix[k][idx];
                }
                idx ++; // 인덱스 증가
                result[i][j] = value; // 위치에 값 할당
            }
        }
        return result;
    }

    // 강사님 버전(훨씬 간결하다 !)
    int[][] mulMatrix1(MatrixMachine x){
        if (this.colCnt != x.rowCnt){
            System.out.println("입력한 행렬1의 열의 수와 행렬2의 행의 개수는 같아야 합니다.");
            return null;
        }
        int[][] result = new int[this.rowCnt][x.colCnt];

        for (int i = 0; i < this.rowCnt; i++) {
            for (int j = 0; j < x.colCnt; j++) {
                for (int k = 0; k < this.colCnt; k++) { // 행렬1의 열 개수만큼 연산 시행
                    result[i][j] += matrix[i][k] * x.matrix[k][j];
                }
            }
        }
        return result;
    }

    int[][] T(){
        int[][] result = new int[colCnt][rowCnt];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrix[j][i];
            }

        }

        return result;
    }

}
