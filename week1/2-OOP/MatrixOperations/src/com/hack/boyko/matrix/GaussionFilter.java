package com.hack.boyko.matrix;

public class GaussionFilter implements MatrixOperation {
    double[][] kernel;

    GaussionFilter() {
        kernel = createKernel(3);
    }

    static double[][] createKernel(int size) {

        double sigma = 2;

        double[][] kernel = new double[size][size];
        double mean = size / 2;
        float sum = 0.0f;

        for (int x = 0; x < size; ++x)

            for (int y = 0; y < size; ++y) {

                kernel[x][y] = Math.exp(-0.5 * (Math.pow((x - mean) / sigma, 2.0) + Math.pow((y - mean) / sigma, 2.0)))
                        / (2 * Math.PI * sigma * sigma);

                sum += kernel[x][y];
            }

        for (int x = 0; x < size; ++x)
            for (int y = 0; y < size; ++y)
                kernel[x][y] /= sum;

        return kernel;
    }

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        
        int size = kernel.length;
        int size2 = kernel.length / 2;
        int xtop = x - size2;
        int ytop = y - size2;
        float sumR = 0, sumG = 0, sumB = 0, sumKernel = 0;
        for (int xx = 0; xx < size; xx++)
            for (int yy = 0; yy < size; yy++) {
                int x1 = xtop + xx;
                int x2 = ytop + yy;
                if (x1 >= 0 && x2 >= 0 && x1 < matrix[0].length && x2 < matrix.length) {
                    Pixel p = matrix[x2][x1];
                    double k = kernel[yy][xx];
                    sumR += p.getR() * k;
                    sumG += p.getG() * k;
                    sumB += p.getB() * k;
                    sumKernel += k;
                }
            }

        return new Pixel(sumR / sumKernel, sumG / sumKernel, sumB / sumKernel);
    }
}
