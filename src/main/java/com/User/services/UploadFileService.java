package com.User.services;

import com.User.Utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
@Service("uploadFileService")
public class UploadFileService
{
    static private Logger logger = LoggerFactory.getLogger(UploadFileService.class);
    //保存单个文件
    public String saveFilePath(MultipartFile multifile)
    {
        logger.debug("---------------------------");
        logger.debug(multifile.getName());
        logger.debug(multifile.getContentType());
        logger.debug(multifile.getOriginalFilename());
        logger.debug("---------------------------");
        String filePath = "/Users/vd/website/avatarImage/"+FileUtils.createUIDString(multifile.getOriginalFilename());
        File file = new File(filePath);
        try {
            file.setReadable(true);
            file.setWritable(true);
            file.setExecutable(true);
            multifile.transferTo(file);
            FileUtils.setFilePermission(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
