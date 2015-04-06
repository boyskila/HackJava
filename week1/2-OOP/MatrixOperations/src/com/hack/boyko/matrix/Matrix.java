package com.hack.boyko.matrix;

public class Matrix {

    private Pixel[][] matrix;

    public Matrix(int col, int row, Pixel pixel) {

        this.matrix = new Pixel[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                matrix[i][j] = pixel;
            }
        }
    }

    public void set(int x, int y, Pixel p) {
        matrix[x][y] = p;
    }

    public void operate(MatrixOperation operation) {

        Pixel[][] changedMatrix = new Pixel[this.matrix.length][this.matrix[0].length];

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {

                changedMatrix[i][j] = operation.withPixel(i, j, this.matrix);
            }
        }
        this.matrix = changedMatrix;
    }

    @Override
    public String toString() {

        StringBuilder theMatrix = new StringBuilder();
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {

                theMatrix.append(this.matrix[i][j].toString() + "  ");
            }
            theMatrix.append("\n");
        }
        return theMatrix.toString();
    }

}
