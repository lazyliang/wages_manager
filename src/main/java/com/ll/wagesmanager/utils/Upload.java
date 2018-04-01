package com.ll.wagesmanager.utils;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Create by ll on 2018/4/1.
 */
public class Upload {

    public static String upLoadFile(MultipartFile multipartFile, String path) throws IOException {
        String fileName=multipartFile.getOriginalFilename();
        String newName=getRandomFileName()+fileName.substring(fileName.lastIndexOf('.'));
        File upload = new File(path+newName);
        multipartFile.transferTo(upload.getCanonicalFile());
        return newName;
    }

    public static ResponseEntity download(String path ) throws IOException {
        File file = new File(path);
        Resource resource = new FileSystemResource(file);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+resource.getFilename()+"\"")
                .body(resource);

    }

    public static String getRandomFileName() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return rannum + str;// 当前时间
    }

}

