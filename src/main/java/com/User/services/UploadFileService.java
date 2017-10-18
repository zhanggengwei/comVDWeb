package com.User.services;

import com.User.Utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Service("uploadFileService")
public class UploadFileService
{
    static private Logger logger = LoggerFactory.getLogger(UploadFileService.class);
    static private final String  Photo_Server_LocalPath = "/Users/vd/website/avatarImage/";

    //保存单个文件
    public List<String> saveFilePath(List<MultipartFile> multipartFiles,String secret)
    {
        List<String> fileList = new ArrayList<String>();
        String dirPath = Photo_Server_LocalPath+secret;
        if(!new File(dirPath).exists())
        {
            new File(dirPath).mkdir();
        }
        for (MultipartFile multifile:multipartFiles)
        {
            String filePath = dirPath + "/" + FileUtils.createUIDString(multifile.getOriginalFilename());
            File file = new File(filePath);
            try {
                file.setReadable(true);
                file.setWritable(true);
                file.setExecutable(true);
                multifile.transferTo(file);
                FileUtils.setFilePermission(filePath);
                fileList.add(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileList;
    }
}
