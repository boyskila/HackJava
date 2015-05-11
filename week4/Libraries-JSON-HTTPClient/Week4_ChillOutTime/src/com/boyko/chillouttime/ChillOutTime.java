package com.boyko.chillouttime;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;

public class ChillOutTime {
    public static void main(String[] args) throws IOException, InterruptedException {
        Toaster toasterManager = new Toaster();
        BufferedImage img = ImageIO.read(new File("C:\\Users\\Bojko\\Desktop\\dog.jpg"));
        toasterManager.setToasterWidth(img.getWidth());
        toasterManager.setToasterHeight(img.getHeight());
        toasterManager.setBackgroundImage(img);
        toasterManager.setMessageColor(Color.RED);
        toasterManager.setDisplayTime(5000);
        int c = 0;
        while (c < 10) {
            c++;
            toasterManager.showToaster("Eat KitCat");
            Thread.sleep(2700000);
        }
    }
}
