package com.boyko.downloadfile;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DownLoadFileUsingJava {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws MalformedURLException, IOException {
        try (BufferedInputStream in = new BufferedInputStream(new URL(
                "http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg").openStream())) {
            FileOutputStream fout = new FileOutputStream(
                    "C:\\Users\\Bojko\\workspace\\Week4_DownloadFileUsinJava\\JackAndCoke.jpg");
            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        }
    }
}
