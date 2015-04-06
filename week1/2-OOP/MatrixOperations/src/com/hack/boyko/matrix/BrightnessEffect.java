package com.hack.boyko.matrix;

public class BrightnessEffect implements MatrixOperation {

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        Pixel pixel = matrix[x][y];
        float r = pixel.getR() + 5f;
        float g = pixel.getG() + 5f;
        float b = pixel.getB() + 5f;

        return new Pixel(r, g, b);
    }

}
