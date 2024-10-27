package com.example.PraticeMicroService.controller;

import com.example.PraticeMicroService.dtos.BaseResponse;
import com.example.PraticeMicroService.external.EcomConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecom")
public class EcomController {

    @Autowired
    private EcomConsumer ecomConsumer;

    @GetMapping("/test")
    public BaseResponse<String> pings(){
        return  ecomConsumer.ping();
    }

    @PostMapping("/post/{name}")
    public BaseResponse<String> postProduct(@PathVariable("name") String name){
        return ecomConsumer.postProduct(name);
    }
}
