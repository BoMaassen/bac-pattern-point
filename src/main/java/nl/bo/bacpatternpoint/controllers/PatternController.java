package nl.bo.bacpatternpoint.controllers;

import jakarta.validation.Valid;
import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.mappers.PatternMapper;
import nl.bo.bacpatternpoint.models.Image;
import nl.bo.bacpatternpoint.models.Pattern;
import nl.bo.bacpatternpoint.services.ImageService;
import nl.bo.bacpatternpoint.services.PatternService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/patterns")
public class PatternController {

    private final PatternService patternService;
    private final ImageService imageService;

    public PatternController(PatternService patternService, ImageService imageService) {
        this.patternService = patternService;
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<PatternResponseDto> createPattern(@Valid @RequestBody PatternCreateDto patternCreateDto) {
        PatternResponseDto responseDto = patternService.createPattern(patternCreateDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(responseDto.getId()).toUri();
        return ResponseEntity.created(location).body(responseDto);
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<PatternResponseDto> addImgToPattern(@Valid @PathVariable("id") Long patternId, @RequestBody MultipartFile file) throws IOException {
        String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/patterns/").path(Objects.requireNonNull(patternId.toString())).path("/image").toUriString();
        Image image = imageService.storeFile(file, url);
        Pattern pattern = patternService.addImg(patternId, image);
        return ResponseEntity.created(URI.create(url)).body(PatternMapper.toResponseDto(pattern));
    }


    @GetMapping
    public ResponseEntity<List<PatternResponseDto>> getPatterns() {
        List<PatternResponseDto> patternResponseDtos = patternService.getPatterns();
        return ResponseEntity.ok(patternResponseDtos);
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getPatternImg(@PathVariable("id") Long patternId) {
        Image image = patternService.getPatternImg(patternId);
        MediaType mediaType;
        try {
            mediaType = MediaType.parseMediaType(image.getContentType());
        } catch (InvalidMediaTypeException ignore) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }
        return ResponseEntity.ok().contentType(mediaType).header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + image.getTitle()).body(image.getContents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatternResponseDto> getPatternById(@PathVariable Long id) {
        PatternResponseDto patternResponseDto = patternService.getPatternById(id);
        return ResponseEntity.ok(patternResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatternResponseDto> updatePattern(@Valid @PathVariable Long id, @RequestBody PatternUpdateDto patternUpdateDto) {
        PatternResponseDto patternResponseDto = patternService.updatePattern(id, patternUpdateDto);
        return ResponseEntity.ok(patternResponseDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePattern(@PathVariable Long id) {
        boolean isDeleted = patternService.deletePattern(id);
        return ResponseEntity.noContent().build();
    }
}
