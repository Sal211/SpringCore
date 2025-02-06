package com.example.PraticeMicroService.controller;

import com.example.PraticeMicroService.dtos.BaseResponse;
import com.example.PraticeMicroService.external.ecom.EcomConsumer;
import com.example.PraticeMicroService.external.file.FileClientConsumer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

@RestController
@RequestMapping("/ecom")
public class MicroController {

    @Autowired
    private EcomConsumer ecomConsumer;

    @Autowired
    private FileClientConsumer fileClientConsumer;

    @GetMapping("/test")
    public BaseResponse<String> pings(){
        return  ecomConsumer.ping();
    }

    @PostMapping("/post/{name}")
    public BaseResponse<String> postProduct(@PathVariable("name") String name){
        return ecomConsumer.postProduct(name);
    }

    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile file, Long id) {
        return fileClientConsumer.uploadFile(file, id);
    }

    @PostMapping("/uploadImg")
    public String uploadFile(HttpServletRequest httpServletRequest) {
        var getMultipart = ((StandardMultipartHttpServletRequest) httpServletRequest).getMultiFileMap();
        MultipartFile file = getMultipart.getFirst("file");
        String id = httpServletRequest.getParameter("id");
        return fileClientConsumer.uploadFile(file, Long.valueOf(id));
    }
}
