package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
//文件上传映射中心
@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result Controllerupload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传:{},{},{}", username, age, image);
        String OriginalFilename = image.getOriginalFilename();//获取原始文件名
        int index = OriginalFilename.lastIndexOf(".");//找到文件名最后的.所在的位置
        String extname = OriginalFilename.substring(index);//开始切割
        String newFileName = UUID.randomUUID().toString() + extname;//拼接
        image.transferTo(new File("D:\\images\\" + newFileName));//存放至本地文件夹
        return Result.success();

    }
}
