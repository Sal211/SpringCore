package com.example.PraticeMicroService.external.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FileClientConsumer {
    private final FileClient fileClient;

    public String uploadFile(MultipartFile file, Long id) {
        try{
            return fileClient.uploadFile(file, id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

}
