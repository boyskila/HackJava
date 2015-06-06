public class MainMatrix {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[][] A = MatrixOperations.fillMatrix(4);
        int[][] B = MatrixOperations.fillMatrix(4);
        System.out.println(MatrixOperations.printMatrix(A));
        System.out.println(MatrixOperations.printMatrix(B));
       int[][] result = MatrixOperations.multiplyMatrices(A, B);
      //  int[][] C = MatrixOperations.multi(A, B);
       // System.out.println(MatrixOperations.printMatrix(C));
        System.out.println(MatrixOperations.printMatrix(result));
        long end = System.currentTimeMillis() ;
        System.out.println(end-start);
    }
}
