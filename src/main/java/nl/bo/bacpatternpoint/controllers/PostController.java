package nl.bo.bacpatternpoint.controllers;

import jakarta.validation.Valid;
import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.mappers.PostMapper;
import nl.bo.bacpatternpoint.models.Image;
import nl.bo.bacpatternpoint.models.Post;
import nl.bo.bacpatternpoint.services.ImageService;
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
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final ImageService imageService;


    public PostController(PostService postService, ImageService imageService) {
        this.postService = postService;
        this.imageService = imageService;
    }


   @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@Valid @RequestBody PostCreateDto postCreateDto)  {

        PostResponseDto responseDto = postService.createPost(postCreateDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(responseDto.getId()).toUri();

        return ResponseEntity.created(location).body(responseDto);
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<PostResponseDto> addImgToPost(@Valid @PathVariable("id") Long postId,
                                                       @RequestBody MultipartFile file) throws IOException{
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/posts/")
                .path(Objects.requireNonNull(postId.toString()))
                .path("/image")
                .toUriString();

        Image image = imageService.storeFile(file, url);

        Post post = postService.addImg(postId, image);


        return ResponseEntity.created(URI.create(url)).body(PostMapper.toResponseDto(post));
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
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + image.getTitle())
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
