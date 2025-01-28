package nl.bo.bacpatternpoint.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.models.Image;
import nl.bo.bacpatternpoint.services.PostService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Base64;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

   @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<PostResponseDto> createPost(@RequestPart("postCreateDto") String postCreateDtoJson,
                                                      @RequestPart("files") List<MultipartFile> files) throws IOException {
       ObjectMapper objectMapper = new ObjectMapper();
       PostCreateDto postCreateDto = objectMapper.readValue(postCreateDtoJson, PostCreateDto.class);
        PostResponseDto responseDto = postService.createPost(postCreateDto, files);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(responseDto.getId()).toUri();

        return ResponseEntity.created(location).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getPosts(){
       List<PostResponseDto> postResponseDtos = postService.getPosts();

        return ResponseEntity.ok(postResponseDtos);
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getPostImg(@PathVariable("id") Long postId) {
        Image image = postService.getPostImg(postId);
        MediaType mediaType;

        try {
            mediaType = MediaType.parseMediaType(image.getContentType());
        } catch (InvalidMediaTypeException ignore) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }

        return ResponseEntity
                .ok()
                .contentType(mediaType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + image.getFileName())
                .body(image.getContents());
    }


    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable Long id){
        PostResponseDto postResponseDto = postService.getPostById(id);

        return ResponseEntity.ok(postResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(@Valid @PathVariable Long id, @RequestBody PostUpdateDto postUpdateDto){

        PostResponseDto postResponseDto = postService.updatePost(id, postUpdateDto);
        return ResponseEntity.ok(postResponseDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        boolean isDeleted = postService.deletePost(id);

        return ResponseEntity.noContent().build();
    }




}
