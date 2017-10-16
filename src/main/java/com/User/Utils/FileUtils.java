package com.User.Utils;

import xyz.downgoon.snowflake.Snowflake;

import java.io.IOException;

public class FileUtils {

    public static void setFilePermission(String filePath)
    {
        try {
            Runtime.getRuntime().exec("chmod 777 "+filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //用于生成文件的名称
    public static String createUIDString(String fileName)
    {
        Snowflake snowflake = new Snowflake(30,20);
        String extension = fileName.substring(fileName.lastIndexOf("."));
        return String.valueOf(snowflake.nextId()) + extension;
    }
}
