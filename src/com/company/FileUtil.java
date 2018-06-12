package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FileUtil {

    private static FileUtil instance;

    private FileUtil() {

    }


    public static FileUtil getInstance() {
        if (instance == null) {
            instance = new FileUtil();
        }
        return instance;
    }

    /**
     * 写文件
     */
    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter("F:/临时/temp.txt");
            fileWriter.write("Mike Mike@163.com");
            fileWriter.write("John John@163.com");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读文件
     * @param file
     * @return
     */
    public String readFile(File file) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(System.lineSeparator() + line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 下载网上图片资源
     */
    public void downloadFile() {
        int bytesum = 0;
        int byteread = 0;
        try {
            URL url = new URL("http://pimg.163.com/sms/micheal/logo.gif");
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("F:/临时/tempgif.gif");
            byte[] buffer = new byte[1444];
            int length = 0;
            while ((byteread = inputStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fileOutputStream.write(buffer, 0, byteread);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
