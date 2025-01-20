package nl.bo.bacpatternpoint.controllers;

import jakarta.validation.Valid;
import nl.bo.bacpatternpoint.dtos.ImageCreateDto;
import nl.bo.bacpatternpoint.dtos.PostCreateDto;
import nl.bo.bacpatternpoint.dtos.PostResponseDto;
import nl.bo.bacpatternpoint.dtos.PostUpdateDto;
import nl.bo.bacpatternpoint.models.Image;
import nl.bo.bacpatternpoint.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

   @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@Valid @RequestBody PostCreateDto postCreateDto){
        PostResponseDto responseDto = postService.createPost(postCreateDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(responseDto.getId()).toUri();

        return ResponseEntity.created(location).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getPosts(){
       List<PostResponseDto> postResponseDtos = postService.getPosts();

        return ResponseEntity.ok(postResponseDtos);
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
