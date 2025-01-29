package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.exception.RecordNotFoundException;
import nl.bo.bacpatternpoint.models.Image;
import nl.bo.bacpatternpoint.repositories.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image storeFile(MultipartFile file, String url) throws IOException {

        String originalFileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        byte[] bytes = file.getBytes();

        Image image = new Image(originalFileName, url, contentType , bytes);

        return imageRepository.save(image);
    }

    public Image getImageById(Long id){
        return imageRepository.findById(id).orElseThrow( () -> new RecordNotFoundException("Afbeelding met id " + id + " niet gevonden"));
    }
}


