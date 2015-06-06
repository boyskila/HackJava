public class MyThread implements Runnable {
    private int[][] matrixA;
    private int[][] matrixB;
    private int row;
    private int col;

    public MyThread(int row, int col, int[][] matrixA, int[][] matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.row = row;
        this.col = col;
    }

    @Override
    public void run() {
        int number = 0;
        for (int j = 0; j < matrixB.length; j++) {
            number += matrixA[row][j] * matrixB[j][col];
            MatrixOperations.resultMatrix[row][col] = number;
        }
    }
}
