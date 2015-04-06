package com.hack.boyko.matrix;

public class GrayScale implements MatrixOperation {

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
//final int lum = (int)(0.2126 * red + 0.7152 * green + 0.0722 * blue);???
        Pixel pixel = matrix[x][y];
        float pixelAvarage = (pixel.getR() + pixel.getG() + pixel.getB()) / 3;
        return new Pixel(pixelAvarage, pixelAvarage, pixelAvarage);
    }
}
