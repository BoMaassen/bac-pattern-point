package nl.bo.bacpatternpoint.services;

import jakarta.transaction.Transactional;
import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.mappers.ImageMapper;
import nl.bo.bacpatternpoint.mappers.PostMapper;
import nl.bo.bacpatternpoint.models.Image;
import nl.bo.bacpatternpoint.models.Post;
import nl.bo.bacpatternpoint.repositories.ImageRepository;
import nl.bo.bacpatternpoint.repositories.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final ImageRepository imageRepository;

    public PostService(PostRepository postRepository, ImageRepository imageRepository) {
        this.postRepository = postRepository;
        this.imageRepository = imageRepository;
    }

    public PostResponseDto createPost(PostCreateDto postCreateDto, List <MultipartFile> files) throws IOException {
        Post post = PostMapper.toEntity(postCreateDto);
        Post savedPost = postRepository.save(post);

        List<Image> imageList = new ArrayList<>();

        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }

            String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/posts/")
                    .path(Objects.requireNonNull(postCreateDto.getTitle()))
                    .path("/image/")
                    .path(Objects.requireNonNull(file.getOriginalFilename()))
                    .toUriString();

            String filename = file.getOriginalFilename();
            String contentType = file.getContentType();
            byte[] bytes = file.getBytes();

            Image image = new Image(filename, url, contentType, bytes, post);
            Image savedImage = imageRepository.save(image);
            imageList.add(savedImage);

        }
        post.setImages(imageList);
        return PostMapper.toResponseDto(savedPost);
    }


    public PostResponseDto updatePost(Long id, PostUpdateDto postUpdateDto){
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Geen post gevonden met id " + id));

        post.setTitle(postUpdateDto.getTitle());
        post.setCategory(postUpdateDto.getCategory());
        post.setDescription(postUpdateDto.getDescription());
        post.setDraft(postUpdateDto.isDraft());

        Post updatedPost = postRepository.save(post);

        return PostMapper.toResponseDto(updatedPost);

    }

    public PostResponseDto getPostById(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Geen post gevonden met id " + id));

        return PostMapper.toResponseDto(post);
    }

    public List<PostResponseDto> getPosts(){
        List<Post> posts = postRepository.findAll();
        return PostMapper.toResponseDtoList(posts);
    }

    public boolean deletePost(Long id){
        postRepository.deleteById(id);

        return true;
    }

    @Transactional
    public Image getPostImg(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isEmpty()){
            throw new RuntimeException("Post met nummer " + postId + " niet gevonden.");
        }
        List<Image> images = optionalPost.get().getImages();
        if (images.isEmpty()) {
            throw new RuntimeException("Geen afbeeldingen gevonden voor post " + postId);
        }

        return images.get(0);
    }




}
