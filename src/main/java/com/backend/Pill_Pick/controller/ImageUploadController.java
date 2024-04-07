package com.backend.Pill_Pick.controller;

import com.backend.Pill_Pick.text.DetectText;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin("*")
@RestController
public class ImageUploadController {


    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile image) {
        // Process the uploaded image (e.g., save it to a storage location)
        // For demonstration purposes, just print the filename

        System.out.println("Uploaded image filename: " + image.getOriginalFilename());
       try {
           DetectText.detectText(image);
       }
       catch (Exception e)
       {
           System.out.println(e);
       }// Return a success response
        return ResponseEntity.ok().body("Image uploaded successfully");

    }
}
