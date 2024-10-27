package com.example.PraticeMicroService.external;

import com.example.PraticeMicroService.dtos.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcomConsumer {

    @Autowired
    private EcomClient ecomClient;

    public BaseResponse<String> ping(){
        BaseResponse<String> response = new BaseResponse<>();
        try{
            response.setStatus(true);
            response.setData(ecomClient.ping());
        }catch (Exception e){
            response.setData(e.getMessage());
            response.setStatus(false);
        }
        return response;
    }

    public BaseResponse<String> postProduct(String name){
        BaseResponse<String> response = new BaseResponse<>();
        try{
            response.setStatus(true);
            response.setData(ecomClient.postProduct(name));
        }catch (Exception e){
            response.setData(e.getMessage());
            response.setStatus(false);
        }
        return response;
    }

}
