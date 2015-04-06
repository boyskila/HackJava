package com.hack.boyko.matrix;

public class MatrixTest {

    public static void main(String[] args) {
        Matrix pixelMatrix = new Matrix(4, 4, new Pixel(10f, 20f, 30f));
        pixelMatrix.set(1, 1, new Pixel(0,0,0));
        pixelMatrix.operate(new GaussionFilter());
        System.out.println(pixelMatrix.toString());
        pixelMatrix.operate(new BrightnessEffect());
        System.out.println(pixelMatrix.toString());
    }
}