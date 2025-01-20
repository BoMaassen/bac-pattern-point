package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.dtos.PostCreateDto;
import nl.bo.bacpatternpoint.dtos.PostResponseDto;
import nl.bo.bacpatternpoint.dtos.PostUpdateDto;
import nl.bo.bacpatternpoint.mappers.PostMapper;
import nl.bo.bacpatternpoint.models.Post;
import nl.bo.bacpatternpoint.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDto createPost(PostCreateDto postCreateDto){
        Post savedPost = postRepository.save(PostMapper.toEntity(postCreateDto));

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





}
