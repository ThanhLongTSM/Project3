package com.example.web_sell_fruit.other;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UpLoadFile {
//    public static final String URL_IMAGES = "C:\\Users\\thesh\\OneDrive\\Máy tính\\ \\Project 3\\Project 3\\src\\main\\resources\\static\\images\\";
    public static final String URL_IMAGES = "src/main/resources/static/images";

    public static void saveFile(MultipartFile multipartFile, String urlImage) {
        File file = new File(URL_IMAGES + urlImage);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String urlImage) {
        File file = new File(URL_IMAGES + urlImage);
        if (file.delete())
            System.out.println("Xoa thanh cong");
        else {
            System.out.println("Xoa That Bai");
        }

    }
}
