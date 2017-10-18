package com.User.services;

import com.User.Utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
@Service("uploadFileService")
public class UploadFileService
{
    static private Logger logger = LoggerFactory.getLogger(UploadFileService.class);
    static private final String  Photo_LocalPath = "/Users/vd/website/avatarImage/";
    static private  String Photo_Server_path;
    static
    {
        try {
            InetAddress address = InetAddress.getLocalHost();
            Photo_Server_path = address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
    //保存单个文件
    public List<String> saveFilePath(List<MultipartFile> multipartFiles,String secret)
    {
        List<String> fileList = new ArrayList<String>();
        String dirPath = Photo_LocalPath+secret;
        File dirFile = new File(dirPath);
        if(!dirFile.exists())
        {
            dirFile.mkdir();
            dirFile.setReadable(true);
            dirFile.setWritable(true);
            dirFile.setExecutable(true);
            FileUtils.setFilePermission(dirPath);
        }
        for (MultipartFile multifile:multipartFiles)
        {
            String fileName = FileUtils.createUIDString(multifile.getOriginalFilename());
            String path = dirPath+"/"+fileName;
            File file = new File(path);
            try {
                multifile.transferTo(file);
                FileUtils.setFilePermission(path);
                file.setReadable(true);
                file.setWritable(true);
                file.setExecutable(true);
                fileList.add(Photo_Server_path+"/"+"avatarImage"+"/"+secret+"/"+fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileList;
    }
}
