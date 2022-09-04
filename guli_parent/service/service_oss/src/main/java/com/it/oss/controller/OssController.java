package com.it.oss.controller;


import com.it.commonutils.R;
import com.it.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {


    @Autowired
    private OssService ossService;

    //上传头像的方法
    @PostMapping()
    public R uploadOssFile(MultipartFile file){
        //返回上传的oss路径
        String url=ossService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }
}
