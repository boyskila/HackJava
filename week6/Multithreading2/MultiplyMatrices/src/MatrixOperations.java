import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixOperations {

    public static int resultMatrix[][];

    public static int[][] fillMatrix(int size) {
        Random random = new Random();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }

    public static String printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static int[][] multi(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                for (int k = 0; k < A.length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        resultMatrix = new int[A.length][B.length];
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                Runnable t = new MyThread(i, j, A, B);
                executor.execute(t);
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        return resultMatrix;
    }
}
