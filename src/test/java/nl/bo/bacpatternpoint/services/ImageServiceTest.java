package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.models.Image;
import nl.bo.bacpatternpoint.repositories.ImageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImageServiceTest {

    @Mock
    private ImageRepository imageRepository;

    @InjectMocks
    private ImageService imageService;

    private Image mockImage;

    @BeforeEach
    void setUp() {
        mockImage = new Image(1L, "title", "url", "image/png" );
    }

    @Test
    void storeFile() {
    }

    @Test
    void getImageById() {
        when(imageRepository.findById(1L)).thenReturn(Optional.ofNullable(mockImage));

        Image image = imageService.getImageById(1L);

        assertEquals("title", image.getTitle());

    }
}