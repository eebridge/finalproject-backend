package edu.iu.eebridge.finalproject.controllers;


import edu.iu.eebridge.finalproject.model.Flower;
import edu.iu.eebridge.finalproject.repository.FlowerFileRepository;
import edu.iu.eebridge.finalproject.repository.FlowerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/flowers")
public class FlowerController {
    private FlowerRepository flowerRepository;
    private FlowerFileRepository flowerFileRepository;

    public FlowerController(FlowerRepository flowerRepository, FlowerFileRepository flowerFileRepository) {
        this.flowerRepository = flowerRepository;
        this.flowerFileRepository = flowerFileRepository;
    }

    @GetMapping
    public Iterable<Flower> getAll() {
        return flowerRepository.findAll();
    }

    @PostMapping("/add")
    public Flower add(@RequestBody Flower flower) {
        try {
            return flowerRepository.save(flower);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/{id}/image")
    public boolean uploadImage(@PathVariable int id,
                               @RequestParam MultipartFile file) {
        try {
            return flowerFileRepository.uploadImage(id, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<?> getImage(@PathVariable int id) {
        try {
            byte[] image = flowerFileRepository.getImage(id);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .contentType(MediaType.IMAGE_PNG)
                    .body(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
