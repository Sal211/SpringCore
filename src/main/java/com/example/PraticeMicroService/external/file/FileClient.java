package com.example.PraticeMicroService.external.file;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "fileUploadClient", url = "${file.url}")
public interface FileClient {
    @PostMapping(value = "/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Headers("Content-Type: multipart/form-data")
    String uploadFile(@RequestPart ("file") MultipartFile file, @RequestPart("id") Long id);
}
