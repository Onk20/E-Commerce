package com.ecommerce.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        //Get the File names of original file name
        String originalFileName = file.getOriginalFilename();

        //Rename the file uniquely (Generate a unique filename)
        String randomId = UUID.randomUUID().toString();
        // mat.jpg --> 1234.jpg
        String fileName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));
        String filePath = path + File.separator + fileName;

        //check if path exists or create
        File folder = new File(path);
        if(!folder.exists()){
            folder.mkdir();
        }
        //Upload to server
        Files.copy(file.getInputStream(), Paths.get(filePath));

        //return file name
        return fileName;

    }
}
