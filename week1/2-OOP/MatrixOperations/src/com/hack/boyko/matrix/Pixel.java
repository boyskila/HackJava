package com.hack.boyko.matrix;

public class Pixel {

    private float r;
    private float g;
    private float b;

    public Pixel(float r, float g, float b) {

        this.r = r;
        this.g = g;
        this.b = b;

    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public Pixel() {
    }

    @Override
    public String toString() {
        return (int)r + " " + (int)g + " " + (int)b;
    }
}