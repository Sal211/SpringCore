package com.example.PraticeMicroService.external.ecom;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "ecomClient", url = "${ecom.server.url}")
public interface EcomClient {

    @GetMapping("/ping")
    String ping();

    @PostMapping("/postProduct/{name}")
    String postProduct(@PathVariable("name") String name);
}
